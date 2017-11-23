package demo;

class Array{
    static void arrays(){
	System.out.println("\nInside arrays()...");
	int myArray[] = {9,11,2,5,4,4,6};
	System.out.println("myArray[1] = "+ myArray[1]);
	// if you try to access anything outside of the bounds of an array, you get an IndexOutOfBoundsException
    }

    public static void main(String args[]){
	arrays();
    }
}