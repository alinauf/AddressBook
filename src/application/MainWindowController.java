package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainWindowController {

	//variables
	private Main main;
	private Stage window;
	
	//References to views
	@FXML TableView<Person> tableView;
	@FXML TableColumn<Person, String> firstNameColumn;
	@FXML TableColumn<Person, String> lastNameColumn;
	
	@FXML Label firstNameLabel,lastNameLabel,phoneLabel,cityLabel,postCodeLabel;


	public void setMain(Main main,Stage primaryStage) {
		this.main = main;
		this.window=primaryStage;
		tableView.setItems(main.getPersonData());
	}
	
	public void initialize(){ //System method which is called automatically
			firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));//To set values for column
			lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));//To set values for column

			tableView.getSelectionModel().selectedItemProperty().addListener( //To get currently selected tableColumn
					(observable,oldValue,newValue)->showDetails(newValue));
	}

	
	public void showDetails(Person person){ //To show the value of selected table in labels
		try {
			
		
		firstNameLabel.setText(person.getFirstName());
		lastNameLabel.setText(person.getLastName());
		phoneLabel.setText(person.getPhone());
		cityLabel.setText(person.getCity());
		postCodeLabel.setText(person.getPostCode());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	public void handleNew(){
		main.newPersonWindow(null);
	}
	
	@FXML
	public void handleEdit(){
		Person person=tableView.getSelectionModel().getSelectedItem();
		Boolean okClicked=main.newPersonWindow(person);
		if(okClicked){
			refreshTableView();
		}

	}
	
	@FXML
	public void handleDelete(){
		int index =tableView.getSelectionModel().getSelectedIndex(); //get selected index
		main.getPersonData().remove(index); //remove from observable list
		
	}
	
	public void refreshTableView(){
		tableView.setItems(null);
		tableView.layout();
		tableView.setItems(main.getPersonData());
		
	}
	
	
	
}
