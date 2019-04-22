package com.application.games.Hangman;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {
	
	AddingScenes addScene = new AddingScenes();
	DraggableWindow dragWindow = new DraggableWindow();
	//private double xOffset = 0;
    //private double yOffset = 0;    
    @FXML
    private AnchorPane menuAnchor, menuHowToAnchor;
    
	@FXML
    private Label menuTitle;
	
    @FXML
    private JFXButton startButton, howToPlayButton, aboutButton;

    @FXML
    private OctIconView xIcon;

    @FXML
    private MaterialDesignIconView returnButton;
    
    

    @FXML
    void handleAboutButton(ActionEvent event){
    	
    	
    }

    @FXML
    void handleHowToPlayButton(ActionEvent event) throws IOException {
    	
    	addScene.sceneCreation("MenuHowTo.fxml");

    }

    @FXML
    void handleStartButton(ActionEvent event) {

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
