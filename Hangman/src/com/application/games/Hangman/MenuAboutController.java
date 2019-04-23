package com.application.games.Hangman;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MenuAboutController {
	
	AddingScenes addScene = new AddingScenes();
	DraggableWindow dragWindow = new DraggableWindow();
    @FXML
    private AnchorPane menuAboutAnchor;

    @FXML
    private MaterialDesignIconView returnButton;

    @FXML
    private Hyperlink aboutHyperlink;
    
    @FXML
    void handleLinkClick(ActionEvent event) {
    	
    	if (Desktop.isDesktopSupported()) {
	    	try {
				Desktop.getDesktop().browse(new URI("https://github.com/ita07"));
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    @FXML
    void handleMouseDragged(MouseEvent event) {
    	
    	dragWindow.onWindowDragged(menuAboutAnchor, event);

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
