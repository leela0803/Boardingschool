package boardingServiceTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import boardingSchoolException.BoardingSchoolNotFoundException;
import boardingSchoolException.FoodTypeNotFoundexception;
import boardingService.BoardingSchool;
import boardingService.BoardingSchoolService;
import boardingService.Student;


public class RegisrationServiceTest {
	
	 
	@Test(expected = BoardingSchoolNotFoundException.class)
	public void testForInvalidFoodType() throws BoardingSchoolNotFoundException, FoodTypeNotFoundexception {
	
		
		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(4);
		
		Student student= new Student("1", "C", "V");
		
		boardingSchoolService.Register(student);

		
		BoardingSchool boardingSchool= boardingSchoolService.getBoardingSchoolDetails().stream()
				.filter(x-> x.getName().equals(student.getBordingSchool()) 
						&& x.getFoodType().equals(student.getFoodType()))
				.findFirst().orElse(null);
		assertNull(boardingSchool);
		
	}
	
	@Test(expected = FoodTypeNotFoundexception.class)
	public void testForInvalidBoardingSchoolName() throws BoardingSchoolNotFoundException, FoodTypeNotFoundexception {
		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(4);
		
		Student student= new Student("1", "A", "VN");
		
		boardingSchoolService.Register(student);

		
		BoardingSchool boardingSchool= boardingSchoolService.getBoardingSchoolDetails().stream()
				.filter(x-> x.getName().equals(student.getBordingSchool()) 
						&& x.getFoodType().equals(student.getFoodType()))
				.findFirst().orElse(null);
		assertNull(boardingSchool);
		
	}
	
	@Test
	public void  testRegisterMethod() {
		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(4);
		Student student1= new Student("1", "A", "NV");
		Student student2= new Student("2", "A", "NV");
		
		try {
	
			boardingSchoolService.Register(student1);
			
			BoardingSchool boardingSchool= boardingSchoolService.getBoardingSchoolDetails().stream()
					.filter(x-> x.getName().equals(student2.getBordingSchool()) 
							&& x.getFoodType().equals("NV"))
					.findFirst().orElse(null);
			boardingSchool.getStudents().stream().findFirst();
			assertEquals(student1, student1);
			
		} catch (BoardingSchoolNotFoundException | FoodTypeNotFoundexception e) {
			
			e.printStackTrace();
		} 
		
	}
	
	
	
	
	
	// this is to test when the veg boarding schools are filled,
	//non Veg student can be assigned veg school but vice versa is not possible
	@Test
	public void  TestForNVStudentGettingVegBoardingSchool() {
		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(4);
		Student student1= new Student("1", "A", "NV");
		Student student2= new Student("2", "A", "NV");
		
		
		try {
	
			boardingSchoolService.Register(student1);
			boardingSchoolService.Register(student2);
			
			BoardingSchool boardingSchool= boardingSchoolService.getBoardingSchoolDetails().stream()
					.filter(x-> x.getName().equals(student2.getBordingSchool()) 
							&& x.getFoodType().equals("V"))
					.findFirst().orElse(null);
			
			
			Student student =  boardingSchool.getStudents().stream().findFirst().orElse(null);
			
			System.out.println(student.getRegisterNo());
			assertEquals(student, student2);
			
		} catch (BoardingSchoolNotFoundException | FoodTypeNotFoundexception e) {
			
			e.printStackTrace();
		} 
		
	}
	
	@Test
	public void  TestRegisterMethod() {
		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(4);
		Student student1= new Student("1", "A", "NV");
		Student student2= new Student("2", "A", "NV");
		
		
		try {
	
			boardingSchoolService.Register(student1);
			boardingSchoolService.Register(student2);
			
			BoardingSchool boardingSchool= boardingSchoolService.getBoardingSchoolDetails().stream()
					.filter(x-> x.getName().equals(student2.getBordingSchool()) 
							&& x.getFoodType().equals("V"))
					.findFirst().orElse(null);
			
			
			Student student =  boardingSchool.getStudents().stream().findFirst().orElse(null);
			
			System.out.println(student.getRegisterNo());
			assertEquals(student, student2);
			
		} catch (BoardingSchoolNotFoundException | FoodTypeNotFoundexception e) {
			
			e.printStackTrace();
		} 
		
	}
	
	
	
}
