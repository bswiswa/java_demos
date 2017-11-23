package demo;
/* work with methods and passing object references
   method overloading
*/

class Methods{
    
    static void go(int array[]){
	System.out.println("array[0] = "+ array[0]+ " array[1] = "+ array[1]);
	array[0] = 22;
    }

    static void go(int i){
        System.out.println("i = "+ i);
    }
    
    static void go(short i){
        System.out.println("short i = "+ i);
    }

    public static void main(String args[]){
	int arr[] = { 3,4};
	go(arr);
	System.out.println("arr[0] = "+ arr[0]+ " arr[1] = "+ arr[1]);
	go(arr[0]);
	go((byte)arr[0]);
    }

}