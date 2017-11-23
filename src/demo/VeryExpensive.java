/* performance issues with autoboxing and auto-unboxing
   Run the boxed primitive loop first then comment it out and run
   the one using pure primitives to compare perfomance

   EXPLANATION:
   In sum + i, one operand is an object and the other is a primitive. 
In this case auto-unboxing occurs on sum from Long to long. Then long sum is added to long i. 
After the addition, the total is assigned back into sum, which is a Long boxed primitive and 
so the total is autoboxed again and assigned to sum. So roughly 2^31 Long object instances
 are being created which is a very expensive procedure.

*/
package demo;

class VeryExpensive{
    static void veryExpensive(){
	System.out.println("\nInside veryExpensive...");
	//using the boxed primitive. 
	Long sum = 0L;
	for(long i = 0; i < Integer.MAX_VALUE; i++){
	    sum = sum + i;
	}
	/*
	//using pure primitives
	long sum = 0;
	for(long i = 0; i < Integer.MAX_VALUE; i++){
	    sum = sum + i;
	}
	*/
    }
    
    public static void main(String...args){
	long start = System.nanoTime();
	veryExpensive();
	System.out.println("Elapsed time: " + ((System.nanoTime() - start)/1000000.0) + " milliseconds");
    }



}