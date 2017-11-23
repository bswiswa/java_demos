package demo;
class Switch{
    static void switchExample(){
	System.out.println("\n inside switchExample...");
	final byte month2 =2; /* only constants can be used as cases
				 in a switch statement, hence the use of final. This is because the switch statement is setup during compilation so it needs the final values. A null case cannot be used as well*/
	byte month = 3;
	switch(month){
	case 1: 
	    System.out.println("January");
	    break;
	case month2: 
	    System.out.println("February");
            break;
	default:
	    System.out.println("March");
	}
    }
    public static void main(String...args){
	switchExample();
    }

}