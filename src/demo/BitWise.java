package demo;

class BitWise{
    static void bitwiseOperators(){
	System.out.println("\nInside bitwiseOperators...");
	int x = 1;
	int y = 3;
	
	System.out.println("x & y : "+ (x & y));
	System.out.println("x | y: "+ (x|y));
	System.out.println("~x : "+ (~x));

	char c1 = 'a';
	char c2 = 'b';
	System.out.println("c1 ^ c2 "+ (c1 ^ c2));
	//bit wise operators only work on integer and boolean variables
	// so the following cause compile errors
	//double d1 = 3.14;
	//double d2 = 5.15
	//System.out.println("d1 & d2 : "+ d1 & d2);
    
	//Bit Shift operator
	x = -1;
	System.out.println("x << 2 "+ (x << 2));// left shift
	/*Applying left shift is the same as multiplication by the power of 2.
	    Right operator is division by 2
*/
	System.out.println("x >>> 2 "+ (x >>> 2)); // (sign not preserved) unsigned right shift
	System.out.println("x >> 2 "+ (x >> 2)); // sign is preserved
    }
    
    public static void main(String...args){
	bitwiseOperators();
    }

}