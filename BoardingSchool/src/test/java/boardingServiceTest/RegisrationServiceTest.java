package boardingServiceTest;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import boardingservice.BoardingSchool;
import boardingservice.BoardingSchoolService;
import boardingservice.RegisterationService;
import boardingservice.Student;

public class RegisrationServiceTest {
	
	
	
	@Test
	public void  TestRegistrationService() {
		
		
		BoardingSchoolService boardingSchoolService = new BoardingSchoolService(12);
		Queue<Student> queue= new LinkedList<>(); 
		
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
		
		queue.add(student1);
		queue.add(student2);
		queue.add(student3);
		queue.add(student4);
		queue.add(student5);
		queue.add(student6);
		queue.add(student7);
		queue.add(student8);
		queue.add(student9);
		queue.add(student10);
		queue.add(student11);
		queue.add(student12);
		queue.add(student13);
		
		RegisterationService.ProcessRequests(boardingSchoolService, queue);
		
		
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
