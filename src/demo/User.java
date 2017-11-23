package demo;

/* demonstrate Constructors and overloading constructors. 
   also System.out.printf - C nostalgia
   liking the public static void main(Strings...args) definition. varargs are good
*/

class User {
    int id;
    String name;
    int salary;
    
    User(int userId, String userName){
	id = userId;
	name = userName;
    }
    
    User(int userId, String userName, int userSalary){
	this(userId, userName); /* this is a clever way to avoid repeating fields .If Constructor is going  to call another one then it must be the first statement done in it. Otherwise, illegal. Also cannot have two this statements in constructor and no recursive constructors */
	salary = userSalary;
    }

    public static void main(String...args){
	User s = new User(1, "Batsi");
	User t = new User(2, "Dheeru", 20000);
	System.out.printf("Student name %s, id %d \n", s.name, s.id);
	System.out.printf("Teacher name %s, id %d, salary $%d \n", t.name, t.id, t.salary);
    }
}