package demo;

class Boolean{
    public static void main(String[] args){
	boolean x = false;
	int i = 1234567890;
	float f = i;
	x = (int)f > i;
	if(x) System.out.println("Loss of information, float is larger");
	else System.out.println("i <= (int)f");
    }
}