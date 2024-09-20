package com.generation.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.generation.clases.Course;
import com.generation.clases.Student;
import com.generation.exception.CourseNotFoundException;
import com.generation.exception.StudentNotFoundException;

public class StudentService
{
    private HashMap<String, Course> courseList = new HashMap<>();

    private HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }

    public void enrollStudents( String courseName, String studentID ) 
    {
    	
    	
        
        try {
        		verificaCurso(courseName);
        		verificaStuden(studentID);
        		Course course = courseList.get( courseName );
        		if ( coursesEnrolledByStudents.containsKey( studentID ) )
        		{
        			coursesEnrolledByStudents.remove(students.get(studentID));
        		}
        		students.get(studentID).getCourseList().add(course);
        		coursesEnrolledByStudents.put( studentID, students.get(studentID).getCourseList() );
        	}catch (CourseNotFoundException e) {
        		System.out.println(e.getMessage()+" no se pudo inscribrir");
        	}catch (StudentNotFoundException e) {
        		System.out.println(e.getMessage()+" no se pudo inscribrir");
        	}
    }

    public void unEnrollStudents( String courseName, String studentID )
    {
    	try {
    		verificaCurso(courseName);
    		verificaStuden(studentID);
    		Course course = courseList.get( courseName );
    		if ( coursesEnrolledByStudents.containsKey( studentID ) )
    		{
    			coursesEnrolledByStudents.remove(students.get(studentID));
    		}
    		students.get(studentID).getCourseList().remove(course);
    		coursesEnrolledByStudents.put( studentID, students.get(studentID).getCourseList() );
    	}catch (CourseNotFoundException e) {
    		System.out.println(e.getMessage()+" no se pudo eliminar");
    	}catch (StudentNotFoundException e) {
    		System.out.println(e.getMessage()+" no se pudo eliminar");
    	}
    }

    public void showEnrolledStudents(String courseId){
        //TODO implement using collections loops
    	System.out.println("Alumnos inscriptos al curso: "+courseList.get(courseId).getName());
    	for (List<Course> values : coursesEnrolledByStudents.values()) {
    		String aux=buscaLlave(values);
			if(values.contains(courseList.get(courseId))) {
				System.out.println(students.get(aux).getName());
			}
		}
    }
    
    public String buscaLlave(List<Course> valor) {
    	String cad="";
    	for (String key : coursesEnrolledByStudents.keySet()) {
    		if(valor==coursesEnrolledByStudents.get(key)) {
    			cad=key;
    		}
			
		}
    	return cad;
    }
    
    public void showAllCourses(){
        //TODO implement using collections loops
    	for (Course cursos : courseList.values()) {
			System.out.println(cursos.toString());
		}
    }

	public HashMap<String, Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(HashMap<String, Course> courseList) {
		this.courseList = courseList;
	}

	public HashMap<String, Student> getStudents() {
		return students;
	}

	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	}

	public HashMap<String, List<Course>> getCoursesEnrolledByStudents() {
		return coursesEnrolledByStudents;
	}

	public void setCoursesEnrolledByStudents(HashMap<String, List<Course>> coursesEnrolledByStudents) {
		this.coursesEnrolledByStudents = coursesEnrolledByStudents;
	}
    
    public void verificaCurso(String courseName) throws CourseNotFoundException {
    	boolean isValid=false;
    	for (Course cursos : courseList.values()) {
			if(courseName==cursos.getName()) {
				isValid=true;
			}
		}
    	
    	if (isValid) {
			
		} else {
			throw new CourseNotFoundException("Curso no encontrado");
		}
    }
    public void verificaStuden(String studentID) throws StudentNotFoundException {
    	boolean isValid=false;
    	for (Student student : students.values()) {
    		if(studentID==student.getId()) {
    			isValid=true;
    		}
    	}
    	
    	if (isValid) {
    		
    	} else {
    		throw new StudentNotFoundException("Estudiante no encontrado");
    	}
    }
    
    
}