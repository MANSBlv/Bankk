package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.User;
import services.MainService;

public class MemoryGameLogin {

	@FXML
	private  TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button button;
	@FXML
	private Button registrationButton;

	
	@FXML
	public void buttonPress() {
		
		User use=new User(usernameField.getText(), passwordField.getText(), 0);
		
		try {
			Connection connection=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\maris\\eclipse-workspace\\MemoryGameDb.db");
            String sql="Select * from Spele where UserName='"+use.getUserName()+"' and Password='"+use.getPassword()+"'";
            Statement stmt= connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()) {
            	JOptionPane.showMessageDialog(null,"Login Successful");
            	
            	try {
		
		
            		Parent root = FXMLLoader.load(getClass().getResource("/MemoryGameIntroScene.fxml"));
            		
    				Scene scene = new Scene(root);
    				Stage stage = new Stage();
    				Stage primStage = (Stage) button.getScene().getWindow();
    			    primStage.close();
    				stage.setScene(scene);
    				stage.show();
    				
    			}
    				catch(Exception e) {
    				e.printStackTrace();
    				}

	
		
            	}else {
            			Alert alert = new Alert(AlertType.INFORMATION, "The entered data is incorrect");
            			alert.show();
            	}
            connection.close();
		 } catch (SQLException e1) {
             e1.printStackTrace();
         }
	}
	
	public void buttonPress2() {
		try {
		Scene signUpScene = FXMLLoader.load(getClass().getResource("/MemoryGameSignUp.fxml"));
		Scene oldScene = registrationButton.getScene();
		Stage primaryStage = (Stage)oldScene.getWindow();
		Stage stage = (Stage) registrationButton.getScene().getWindow();
	    stage.close();
		primaryStage.setScene(signUpScene);
		primaryStage.show();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
