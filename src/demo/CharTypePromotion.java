package demo;

class CharTypePromotion{
    static void charTypePromotionExample(){
	System.out.println("\n Inside charTypePromotion...");
	char char1 = 50; // Will be assigned corresponding UTF16 value of 2
	System.out.println("(73 - char1): "+ (73-char1)); //char1 is promoted to int first (50)
	System.out.println("(char1 - '3'): "+ (char1 - '3')); //char1 and '3' are promoted to ints first
	System.out.println("('a' + 'b'): "+ ('a' + 'b')); // 'a' and 'b' are promoted to ints and their equivalents are used ie 97 and 98
    }

    public static void main(String...args){
	charTypePromotionExample();
    }

}