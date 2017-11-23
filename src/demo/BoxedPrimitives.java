/* work with Boxed Primitives */
package demo;

class BoxedPrimitives{
    static void boxedPrimitives(){
	System.out.println("Inside boxedPrimitives()...");
	System.out.println("Boxed primitives are simply containers for primitives. There is one for each primitive type - Byte, Short, Integer, Long, Float, Double, Boolean, Character");
	System.out.println("Boxed primitives provide useful utility functions and values for each primitive class eg");
	int a = Integer.parseInt("25");
	System.out.println("int a = Integer.parseInt(\"25\");\n a = " + a);
	System.out.println("Integer.MAX_VALUE = "+ Integer.MAX_VALUE + " Integer.MIN_VALUE = "+ Integer.MIN_VALUE);
	System.out.println("Character.isNumber(\'5\') = "+ Character.isDigit('5'));
	System.out.println("Double.isNaN(Math.sqrt(-10)) = "+ Double.isNaN(Math.sqrt(-10)));
	Integer i = new Integer(5);
	System.out.println("Initialization example: Integer i = new Integer(5);\n i = "+ i);
	Integer j = new Integer(25);
	System.out.println("Can also be done using a string: Integer j = new Integer(\"25\");\n j = "+ j);
	Integer boxed = Integer.valueOf("40");
	System.out.println("Boxed primitives also have a static valueOf() method which can be used to create these objects. For integers in the range of -128 to 128, it has better performance. \n Integer boxed = Integer.valueOf(\"40\");\n boxed = "+ boxed);
	int k = i.intValue();
	System.out.println("If you want to get the primitive back (unwrapping): int k = i.intValue();\n k = "+ k);
	System.out.println("You can peform regular arithmetic operations on the boxed Integer class eg..");
	System.out.println("boxed = "+ boxed);
	boxed++;
	System.out.println("boxed++; \n boxed = "+ boxed);
	System.out.println("boxed*3 = "+ boxed*3);
	System.out.println("This is possible thanks to auto-boxing and unboxing compiler features introduced in Java 5");
	Double pi = 3.142;
	System.out.println("Auto-boxing allows us to directly assign primitives to Boxed Primitive objects:\nDouble pi = 3.142;\npi = "+ pi);
	System.out.println("Note that arrays are not primitives but are objects and they cannot be converted into boxed primitives\nInteger items[] = new int[]{1,2,3,4}; //error: incompatible types: int[] cannot be converted to Integer");
	System.out.println("Note that primitives are simple and their identities value they carry. Boxed primitives are objects and have separate memory addresses. These memory addresses are their identities. You cannot use regular comparisons to evaluate them like you do with primitives. (whenever an object is created with the new keyword, it is given a separate and unique address regardless of any pooling or caching)");
	int b = 3, c = 3;
	Integer B = new Integer(3);
	Integer C = new Integer(3);
	System.out.println("int b = 3, c = 3;\nb == c : "+ (b == c));
	System.out.println("Integer B = new Integer(3);\nC = new Integer(3);\nB == C : "+ (B == C));
	System.out.println("A special exception is when boxed Integers are declared using autoboxing and the values of the integers are in the range of -128 to 127.\nIn this range, the reference to the object is collected from the Integer cache of objects (similar to the String pool).\n Thus the two objects would be equal since they point to the same memory address");
	Integer D = 3;
        Integer E = 3;
	Integer F = -129;
	Integer G = -129;
	System.out.println("Created via autoboxing and -128 <= Integer <= 127...");
	System.out.println("Integer D = 3;\nInteger E = 3;\\nD == E : "+ (D == E));
        System.out.println("Created via autoboxing BUT NOT IN CACHE RANGE  -128 <= Integer < 127...");
        System.out.println("Integer F = -129;\nInteger G = -129;\\nF == G : "+ (F == G));
}

    public static void main(String...args){
	boxedPrimitives();
    }
}