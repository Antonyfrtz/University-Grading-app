package userclasses;

import java.util.ArrayList;
import java.util.List;


public class Course {

    private String courseId;
    private String courseName;
    private int courseYear;
    private String department;
    private List<Student> registeredStudents=new ArrayList<Student>();
    private List<Student> examinedStudents=new ArrayList<Student>();

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public List<Student> getExaminedStudents() {
        return examinedStudents;
    }

    public void setExaminedStudents(Student stud) {
            this.examinedStudents.add(stud);
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Student s) {
        this.registeredStudents.add(s);
    }
    
    public void getExamStats(){
        double i=0; //this could be a Courses variable - ��. ������������� ���� �������
        for (Student s:getRegisteredStudents()) {
            if(getExaminedStudents().contains(s)){
                i++;
            }
        }
        //this could be a Courses variable - ��. ������������� ��� ������
        System.out.println("Percentage of registered students that attended the exam of "+this.getCourseName()+": " +i/getRegisteredStudents().size()*100+"%" ); // percentage of those who went to be examed
    }
    

//------------------------------------------------------------------------------------------
    public Course(){}
    public Course(String courseId, String courseName, int courseYear,String department)
    {
        setCourseId(courseId);
        setCourseName(courseName);
        setCourseYear(courseYear);
        setDepartment(department);
    }

}
