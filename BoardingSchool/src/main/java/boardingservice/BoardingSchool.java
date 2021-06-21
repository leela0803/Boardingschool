package boardingservice;

import java.util.LinkedHashSet;
import java.util.Set;


public class BoardingSchool {

	private int Size;
	private String foodType;
	private String name;
	private LinkedHashSet<Student> admittedStudentsList;

	public BoardingSchool(String name,String foodType,  int size) {
		this.name= name;
		this.Size= size;
		this.foodType= foodType;
		admittedStudentsList = new LinkedHashSet<>(); //  LinkedHashSet to maintain unique and insertion ordered elements
	}
	
	public BoardingSchool(String name) {
		this.name= name;
		this.foodType="";
		admittedStudentsList = new LinkedHashSet<>();
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Set<Student> getStudents(){

		return admittedStudentsList;
	}

	void admit(Student student) {

		admittedStudentsList.add(student);

	}


}
