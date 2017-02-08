package lab4;

public class StudentDemo {

	public static void main(String[] args) {

		Student student=new Student();
		System.out.println(student.toString());
		student.setName("Student 1");
		System.out.println(student.toString());
		System.out.println("student name="+student.getName());
		System.out.println("student number="+student.getSutdentNumber());
		Person anotherPerson=new Person();
		anotherPerson.setName("Student 1");
		System.out.println("student hasSameName="+student.hasSameName(anotherPerson));
		Student student2=new Student();
		System.out.println(student2.toString());
		student2.setName("Student 1");
		System.out.println("student equals student2="+student.equals(student2));
		
		
	}

}
