package com.application.games.Hangman;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Changes scenes using the same stage for every part of the application
public class AddingScenes {
	
	public void sceneCreation(String fxmlScene) throws IOException {
		Parent fxmlLoader = FXMLLoader.load(getClass().getResource(fxmlScene));
    	Scene scene = new Scene(fxmlLoader);
    	Stage window = Main.getPrimaryStage();
    	window.setScene(scene);
	}
	
}
