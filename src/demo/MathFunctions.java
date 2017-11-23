package demo;
/* working with java.lang.Math */

 class MathFunctions{
     private MathFunctions(){} // do not let anyone instantiate this class
    static void mathFunctions(){
	System.out.println("Undefined enumeration 0.0/0.0 = "+ 0.0);
	System.out.println("Undefined enumeration Math.sqrt(-10) = "+ Math.sqrt(-10));
	System.out.println("Random integer number between 0 and 9 : (int)Math.random()*9 = "+ (int)Math.random()*9);
	System.out.println("Math.round(21.499) = "+ Math.round(21.499));
	System.out.println("Math.ceil(21.1) = "+ Math.ceil(21.1));
	System.out.println("Math.floor(19.9) = "+ Math.floor(19.9));
	System.out.println("Math.max(-11, 3) = "+ Math.max(-11, 3));
	System.out.println("Math.min(-11, 3) = "+ Math.min(-11, 3));
    }

    public static void main(String...args){
	mathFunctions();
    }

}