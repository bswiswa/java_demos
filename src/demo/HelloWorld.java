package demo;

class HelloWorld {
    public static void main(String[] args){
	System.out.println("Hello world!\n");
    }
}

/* you can have more than one class in a file but it is bad practice
   they are both compiled into separate class bytecodes
*/
class GoodBye {
    public static void main(String[] args){
	System.out.println("Goodbye");
    }
}