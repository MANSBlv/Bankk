package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.User;
import services.MainService;

public class MemoryGameSignUp {

	@FXML
	private  TextField newUsername;
	@FXML
	private PasswordField newPassword1;
	@FXML
	private PasswordField newPassword2;
	@FXML
	private Button signUpButton;
	
	@FXML
	public void buttonPress() {
		
			
				
				User use=new User(newUsername.getText(), newPassword1.getText(), 0);
				
				try {
					
	                Connection connection=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\maris\\eclipse-workspace\\MemoryGameDb.db");
	               String sql="Select * from Spele where UserName='"+use.getUserName()+"' and Password='"+use.getPassword()+"'";
	               Statement stmt= connection.createStatement();
	               ResultSet rs=stmt.executeQuery(sql);
	               if(rs.next()) {
	            	   Alert alert = new Alert(AlertType.INFORMATION, "Username already exists or the entered password is incorrect ");
	       			alert.show();
	               }else {
	            	   PreparedStatement Pstatement=connection.prepareStatement("insert into Spele(UserName,Password) values(?,?);");
		                Pstatement.setString(1,use.getUserName());
		               Pstatement.setString(2,use.getPassword());
		                
		                  int x=  Pstatement.executeUpdate();
		                  //Pstatement.close();
		                  if(x>0) {
		                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
		                  }else {
		                	  JOptionPane.showMessageDialog(null,"Data Registered fail");
		                  }
	               }
	              
	               	connection.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	            
			
				
				try {
				Scene newScene = FXMLLoader.load(getClass().getClassLoader().getResource("MemoryGameLogin.fxml"));
				Scene oldScene = signUpButton.getScene();
				Stage primaryStage = (Stage)oldScene.getWindow();
				Stage stage = (Stage) signUpButton.getScene().getWindow();
			    stage.close();
				primaryStage.setScene(newScene);
				primaryStage.show();
			}
				catch(Exception e) {
				e.printStackTrace();
				}
		}
		}
		

