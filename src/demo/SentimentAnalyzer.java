/*
Sentiment Analysis: Mining Pros & Cons ~ Putting String Class to Test

Here is an exciting exercise where we will put few methods in String class into practice. In this exercise, we perform something called sentiment analysis. Sentiment analysis is a pretty hot area right now and there are books and start-ups just dedicated to this area. Sentiment analysis is about mining (discovering) sentiments or opinions expressed in online reviews of entities like restaurants, hotels, books etc. In this exercise, we will implement an extremely simple version of such a project. To understand the specification for this exercise, let's just consider restaurant reviews. Restaurant reviews mainly contain opinions on features such as service, ambiance, individual food items, car parking etc. Goal of this exercise is to find opinions on such different features in a given review, i.e., for each feature we find if the review expresses a positive or a negative opinion or no opinion at all. Essentially, we are finding whether the reviewer (person who wrote the review) considers a feature as a pro (+ve opinion) or con (-ve opinion) of the restaurant. 

The algorithm that you will implement uses something called language patterns. For example, let's consider the below review:

"Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive"

In this review, as shown in bold font, opinions are expressed on two features: service & food. For both the features, positive opinions are expressed using words like fantastic & delicious. Here there are two language patterns:

1) {feature} was {opinion} e.g., food was delicious

2) {opinion} {feature} e.g, fantastic service

Your code should look for these two patterns in a given review for each feature & opinion combination, which are provided as input. These two patterns are pretty good (I have used them in a production environment) and there are several other patterns that can be employed. Below are technical details: 

A class called SentimentAnalyzer.java has been provided, which includes the template code that you will fill. Additional instructions for implementing the exercise are provided in the code. Some tips are also provided in the code in the form of comments. The class includes following methods and if needed you can add more methods too:

public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords): This is the main method that will be first invoked. Below is the sample data for passing to this method. main() method is also included and it has the sample data for you.

    String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

    String[][] featureSet = { 

                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" }, 
                { "food" }, 
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } }; ~ 2D array with features

Each entry in the above 2D array corresponds to a feature and the entry also includes other variations like synonyms, other commonly used words for that feature, and also misspelled words (e.g., ambience). In your code, if opinion is found for atleast one word in an entry, then move to the next entry, i.e., next feature. For e.g., if an opinion was found for "ice cream", then you don't have to try with next word "desert" and can move to next entry "food".

        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" }; ~ these are positive opinion words
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" }; ~ these are negative opinion words

        Output: [0, 0, 1, 0, 1] for the above review

        The output is an int array that corresponds to features. First element with value 0 implies that no opinion was found for first feature ambiance. Third element with value 1 implies that a positive opinion was found for feature food (we can see that review has the text "food was delicious!"). The element should be -1 if the opinion is negative.

Here are the rest of the methods:

private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords): Invoked from detectProsAndCons

         - This method will invoke the following two methods. Code has some extra information too

private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords): In this method, you will look for the first pattern {feature} was {opinion}. Here feature is provided as input and you will use the input opinion words to look for the pattern in the given review. There are some instructions provided for this method in the comments right above method

private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords): In this method, you will look for the second pattern {opinion} {feature}

Both the above methods return 1 for positive opinion, -1 for negative opinion, and 0 when no opinion could be found

 */
package demo;

import java.util.Arrays;

class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
					  String[] negOpinionWords) {
	int[] featureOpinions = new int[featureSet.length]; // output
	outer: for(int i = 0; i < featureSet.length; i++ ){
	    for(String feature:featureSet[i]){
		if(review.contains(feature)){
		    featureOpinions[i] = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
		    continue outer;
		}
	    }
	    
	    featureOpinions[i] = 0;
	}
	return featureOpinions;
    }

    // First invoke checkForWasPhrasePattern and 
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
	
	int opinion = 0;
	opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
	if(opinion == 0) {
	    opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
	}
	return opinion;
	
    }
    
    public static String clean(String word){
        word = word.trim();
        word = word.replaceAll("\\.", "");
	word = word.replaceAll("!", "");
	word = word.replaceAll(",", "");
	word = word.toLowerCase();
        return word;
    }
    
    public static String getWasOp(String review, String pattern){
	int start = review.indexOf(pattern);
	int length = pattern.length();
        int end = start + length;
        String rev_arr[] = review.substring(end).split(" ");
        String op = rev_arr[0];
	op = clean(op);
	return op;
    }
    
    public static String getOpFirstOp(String sentence, String feature){
        int end = sentence.indexOf(feature);
	String str_arr[]= sentence.substring(0,end).split(" ");
	String op = str_arr[str_arr.length - 1];
	op = clean(op);
	return op;
    }
    
    public static int posOrNeg(String word, String choices[]){
        int opinion = 0;
        for(int i = 0; i < choices.length; i++){
	    if(word.equals(choices[i])){
		opinion = 1;
                break;
            }
        }
        return opinion;
    }
    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
	int opinion = 0;	
	String pattern = feature + " was ";
        if(review.contains(pattern)){
            String op = getWasOp(review, pattern);
	    opinion = posOrNeg(op, posOpinionWords);
            if(opinion == 0) opinion = -posOrNeg(op, negOpinionWords);
        }
	return opinion; 
    }
    
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
						   String[] negOpinionWords) {
	// Extract sentences as feature might appear multiple times. 
	// split() takes a regular expression and "." is a special character 
	// for regular expression. So, escape it to make it work!!
	String[] sentences = review.split("\\.");
	int opinion = 0;
	for(String s: sentences){
	    if(s.contains(feature)){
		String op = getOpFirstOp(s, feature);
		opinion = posOrNeg(op, posOpinionWords);
                if(opinion == 0) opinion = -posOrNeg(op, negOpinionWords);
		break;
	    }
	}
	return opinion;
    }

    public static void main(String[] args) {
	String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
	
	//String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
	
	String[][] featureSet = { 
	    { "ambiance", "ambience", "atmosphere", "decor" },
	    { "dessert", "ice cream", "desert" }, 
	    { "food" }, 
	    { "soup" },
	    { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
	String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
				     "delicious" };
	String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

	int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
	System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}