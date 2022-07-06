package userclasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Secretary extends User {
	  private int telephone;

	    public void makeAnnouncement(String message,Course course){

	        SimpleDateFormat sdf=new SimpleDateFormat("dd/M/yyyy");
	        String date=sdf.format(new Date());
	        System.out.println("ANNOUNCEMENT FOR: "+course.getCourseName()+" ( "+date+" )");
	        System.out.println("We inform you that "+ message);
	    }
	    //----------------------------------------------------------------------------
	    void createRecord(){
	        System.out.println("\nType:\n" + " 1-if you want to create a professor \n" + " 2-if you want to create a student \n"
	                + " 3-if you want to create a course \n" + " 4-if you want to exit record creation mode\n");
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            try {
	                int option = scanner.nextInt();

	                switch (option) {
	                    case 1:
	                        createProfessor();
	                        break;
	                    case 2:
	                        createStudent();
	                        break;
	                    case 3:
	                        createCourse();
	                        break;
	                    case 4:
	                        return;
	                    default:
	                        System.out.println("Please type a valid option between 1 and 4 \n");
	                        break;
	                }

	            } catch (Exception e) {
	                System.out.println("Please type a valid option between 1 and 4 \n");
	            }
	        }
	    }
	    private void createProfessor(){
	        Professor professor=new Professor();
	    }
	    private void createStudent(){
	        Student student=new Student();
	    }
	    private void createCourse(){
	        Course course=new Course();
	    }
	    public void addStudentsToBeExamined(List<Student> students, Course course){
	        for (Student stud:students) {
	            course.setExaminedStudents(stud);
	        }
	    }
	    public void assignProfessorToCourse(Professor prof,Course course){
	        prof.addToProfessorCourses(course);
	    }
}
