package demo;

class Characters{

    static void primitive(){
	char charA = 'A';
	System.out.println("\n Inside primitive...");
	System.out.println("charA: "+ charA);
	char charInt = 65;
	System.out.println("charInt "+ charInt);
	char charUnicode = '\u262F';
	System.out.println("charUnicode \\u262F is "+ charUnicode);
	char charUnicode2 = 0x41; // 1* 16^0 + 4* 16^1
	System.out.println("charUnicode2: "+ charUnicode2);
	char charBinary = 0b01000001;
	System.out.println("charBinary: "+ charBinary);
    }

    public static void main(String[] args){
	primitive();
    }
}