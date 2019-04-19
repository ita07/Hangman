package com.application.games.Hangman;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {
	
	private double xOffset = 0;
    private double yOffset = 0;
	
    @FXML
    private AnchorPane menuAnchor;
    
	@FXML
    private Label menuTitle;
	
    @FXML
    private JFXButton startButton, howToPlayButton, aboutButton;

    @FXML
    private OctIconView xIcon;

    @FXML
    void handleAboutButton(ActionEvent event) {

    }

    @FXML
    void handleHowToPlayButton(ActionEvent event) {

    }

    @FXML
    void handleStartButton(ActionEvent event) {

    }
    
    @FXML
    void handleXIcon(MouseEvent event) {

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
