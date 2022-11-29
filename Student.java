import java.util.*;
class Student{
	private String id;
	private String name;
	private int prfMarks;
	private int dbmsMarks;
	
	public String getId(){
		return this.id;
	}
	public Student(String id,String name){
		this.id=id;
		this.name=name;
		this.prfMarks=-1;
		this.dbmsMarks=-1;
	}
}

class Example{ 
	public static Student[] studentArray=new Student[0];
	
	public static void extendArrays(){
		Student[] tempStudentArray=new Student[studentArray.length+1];
		for(int i=0;i<studentArray.length;i++){
			tempStudentArray[i]=studentArray[i];
		}
		studentArray=tempStudentArray;	
	}
	
	public static int search(String stId){
		for(int i=0;i<studentArray.length;i++){
			Student st=studentArray[i];
			if(stId.equalsIgnoreCase(st.getId())){
				return i;
			}
			
		}
		return -1;
	}
	
	public static void addNewStudent(){
		Scanner input=new Scanner(System.in);
		L1:do{
			System.out.print("Enter Student ID    : ");
			String stId=input.nextLine();
			if(search(stId)!=-1){
				System.out.println("Student "+stId+" is exit...");
				continue L1;
			}
			extendArrays();
			System.out.print("Enter Student Name    : ");
			String stName=input.next();
			Student st=new Student(stId,stName);
			input.nextLine();
			L2:do{
				System.out.print("Do you want to add a new student(Y/N) ? ");
				String op=input.nextLine();
				if(op.equalsIgnoreCase("Y")){
					continue L1;
				}
				else if(op.equalsIgnoreCase("N")){
					break L1;
				}
				else{
					System.out.println("wrong input...");
					continue L2;
				}
				
			}while(true);
			
		}while(true);
	}
	
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		L1:do{
			System.out.println("    ---------------------------------------------------------------------------------------");
			System.out.println("    |                  WELCOME TO THE GDSE MARKS MANAGEMNET SYSTEM                        |");
			System.out.println("    ---------------------------------------------------------------------------------------");
			String a="                     ";
			System.out.println("    [1] Add New Student"+a+"      "+"[2] Add New Student With Marks");
			System.out.println("    [3] Add Marks"+a+"            "+"[4] Update Student Details");
			System.out.println("    [5] Update Marks"+a+"         "+"[6] Delete Student");
			System.out.println("    [7] Print Student Details"+a+"[8] Print Student Ranks");
			System.out.println("    [9] Best in Programming Fundamentals"+"          "+"[10] Best in Database Management System\n\n");
			System.out.print("Enter an Option to Continue>");
			int op=input.nextInt();
			input.nextLine();
			switch(op){
				case 1:addNewStudent();break;
				/*case 2:addNewStudentWithMarks();break;
				case 3:addMarks();break;
				case 4:updateStName();break;
				case 5:updateStMarks();break;
				case 6:deleteStudent();break;
				case 7:printStDetails();break;*/
				case 8:System.exit(0);
			}
			L2:do{
				System.out.print("Do you want to Exit(Y/N)? ");
				String exitOption=input.next();
				System.out.print("");
				if(exitOption.equalsIgnoreCase("Y")){
					break L1;
				}else if(exitOption.equalsIgnoreCase("N")){
					continue L1;
				}else{
					System.out.println("Ivalid option, input again...");
					continue L2;
				}
			}while(true);
		}while(true);            
	}
	
	
	
}
