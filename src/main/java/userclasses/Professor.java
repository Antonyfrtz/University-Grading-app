package userclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Professor extends User {
	   //maybe
    private String phoneNumber; //personal phone munber
    private String professorOffice; //aithousa kathigiti
    private List<Course> professorCourses= new ArrayList<Course>();
    //-----------------------------------------------------------------
    public List<Course> getProfessorCourses() {
        return professorCourses;
    }

    public void addToProfessorCourses(Course course) {
            this.professorCourses.add(course);
    }
    //----------------------------------------------------------------------------
    public void  Examine(){
        Scanner scanner=new Scanner(System.in);
        for (Course course:professorCourses) {
            for (Student student:course.getExaminedStudents()) {
                System.out.println("Type the grade for student: "+student.getName()+" "+student.getSurname()+" (Registration number: "+student.getRegistrationNumber()+") :");

                while (true) {
                    if (scanner.hasNextInt()) {
                        int input=scanner.nextInt();
                        if(input<11&&input>-1)
                        {
                        student.addGrade(new Grade(student, course,input));
                        break;
                        }
                        else {
                            System.out.println("Grade must be between zero and ten,please enter it again");
                        }

                    } else {
                        System.out.println("Invalid grade,please enter it again!");
                    }
                }

            }
        }
    }
    //----------------------------------------------------------------------------
    public void seeGrades(){
        for (Course professorCourse:professorCourses) {//foreach professor's courses
            System.out.println("Grades for course: "+professorCourse.getCourseName().toUpperCase());
            for (Student student:professorCourse.getRegisteredStudents()) { //foreach student that has register to the course
                int grade=student.getCourseGrade(professorCourse.getCourseName());
                System.out.println(student.getRegistrationNumber()+ //print student's registration number
                        "\t : \t "+ (grade==-2?"-":grade)); //and his grade for the professor's course // "-" for those who are registered but did not attend exam
            }                                               //see getCourseGrade(class Students)
        }
    }


}
