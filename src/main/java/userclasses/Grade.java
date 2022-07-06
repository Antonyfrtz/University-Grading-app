package userclasses;


public class Grade {
	   private Student student;
	    private Course course;
	    private int grade;
	    private boolean passed;

	    public Student getStudent() {
	        return student;
	    }

	    public void setStudent(Student student) {
	        this.student = student;
	    }

	    public Course getCourse() {
	        return course;
	    }

	    public void setCourse(Course course) {
	        this.course = course;
	    }

	    public int getGrade() {
	        return grade;
	    }

	    public void setGrade(int grade) {
	        this.grade = grade;
	    }

	    public boolean isPassed() {
	        return passed;
	    }

	    public void setPassed() {
	        if(this.grade<5){this.passed=false;}
	        else {this.passed=true;}
	    }
	    //-------------------------------------------------------------------------

	    public Grade(Student student,Course course,int grade) {
	        setStudent(student);
	        setCourse(course);
	        setGrade(grade);
	        setPassed();
	    }
}
