package demo;
/* showing the use of labels to exit out of select loops */
// you can call the label anything you want as long as it is directed to a block

class LabeledBreak{
    static void labeledBreak(){
	System.out.println("\nInside labeledBreak ...");
	int num = 0;
	outermost: for(int i = 0; i < 10; i++){
	    for(int j = 0; j < 10; j++){
		if(i == 5 && j == 5){
		    break outermost;
		}
		num++;
	    }
	}
	System.out.println("num: "+ num);
    }

    public static void main(String...args){
	labeledBreak();
    }
}