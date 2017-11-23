package demo;

class Statements{
    static int count = 25; // can have declaration statements at class level
    // count = 26; // uncommenting the previous statement will result in a compilation error because expressions are not allowed at class level. The compiler thinks we are trying to declare something and expects an identifier
    
    //control flow statements also not allowed at class level
    //if(count > 20) count = 40;
    public static void main(String[] args){
	count = 26; // but you can have an expression inside a method
	if(count > 20) count = 40; // but you can also have control flow statements in a method.
	System.out.println("Testing statements...");
    }

}