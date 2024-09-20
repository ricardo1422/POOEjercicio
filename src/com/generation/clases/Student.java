package com.generation.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Student
{
    private String name;

    private String id;

    private int age;

    private final List<Course> courseList = new ArrayList<>();

    public Student( String name, String id, int age)
    {
        this.name = name;
        this.id = id;
        this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Course> getCourseList() {
		return courseList;
	}
	public String imprimeCursos() {
		String cadena="";
		for (Course course : courseList) {
			cadena+=course.getName()+", ";
		}
		return cadena;
	}

	@Override
	public String toString() {
		String cursos=imprimeCursos();
		return "Student [name=" + this.name + ", id=" + this.id + ", age=" + this.age + ", courseList=" + cursos + "]";
	}
    
    
    
    
}
