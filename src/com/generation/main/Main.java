package com.generation.main;

import com.generation.clases.Course;
import com.generation.clases.Student;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
	    //Crea estudiantes
        studentService.getStudents().put( "1030", new Student( "Carlos", "1030", 31 ) );
        studentService.getStudents().put( "1040", new Student( "Ian", "1040", 28 ) );
        studentService.getStudents().put( "1050", new Student( "Elise", "1050", 26 ) );
        studentService.getStudents().put( "1020", new Student( "Santiago", "1020", 33 ) );
        
        //muestra los estudiantes creados
        System.out.println("Imprime alumnos creados");
        for (Student student : studentService.getStudents().values()) {
        	System.out.println(student.toString());
			
		}
        
        
        //inscribir alumnos a cursos
        System.out.println(studentService.getStudents().get("1030").getName());
        studentService.enrollStudents("Math", "1030");
        studentService.enrollStudents("Physics", "1030");
        studentService.enrollStudents("Physics", "1040");
        studentService.enrollStudents("Physics", "1050");
        studentService.enrollStudents("Physics", "1020");
        studentService.enrollStudents("Art", "1020");
        studentService.enrollStudents("Art", "1030");
        studentService.enrollStudents("History", "1030");
        studentService.enrollStudents("History", "1050");
        studentService.enrollStudents("History", "1020");
        studentService.enrollStudents("Biology", "1030");
        studentService.enrollStudents("Biology", "1040");
        
        //muestra los estudiantes creados
        System.out.println("Imprime alumnos creados");
        for (Student student : studentService.getStudents().values()) {
        	System.out.println(student.toString());
			
		}
   
        
        //muestra estudiantes inscript a cada curso
        System.out.println("\nMuestra los estudiantes inscriptos a cada curso");
        for (Course curso : studentService.getCourseList().values()) {
        	studentService.showEnrolledStudents(curso.getName());
		}
       
        System.out.println("\nImprime todos los cursos");
        studentService.showAllCourses();
        
        System.out.println("\n Muestra excepciones al agregar");
        studentService.enrollStudents("History", "10");
        studentService.enrollStudents("Historyc", "1050");
        
        //elimina estudiantes
        studentService.unEnrollStudents("Physics", "1030");
        studentService.unEnrollStudents("Physics", "1040");
        
        //muestra los estudiantes creados
        System.out.println("\nImprime alumnos creados");
        for (Student student : studentService.getStudents().values()) {
        	System.out.println(student.toString());
			
		}
        System.out.println("\n Muestra excepciones al eliminar");
        studentService.unEnrollStudents("Physics", "1030");
        studentService.unEnrollStudents("Physasics", "1040");
        studentService.unEnrollStudents("Physics", "040");
    }
}