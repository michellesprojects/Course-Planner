import java.util.Scanner;

public class PlannerManager {

	public static void main(String []args) throws NumberFormatException, CourseException, PlannerException {
		
		Scanner input = new Scanner(System.in);
		Planner planner = new Planner();
		Planner backup = new Planner();
		
		boolean runProgram = true;
		
		while(runProgram) {
			
			System.out.println("A - ADD COURSE \n"
                    + "G - GET COURSE \n"
                    + "R - REMOVE COURSE\n"
                    + "P - PRINT COURSES IN THE PLANNER \n"
                    + "F = FILTER BY DEPT \n"
                    + "S - SIZE OF THE PLANNER \n"
                    + "B - BACKUP PLANNER \n"
                    + "PB - PRINT COURSES IN BACKUP \n"
                    + "RB - REVERT T0 BACKUP\n"
                    + "Q - QUIT THE PROGRAM");
            System.out.println("Enter a selection: ");
           
            
		
		
		String selection = input.nextLine().toUpperCase();
		
		switch(selection) {
		
		case("A"):
			Course course = new Course();
		
			System.out.println("Enter the course name: ");
			course.setName(input.nextLine());
			
			System.out.println("Enter the Department: ");
			course.setDepartment(input.nextLine());
			
			System.out.println("Enter the course code: ");
			course.setCode(Integer.valueOf(input.nextLine().trim()));
			
			System.out.println("Enter the course section: ");
			course.setSection(Byte.valueOf(input.nextLine().trim()));
			
			System.out.println("Enter the instructor's name: ");
			course.setInstructor(input.nextLine());
			
			System.out.println("Enter the course's position: ");
			planner.addCourse(course, input.nextInt());
			
			System.out.println();
			
			break;
			
		case("G"):
			
			System.out.println("Enter the position to be retrieved: ");
		
	        int pos = input.nextInt();
	        
	        System.out.println(planner.getCourse(pos));
	        
	        System.out.println();
	        
	        break;
	        
		case("R"):
			
			System.out.println("Enter the position to be removed: ");
			planner.removeCourse(input.nextInt());
			
			System.out.println();
			
			break;
		
		
		case("P"):
			
			planner.printAllCourses();
			System.out.println();
			
			break;
			
		case("F"):
			
			System.out.println("Enter the Department: ");
			Planner.filter(planner, input.nextLine());
			System.out.println();
			break;
			
		case("S"):
			
			System.out.println("There are " + planner.size()
            + " classes in the planner");
			System.out.println();
			break;
			
		case("B"):
			backup = (Planner)planner.clone();
			System.out.println("Backup complete.");
			System.out.println();
			break;
			
		case("PB"):
			backup.printAllCourses();
			System.out.println();
			break;
		
		case("RB"):
			planner = (Planner)backup.clone();
			System.out.println();
			break;
		
		case("Q"):
			
			runProgram = false;
			break;
		
		default:
			System.out.println("selection does not exist");
			
		} 
		}
		
	}
}
