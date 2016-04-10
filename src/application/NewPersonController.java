package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.nio.cs.ext.ISO2022_KR;

public class NewPersonController {

	private Main main;
	Stage window;
	Person person;
	private Boolean okClicked = false;
	
	@FXML private TextField firstNameField,lastNameField,phoneField,cityField,postField;

	public void setMain(Main main,Stage primaryStage,Person person) {
		this.main = main;
		this.window=primaryStage;
		this.person=person;
		if(person !=  null)
			fillPersonDetails();
		
	}
	
	public void fillPersonDetails(){
		firstNameField.setText(person.getFirstName());
		lastNameField.setText(person.getLastName());
		phoneField.setText(person.getPhone());
		cityField.setText(person.getCity());
		postField.setText(person.getPostCode());
		
	}
	
	public boolean isOkClicked(){
		return okClicked;
	}
	
	@FXML 
	public void handleOk(){
		
		if(person != null){
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());
			person.setPhone(phoneField.getText());
			person.setCity(cityField.getText());
			person.setPostCode(postField.getText());
			okClicked= true;
		}
		else{
		//Read info from textField and put to table
		
		Person newperson = new Person(
				firstNameField.getText(),
				lastNameField.getText(),
				phoneField.getText(),
				cityField.getText(),
				postField.getText());

		main.getPersonData().add(newperson);
		}
		window.close();

	}
	
	@FXML 
	public void handleCancel(){
		window.close();
	}
	
}
