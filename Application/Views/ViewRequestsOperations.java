package Application.Views;

import java.util.List;

import Application.Controllers.Controller;
import Application.Models.Requirement;
import Application.Models.Teacher;

public class ViewRequestsOperations {
	private boolean isActive = true;
	private Controller controller;

	public ViewRequestsOperations(Controller controller){
		this.controller = controller;
	}

// For Course Director to request to add requirements
	protected void requestAddRequirement() {

		System.out.println("You choosed to add requirement, please follow the instructions: ");
		int subjectID = Integer.parseInt(InputUtil.enterValue("Enter SubjectID: "));
		int hours = Integer.parseInt(InputUtil.enterValue("Enter required hours: "));
		int experience = Integer.parseInt(InputUtil.enterValue("Teacher's Experience: "));

		controller.addNewRequirement(subjectID, hours, experience);
		
	}

	// For both Course Director and administrator to request to add teacher
	protected void requestAddTeacher() {

		System.out.println("You choosed add teacher option. For adding new teacher please specify teacher details: ");
		String name = InputUtil.enterValue("Teacher's name: ");
		int subjectID = Integer.parseInt(InputUtil.enterValue("Teacher's subject ID: "));
		int experience = Integer.parseInt(InputUtil.enterValue("Teacher's Experience: "));

		controller.addNewTeacher(name, subjectID, experience);
	}

//	For both Course Director and administrator to request to get all list of matched teachers
	protected void requestGetListOfMachedTeachers() {

		System.out.println("List of matched teachers");
		String subjectIDStr = InputUtil.enterValue("Enter SubjectID: ");
		int subjectID = Integer.parseInt(subjectIDStr);
		List<Teacher> listOfMatchedTeachers = controller.matchTeacherWithRequirement(subjectID);
		int order = 1;

		for (Teacher teacher : listOfMatchedTeachers) {
			System.out.println(order++ + ". " + teacher.getName() + ". taught subject id is " + teacher.getSubjectId()
					+ " and has " + teacher.getExperience() + " years experience");
		}
	}
	  public void displayTeachingRequirements() {
    List<Requirement> requirements = controller.getAllRequirements();

    if (requirements != null && !requirements.isEmpty()) {
      System.out.println("Teaching Requirements for the Upcoming Term/Semester:");
      for (Requirement requirement : requirements) {
        displayTeachingRequirement(requirement);
      }
    } else {
      System.out.println("No teaching requirements available for the upcoming term/semester.");
    }
  }

  private void displayTeachingRequirement(Requirement requirement) {
    System.out.println("Subject ID: " + requirement.getSubjectId() + " | Hours: " + requirement.getHours()
        + " |Minimum Experience: " + requirement.getMinimumExperience());

  }
	
  protected void BookTraining() {
		
		System.out.println("You choosed Booktraining by typing their name and ID and Experience: ");
		
		String name = InputUtil.enterValue("Teacher's name: ");
		
		int TeachersId = Integer.parseInt(InputUtil.enterValue("Teacher's ID: "));
	
		int subjectID = Integer.parseInt(InputUtil.enterValue("Teacher's subject ID: "));
		
		String Date = InputUtil.enterValue("Enter Date: ");
		
		
	   List<Teacher> getTeacherInfo= Teacher.getAll();
	   
	   Boolean matchFound = false;
	  
	   
	   for(Teacher teachers: getTeacherInfo) {
		   
			   if(teachers.getName().contains(name) && teachers.getId() == TeachersId ) { 
				   
				   controller.bookTraining(TeachersId,subjectID,Date);
				   
					matchFound = true;
					
					System.out.println("Training booked successfully for the following details:");
					System.out.println("Teacher's Name: " + name);
				    System.out.println("Teacher's ID: " + TeachersId);
				    System.out.println("Subject ID: " + subjectID);
				    System.out.println("Date: " + Date);
				    	   
			   }
		   
	   }
	   
	   if(matchFound !=true) {
		   System.out.println("No Teacher found with this Details");
	   }
		
	
	}


	protected void displayTeachers() {
		List<Teacher> teachers = controller.getAllTeachers();
	
		if (teachers != null && !teachers.isEmpty()) {
		  System.out.println("The available teachers Upcoming Term/Semester:");
		  for (Teacher teacher : teachers) {
			displayTeacher(teacher);
		  }
		} else {
		  System.out.println("No available teachers");
		}

	  }
	
	  private void displayTeacher(Teacher teachers) {
		System.out.println("Name: " + teachers.getName() + " |Experience: " + teachers.getExperience() + "|Subject id" + teachers.getSubjectId());
	
	  }


//	To close the app
	protected  void closeApp() {
		isActive = false;
		System.out.println("Application is closed");
	}

	protected boolean isOpen() {
		return isActive;
	}

}
