package demo;

class SwitchFinal{
    
    /* static final byte month2;
    static{
	month2 = 2;
    }
    */
    // the above code will not work because month2 is not a constant since it is not evaluated until run time
    static void switchExample(){
	System.out.println("\n inside switchExample...");
	//final byte month2 =2; 
/* only constants can be used as cases in a switch statement, hence the use of final. This is because the switch statement is setup during compilation so it needs the final values. A null case cannot be used as well*/
	byte month = 3;
	final byte month2 = 2; //works because month2 = 2 is evaluated at compile time
	/*final byte month2;
	month = 2;
	*/ // these last 2 lines won'g work because month is being reinitialized during run time.
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