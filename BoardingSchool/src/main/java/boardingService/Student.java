package boardingService;

public class Student {

	private String registerNo;
	private String foodType;
	private String bordingSchool;
	
	public Student(String registerNo,  String bordingSchool , String foodType) {
		
		this.registerNo= registerNo;
		this.foodType= foodType;
		this.bordingSchool=bordingSchool;
	}
	
	public String getRegisterNo() {
		return registerNo;
	}
	
	public void setRegisterNo(String registerNo) {
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
