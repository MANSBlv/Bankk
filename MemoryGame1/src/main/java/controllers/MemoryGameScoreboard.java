package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MemoryGameScoreboard {

	@FXML
	private Button backButton;
	@FXML
	public void backButtonPress() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/MemoryGameIntroScene.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			Stage Nstage = (Stage) backButton.getScene().getWindow();
		    Nstage.close();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
}
