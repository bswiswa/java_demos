package demo;
class GPA{
	public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
	    double gpa[] = new double[studentIdList.length];
	    int count = 0;
	    for(int i = 0, j = 0; i < studentIdList.length && j < studentsGrades.length; i++, j++){
		gpa[i] = 0.0;
		count = 0;
		for(char grade: studentsGrades[j]){
		    switch(grade){
                    case 'A':
			gpa[i]+=4;
			break;
                    case 'B':
			gpa[i]+=3;
			break;
                    case 'C':
			gpa[i]+=2;
			break;
		    }
		    count++;
		}
		gpa[i] = gpa[i]/count;
	    }
	    return gpa;
	}
    
	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
	    //check data
            //if lower > higher return null
            //if lower or higher are negative return null
            if(lower < 0 || higher < 0) return null;
            else if(lower > higher) return null;
            else{
                double gpas[] = calculateGPA(studentIdList, studentsGrades);
                int relevant = 0;
                for(int i = 0, j=0; i < gpas.length & j < studentIdList.length; i++, j++){
                    if(gpas[i] >= lower && gpas[i] <= higher){
                        relevant++;
                    }
                    else studentIdList[j] = -1;
                }
                if(relevant == 0) return null;
                
                int students[] = new int[relevant];
                int pos = 0;
                for(int i: studentIdList){
                    if(i > 0){
                        students[pos] = i;
                    }
                }
		return students;
            }
           
        
	}

    public static void main(String...args){
	double lower = 3.2;
	double higher = 3.5;
	int  studentIdList[] = {1001, 1002};
	char studentsGrades[][] = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };
	double gpas[] = calculateGPA(studentIdList, studentsGrades);
	System.out.println("GPA[0]: "+ gpas[0] + " GPA[1]: "+ gpas[1]);
	int students[] = getStudentsByGPA(lower, higher, studentIdList, studentsGrades);
	for(int i: students){
	    System.out.println("student[i] "+ i);
	}
	    
    }    
    }