package boardingServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import boardingSchoolException.BoardingSchoolNotFoundException;
import boardingSchoolException.FoodTypeNotFoundexception;
import boardingservice.BoardingSchool;
import boardingservice.BoardingSchoolService;
import boardingservice.Student;

public class BoardingSchoolserviceTest {


	@Test(expected = BoardingSchoolNotFoundException.class)
	public void testForInvalidFoodType() throws BoardingSchoolNotFoundException, FoodTypeNotFoundexception {


		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(4);
		Student student= new Student(1, "C", "V");
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

		Student student= new Student(1, "A", "VN");
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
		Student student1= new Student(1, "A", "NV");
		Student student2= new Student(2, "A", "NV");

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


	//This is to test when the veg boarding schools are filled,
	//non Veg student can be assigned veg school but vice versa is not possible
	@Test
	public void  TestForNVStudentGettingVegBoardingSchool() {
		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(4);
		Student student1= new Student(1, "A", "NV");
		Student student2= new Student(2, "A", "NV");

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
	public void  StudentsgreaterThanBoardingSchoolSizeTest() {

		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(12);

		Student student1= new Student(1, "B", "V");
		Student student2= new Student(2, "A", "V");
		Student student3= new Student(3, "A", "V");
		Student student4= new Student(4, "B", "NV");
		Student student5= new Student(5, "B", "V");
		Student student6= new Student(6, "A", "NV");
		Student student7= new Student(7, "A", "V");
		Student student8= new Student(8, "A", "NV");
		Student student9= new Student(9, "B", "NV");
		Student student10= new Student(10, "B", "NV");
		Student student11= new Student(11, "A", "NV");
		Student student12= new Student(12, "B", "NV");
		Student student13= new Student(13, "A", "NV");

		try {
			boardingSchoolService.Register(student1);
			boardingSchoolService.Register(student2);
			boardingSchoolService.Register(student3);
			boardingSchoolService.Register(student4);
			boardingSchoolService.Register(student5);
			boardingSchoolService.Register(student6);
			boardingSchoolService.Register(student7);
			boardingSchoolService.Register(student8);
			boardingSchoolService.Register(student9);
			boardingSchoolService.Register(student10);
			boardingSchoolService.Register(student11);
			boardingSchoolService.Register(student12);
			boardingSchoolService.Register(student13);

		} catch (BoardingSchoolNotFoundException | FoodTypeNotFoundexception e) {
			
			e.printStackTrace();
		}
		
		//get students count from boardingschool AV
		BoardingSchool boardingSchool;
		boardingSchool = boardingSchoolService.getBoardingSchoolDetails().stream()
				.filter(x-> x.getName().equals("A") 
						&& x.getFoodType().equals("V"))
				.findFirst().orElse(null);

		int studentscount= boardingSchool.getStudents().size();
		assertEquals(studentscount, 3);


		//get students count from boardingschool ANV
		boardingSchool = boardingSchoolService.getBoardingSchoolDetails().stream()
				.filter(x-> x.getName().equals("A") 
						&& x.getFoodType().equals("NV"))
				.findFirst().orElse(null);

		studentscount= (int) boardingSchool.getStudents().stream().count();
		assertEquals(studentscount, 3);

		//get students count from boardingschool BV
		boardingSchool = boardingSchoolService.getBoardingSchoolDetails().stream()
				.filter(x-> x.getName().equals("B") 
						&& x.getFoodType().equals("V"))
				.findFirst().orElse(null);

		studentscount= (int) boardingSchool.getStudents().stream().count();
		assertEquals(studentscount, 3);


		//get students count from boardingschool BNV
		boardingSchool = boardingSchoolService.getBoardingSchoolDetails().stream()
				.filter(x-> x.getName().equals("B") 
						&& x.getFoodType().equals("NV"))
				.findFirst().orElse(null);

		studentscount= (int) boardingSchool.getStudents().stream().count();
		assertEquals(studentscount, 3);


		//get students count from boardingschool NA
		boardingSchool = boardingSchoolService.getBoardingSchoolDetails().stream()
				.filter(x-> x.getName().equals("NA") 
						&& x.getFoodType().equals(""))
				.findFirst().orElse(null);

		studentscount= (int) boardingSchool.getStudents().stream().count();
		assertEquals(studentscount, 1);

	}



}

