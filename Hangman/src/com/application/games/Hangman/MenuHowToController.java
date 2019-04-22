package com.application.games.Hangman;

import java.io.IOException;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MenuHowToController {
	
	AddingScenes addScene = new AddingScenes();
	DraggableWindow dragWindow = new DraggableWindow();
	
    @FXML
    private AnchorPane menuHowToAnchor;

    @FXML
    private MaterialDesignIconView returnButton;

    @FXML
    void handleMouseDragged(MouseEvent event) {
    	dragWindow.onWindowDragged(menuHowToAnchor, event);

    }

    @FXML
    void handleMousePressed(MouseEvent event) {
    	dragWindow.onWindowPressed(event);
    }

    @FXML
    void handleReturnButton(MouseEvent event) throws IOException {
    	
    	addScene.sceneCreation("Menu.fxml");
    }
    	    

}
