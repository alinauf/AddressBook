package application;


//package controller;
import java.io.IOException;

import javax.sound.midi.ControllerEventListener;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
//import model.Person;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	
	private Stage window;
	
	@Override
	
	public void start(Stage primaryStage) {
		this.window = primaryStage; //To Set The Stage
		mainWindow(); // To call main window
		}
	
	public void mainWindow(){//firstWindow
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/application/MainWindowView.fxml"));//TO connect with the view
			AnchorPane pane = loader.load();
			
			MainWindowController mainWindowController = loader.getController(); //The fxml will connect to controller
	 		mainWindowController.setMain(this,this.window);
			
			Scene scene = new Scene(pane);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	
			//window.setFullScreen(true);
			window.setResizable(false);
			window.setScene(scene);
			window.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			e.getCause();
		}
	}
	
	public boolean newPersonWindow(Person person){//personWindow
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/application/NewPersonView.fxml"));//TO connect with the view
			AnchorPane pane = loader.load();
			
			Stage newPersonWindow = new Stage();//New Stage for add
			
			NewPersonController newPersonController = loader.getController(); //The fxml will connect to controller
			newPersonController.setMain(this,newPersonWindow,person);
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	
			//newPersonWindow.setFullScreen(true);
			newPersonWindow.setResizable(false);
			newPersonWindow.setScene(scene);
			newPersonWindow.showAndWait();//shown but waits for user reaction
			return newPersonController.isOkClicked();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			e.getCause();
			return false;
		}
	}
	
	
	
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
	public ObservableList<Person> getPersonData(){
		return personData;		
	}
	
	public Main(){
		//To add Data to Table when program starts
		personData.add(new Person("Charlie","Brown","777008232","London","6666"));
		personData.add(new Person("Mike","mik","777007212","Dubai","12334"));
		personData.add(new Person("dadd","fil","123454321","France","1776"));
		personData.add(new Person("jonny","mdas","87654367","Sri Lanka","65432"));
		personData.add(new Person("dada","mama","0956789345","Germany","14576"));

		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}