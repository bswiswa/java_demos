package demo;
class InfoLossCasting{
    public static void main(String[] args){
	int oldVal = 1234567890;
	System.out.println("int value = "+ oldVal);
	float f = oldVal; //implicit cast
	System.out.println("int to float = "+ f);
	int newVal = (int)f;
	System.out.println("float back to int value = "+ newVal);
    }
}