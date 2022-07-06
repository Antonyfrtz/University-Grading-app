package userclasses;

import java.util.ArrayList;
import java.util.List;


public class Student extends User{

    private int registrationNumber=0;
    //zero declares that it has not been initialized
    private List<Course> myCourses=new ArrayList<Course>();
    private List<Grade> myGrades=new ArrayList<Grade>();
    int PassedCourses;
    int FailedCourses;
    int semester;
    double average;

    //---------------------------------------------------------------------------------------
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        //if registrationNumber is null,set it as registration number,else set it as its known value
        this.registrationNumber = this.registrationNumber==0 ? registrationNumber : this.registrationNumber;
    }

    public List<Course> getMyCourses() {
        return myCourses;
    }

    public void setMyCourses(List<Course> myCourses) {
        this.myCourses = myCourses;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage() {
        this.average = this.myGrades==null?0:calculateAverageGrade();
    }

    //----------------------------------------------------------------------------
    public int getPassedCourses() {
        return PassedCourses;
    }

    public void setPassedCourses() {
        if (myGrades==null){PassedCourses=0;return;}
        for (Grade grade:myGrades) {
            if (grade.isPassed()){
                PassedCourses+=1;
            }
        }
    }
    //----------------------------------------------------------------------------
    public int getFailedCourses() {
        return FailedCourses;
    }

    public void setFailedCourses() {
        if (myGrades==null){FailedCourses=0;return;}
        for (Grade grade:myGrades) {
            if (!grade.isPassed()){
                FailedCourses+=1;
            }
        }
    }

    //------------------------------------------------------------------------------------------

    //constructor of Students

    public Student() {
    }

    public Student(String username, String name, String surname, String department, String email, int registrationNumber){
        super(username,name,surname,department,email);//use parent's constructor
        setRegistrationNumber(registrationNumber);
        setPassedCourses();
        setFailedCourses();
        setAverage();
    }
    //----------------------------------------------------------------------------
    //METHODS
    public void registerCourse(Course course) {
        myCourses.add(course);
        course.setRegisteredStudents(this);
    }
    //----------------------------------------------------------------------------
    public void showGrades() {
        System.out.println("COURSE   :    GRADE");
        for (Grade grade:myGrades) {
            System.out.println(grade.getCourse()+" : "+ grade.getGrade());
        }
    }
    //----------------------------------------------------------------------------
    public int getCourseGrade(String courseName){
        for (Grade grade:myGrades
             ) {
            if(grade.getCourse().getCourseName()==courseName){
                    return grade.getGrade();
            }

        }
        return -2;//student is not registered in a course named courseName or he has not been examined yet
    }
    //----------------------------------------------------------------------------
    public double calculateAverageGrade(){
        int sum = 0;
        for (Grade Grade:myGrades) {
            sum+=Grade.getGrade();
        }
        return (double)sum/myGrades.size();
    }
    public void showAverageGrade() {
        System.out.println(+this.registrationNumber+" average grade is "+average);
    }
    //----------------------------------------------------------------------------
    public void addGrade(Grade grade){
        this.myGrades.add(grade);
    }
}
