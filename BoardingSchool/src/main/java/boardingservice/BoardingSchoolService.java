package boardingservice;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import boardingSchoolException.BoardingSchoolNotFoundException;
import boardingSchoolException.FoodTypeNotFoundexception;



public class BoardingSchoolService {

	private Set<BoardingSchool>  boardingSchools; 


	public BoardingSchoolService(int size) {

		boardingSchools = new HashSet<BoardingSchool>();
		boardingSchools.add(new BoardingSchool("A","V" , size/4));
		boardingSchools.add(new BoardingSchool("A","NV" , size/4));
		boardingSchools.add(new BoardingSchool("B","V" , size/4));
		boardingSchools.add(new BoardingSchool("B","NV" , size/4));
		boardingSchools.add(new BoardingSchool("NA"));
	}

	public Set<BoardingSchool> getBoardingSchoolDetails(){ // For Unit test cases

		return boardingSchools;
	}

	public void Register(Student student) throws BoardingSchoolNotFoundException, FoodTypeNotFoundexception {

		BoardingSchool boardingSchool=getBordingSchool(student);
		boardingSchool.admit(student);
	}

	BoardingSchool getBordingSchool(Student student) throws FoodTypeNotFoundexception, BoardingSchoolNotFoundException{


		Set<String> validBoardingSchoolNames = boardingSchools.stream().map(BoardingSchool:: getName).collect(Collectors.toSet());
		if(!validBoardingSchoolNames.contains(student.getBordingSchool())) {

			throw new BoardingSchoolNotFoundException(" BoardingSchool not found. Boardingschool name : " + student.getBordingSchool()  +" for student id ; " + student.getRegisterNo());

		}

		Set<String> validFoodTypes =  boardingSchools.stream().map(BoardingSchool:: getFoodType).collect(Collectors.toSet());
		if(!validFoodTypes.contains(student.getFoodType()))
		{

			throw new FoodTypeNotFoundexception(" Food type not supported. Food type: " + student.getFoodType()  +" for student id ; " + student.getRegisterNo());

		}

		BoardingSchool boardingSchool = boardingSchools.stream()
				.filter(school ->  school.getName().equals(student.getBordingSchool())
						&& school.getStudents().size() < school.getSize()
						&& school.getFoodType().equals(student.getFoodType()))

				.findFirst().orElse(null);

		// in case Non-veg student didn't have option for Veg boarding school, assigning them Veg boarding school.
		//This will not be true in case of veg student(can't assign veg student a nonVeg boarding school) 
		if(boardingSchool == null  && student.getFoodType().equals("NV") ) {
			student.setFoodType("V");
			boardingSchool = boardingSchools.stream()
					.filter(school ->  school.getName().equals(student.getBordingSchool())
							&& school.getStudents().size() < school.getSize()
							&& school.getFoodType().equals(student.getFoodType())).findFirst().orElse(null);
		}


		boardingSchool= boardingSchool==null?  boardingSchools.stream().filter(school-> school.getName().endsWith("NA")).findFirst().orElse(null): boardingSchool;

		return boardingSchool;
	}


	void PrintBoardingSchoolDetails() {

		boardingSchools.forEach(boardingSchool -> {
			Set<Integer> StudentIds= boardingSchool.getStudents().stream().map(Student:: getRegisterNo).collect(Collectors.toSet());
			System.out.println(boardingSchool.getName()+boardingSchool.getFoodType() + " : " + StudentIds);

		});

	}

}


