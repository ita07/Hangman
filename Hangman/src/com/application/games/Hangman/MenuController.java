package com.application.games.Hangman;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MenuController {
	
	AddingScenes addScene = new AddingScenes();
	DraggableWindow dragWindow = new DraggableWindow();
  
    @FXML
    private AnchorPane menuAnchor;
    
	@FXML
    private Label menuTitle;
	
    @FXML
    private JFXButton startButton, howToPlayButton, aboutButton;

    @FXML
    private OctIconView xIcon;

    @FXML
    private MaterialDesignIconView returnButton;
    
    

    @FXML
    void handleAboutButton(ActionEvent event) throws IOException{
    	
    	addScene.sceneCreation("MenuAbout.fxml");
    }

    @FXML
    void handleHowToPlayButton(ActionEvent event) throws IOException {
    	
    	addScene.sceneCreation("MenuHowTo.fxml");

    }

    @FXML
    void handleStartButton(ActionEvent event) throws IOException {
    	
    	addScene.sceneCreation("WordInput.fxml");
    	
    }
    
    @FXML
    void handleXIcon(MouseEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void handleMouseDragged(MouseEvent event) {
    	dragWindow.onWindowDragged(menuAnchor, event);
    }

    @FXML
    void handleMousePressed(MouseEvent event) {
    	dragWindow.onWindowPressed(event);
    }
    

}
