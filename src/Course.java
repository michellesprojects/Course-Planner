
public class Course implements Cloneable {

	private String name, department, instructor;
	private int code;
	private byte section;
	
	
	public Course() {
		
	}
	
	public Course(String name, String department, String instructor, int code, byte section) {
		super();
		this.name = name;
		this.department = department;
		this.instructor = instructor;
		this.code = code;
		this.section = section;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) throws CourseException {
		if(code<0)
			throw new CourseException("Code cannot be less than 0");
		
		this.code = code;
	}
	
	public byte getSection() {
		return section;
	}
	
	public void setSection(byte section) throws CourseException {
		if(section <0)
			throw new CourseException("Section cannot be less than 0");
		
		this.section = section;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (code != other.code)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section != other.section)
			return false;
		return true;
	}
	
	@Override
	public Object clone() {
		
		Course course;
		
		try {
			
			course = (Course)super.clone();
			
		} catch(CloneNotSupportedException e) {
			
			course = new Course(this.getName(),this.getDepartment(),this.getInstructor(), this.getCode(),this.getSection());
					
		}
		
		return course;
	}
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", department=" + department + ", instructor=" + instructor + ", code=" + code
				+ ", section=" + section + "]";
	}


}
