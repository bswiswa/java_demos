package demo;
/* introduction to integers and their declaration
 */

class IntegersIntro{
    static void primitives(){
	System.out.println("\nInside primitives...");
	// literal declaration
	int intHex = 0x0041;
	int intBinary = 0b01000001;
	int intUnderscore = 1_23;
	System.out.println("intHex: " + intHex);
	System.out.println("intBinary: "+ intBinary);
	System.out.println("intUnderscore: "+ intUnderscore + "\n");
    }

    public static void main(String[] args){
	primitives();
    }
}