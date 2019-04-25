package com.application.games.Hangman;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//Adds drag functionality to every window
public class DraggableWindow {
	
	private double xOffset = 0;
    private double yOffset = 0; 
    
    //Gets x , y coords of the window
    public void onWindowPressed(MouseEvent event) {
    	xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }
    
    //adjust coords according to the position it's dragged
    public void onWindowDragged(AnchorPane pane, MouseEvent event) {
    	Stage stage = (Stage) pane.getScene().getWindow();
    	stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

}
