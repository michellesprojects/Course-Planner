
public class Planner implements Cloneable {

	private Course [] courses;
	
	private final int MAX_COURSES = 50;
	
	private int numCourses;
	
	
	public Planner() {
		courses = new Course[MAX_COURSES];
		this.numCourses = 0;
	}
	
	public Planner(Course[] courses) {
		super();
		this.courses = courses;
		this.numCourses = courses.length;
	}
	
	public int size() {
		return numCourses;
	}
	

	/* A student can insert a course at any position within the range of the list.
	 *  Make sure there are no gaps between courses on the list
	 */
	
	public void addCourse(Course newCourse, int position) throws PlannerException{
		
		if(this.numCourses == this.MAX_COURSES) {
			throw new PlannerException("Course capacity reached.");
		}
		
		if(position < 1 || position > this.numCourses+1) {
			throw new PlannerException("Invalid Planner position detected.");
		}
		
		
		for(int i=this.size(); i>=position; i--) {
			
			courses[i] = courses[i-1];
			
		}
		
		courses[position-1] = newCourse;
		numCourses++;
		
	}
	
	public void addCourse(Course newCourse) {
		
		courses[this.size()] = newCourse;
		this.numCourses++;
	}
	
	public void removeCourse(int position) throws PlannerException {
	
		if(position < 0 || position > size()) {
			throw new PlannerException("invalid position detected.");	
		}
		
		for(int i=position-1; i<size(); i++) {
			courses[i] = courses[i+1];
		}
		
		numCourses--;
	}
	
	public Course getCourse(int position) throws PlannerException {
		
		if(position < 0 || position > size()) {
			throw new PlannerException("invalid position detected.");	
		}
		return courses[position-1];
	}
	
	public static void filter(Planner planner, String department) {
		
		for(int i=0; i<planner.size(); i++) {
			if(planner.courses[i].getDepartment().equals(department))
				System.out.println(planner.courses[i].toString());
		}
	}
	@Override
	public String toString() {
        String plannerList = "";
        
        for (int i = 0; i < numCourses; i++) {
            plannerList += i+1+"\t"+courses[i].getName()+"\t"+courses[i].getDepartment()+"\t"+courses[i].getCode()
            		+ "\t"+courses[i].getSection()+"\t"+courses[i].getInstructor()+ "\n";
        };
        return plannerList;
    }
	
	
	public void printAllCourses() {
		
		System.out.println("Pos  Course Name\tDept\tCode\tSec\tInstructor");
        System.out.println("---------------------------------------------------"
        		+ "-------------------------------------------");
        
        System.out.println(this.toString());
       
	}
	
	public boolean exists(Course course) {
		
		for(int i=0; i<size(); i++) {
			if(courses[i].equals(course))
				return true;
		}
		return false;
	}
	
	@Override
	public Object clone() {
		
		Planner planner; 
		
		try {
			planner = (Planner)super.clone();
			
		} catch(CloneNotSupportedException e) {
			planner = new Planner(this.courses);
		}
		
		return planner;
	}
	
}
