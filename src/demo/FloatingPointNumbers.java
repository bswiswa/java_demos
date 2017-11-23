package demo;

/* real numbers with 32 bit float or 64-bit double
   double is more precise
   Data representation ~ 32 and 64 bit IEEE 754 flaating point convention
   float -3.4E38 to 3.4E38 where E is power 10
   double -1.7E308 to 1.7E308
*/
class FloatingPointNumbers{

    static void primitive(){
	float f = 123.45f;
	double d = 123456.6789;
	System.out.println("\nInside primitives...");
	System.out.println("float f = "+ f);
	System.out.println("double d = "+ d + "\n");
    }

    public static void main(String[] args){
	primitive();
    }
}