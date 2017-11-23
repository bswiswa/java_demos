package demo;

/* work with a 3D array */
class ThreeDimensionalArrays{
    public static void main(String args[]){
	int unitsSold[][][] = {
	    {
		{0,0,0,0},
		{0,0,0,0},
		{0,850,0,0},
	    },
	    {
		{0,0,0,0},
                {0,0,0,0},
		{0,0,0,0},
	    },
	    {
		{0,0,0,0},
                {0,0,0,0},
		{0,0,0,0},
	    }
	    
	};
	System.out.println("print 850: "+ unitsSold[0][2][1]);
    }
}