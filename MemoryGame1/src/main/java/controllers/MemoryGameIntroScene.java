package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MemoryGameIntroScene {

	@FXML
	private Button startGameButton;
	@FXML
	private Button leaderboardButton;
	@FXML
	private Button settingsButton;
	
	@FXML
	public void startGameButtonPress() {
		try {
			Scene newScene = FXMLLoader.load(getClass().getClassLoader().getResource("Meginajums2.fxml"));
			Scene oldScene = startGameButton.getScene();
			Stage primaryStage = (Stage)oldScene.getWindow();
			Stage stage = (Stage)startGameButton.getScene().getWindow();
		    stage.close();
			primaryStage.setScene(newScene);
			primaryStage.show();
		}
			catch(Exception e) {
			e.printStackTrace();
			}
	}
	@FXML
	public void leaderboardButtonPress() {
		try {
			Scene newScene = FXMLLoader.load(getClass().getClassLoader().getResource("memoryGameScoreboard.fxml"));
			Scene oldScene = leaderboardButton.getScene();
			Stage primaryStage = (Stage)oldScene.getWindow();
			Stage stage = (Stage) leaderboardButton.getScene().getWindow();
		    stage.close();
			primaryStage.setScene(newScene);
			primaryStage.show();
		}
			catch(Exception e) {
			e.printStackTrace();
			}
	}
	@FXML
	public void settingsButtonPress() {
		try {
			Scene newScene = FXMLLoader.load(getClass().getClassLoader().getResource("memoryGameSettings.fxml"));
			Scene oldScene = settingsButton.getScene();
			Stage primaryStage = (Stage)oldScene.getWindow();
			Stage stage = (Stage) settingsButton.getScene().getWindow();
		    stage.close();
			primaryStage.setScene(newScene);
			primaryStage.show();
		}
			catch(Exception e) {
			e.printStackTrace();
			}
	}
}
