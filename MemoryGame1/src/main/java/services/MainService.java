package services;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.User;

public class MainService extends  Application{
	public static ArrayList<User> allUsers = new ArrayList<User>();
	public static void main(String[] args) {
		
		//User u1= new User ("madara","cucins",0);
		
		//allUsers.add(u1);
	
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = FXMLLoader.load(getClass().getClassLoader().getResource("MemoryGameLogin.fxml"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
