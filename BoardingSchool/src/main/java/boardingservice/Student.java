package boardingservice;

public class Student {

	private Integer registerNo;
	private String foodType;
	private String bordingSchool;
	
	public Student(Integer registerNo,  String bordingSchool , String foodType) {
		
		this.registerNo= registerNo;
		this.foodType= foodType;
		this.bordingSchool=bordingSchool;
	}
	
	public Integer getRegisterNo() {
		return registerNo;
	}
	
	public void setRegisterNo(Integer registerNo) {
		this.registerNo = registerNo;
	}
	
	public String getFoodType() {
		return foodType;
	}
	
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public String getBordingSchool() {
		return bordingSchool;
	}
	
	public void setBordingSchool(String bordingSchool) {
		this.bordingSchool = bordingSchool;
	}
	
}
