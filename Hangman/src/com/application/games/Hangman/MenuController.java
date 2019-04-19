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
	
	private double xOffset = 0;
    private double yOffset = 0;    
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
    void handleAboutButton(ActionEvent event) throws IOException{
    	
    	Parent menuHowTo = FXMLLoader.load(getClass().getResource("MenuHowTo.fxml"));
    	Scene sceneHowTo = new Scene(menuHowTo);
    	Stage window = Main.getPrimaryStage();
    	window.setScene(sceneHowTo);	

    }
    
    @FXML
    void handleReturnButton(MouseEvent event) {
		try {
			Parent menu;
			menu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene sceneMenu = new Scene(menu);
			Stage window = Main.getPrimaryStage();
	    	window.setScene(sceneMenu);				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }
		

    @FXML
    void handleHowToPlayButton(ActionEvent event) {
    
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
    	Stage stage = (Stage) menuAnchor.getScene().getWindow();
    	stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    @FXML
    void handleMousePressed(MouseEvent event) {
    	xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }
    

}
