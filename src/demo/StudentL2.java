package demo;
class StudentL2{
    private  int id; //default 0
    private String name;
    private String gender = "male";
    
    public String getName(){
	return name;
    }
    
    public void setName(String name){
	this.name = name;
    }
    
    public void setGender(String gender){
	gender = gender.toLowerCase();
	if(gender.equals("male") || gender.equals("female") || gender.equals("transgender")){
	    this.gender = gender;
	}
	else{
	    throw new IllegalArgumentException("Wrong gender passed!!");
	}
	
    }

    public String getGender(){
	return gender;
    }
	   
	
     
    public StudentL2(int id, String name, String gender){
	this.name = name;
	this.id = id;
	this.gender = gender;
    }   
}