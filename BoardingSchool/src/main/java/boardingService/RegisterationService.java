package boardingService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import boardingSchoolException.BoardingSchoolNotFoundException;
import boardingSchoolException.FoodTypeNotFoundexception;

public class RegisterationService  {

	Queue<Student> studentRequests= new LinkedList<>();
	BoardingSchoolService boardingSchoolService;


	public static void main(String[] args)  {

		RegisterationService registerationService = new RegisterationService();


		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.println("enter details");

			String inputDetails = reader.readLine();
			inputDetails= inputDetails.replaceAll("\\s{2,}", " ").trim();

			String[] details = inputDetails.split(" ");
			int size= Integer.parseInt(details[1]);

			BoardingSchoolService boardingSchoolService = new BoardingSchoolService(size);

			while(true) {

				inputDetails = reader.readLine();
				inputDetails = inputDetails.replaceAll("\\s{2,}", " ").trim();			

				if(inputDetails.equals("fin"))
					break;

				String[] words= inputDetails.split(" ");

				System.out.println("name --> "+ words[1]+ words[2]+ " "+words[3]);
				Student student= new Student(words[1], words[2], words[3]);


				registerationService.studentRequests.add(student);
				ProcessRequests( boardingSchoolService, registerationService.studentRequests);
			} 

			boardingSchoolService.PrintBoardingSchoolDetails();
		}

		catch(Exception e) {
			System.out.print("Unexpected  error encountered: "+ e.getMessage());
			e.printStackTrace();
		}

	}


 public	static void  ProcessRequests(BoardingSchoolService boardingSchoolService, Queue<Student> studentRequests)  {

		//int count=1;
		while(!studentRequests.isEmpty()) {
			Student student = studentRequests.poll();
			try {
				boardingSchoolService.Register(student);
			} catch (BoardingSchoolNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FoodTypeNotFoundexception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
}
