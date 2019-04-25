package com.application.games.Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class WordInputController {
	
	AddingScenes addScene = new AddingScenes();
	DraggableWindow dragWindow = new DraggableWindow();
	String wordToGuess;
	
    @FXML
    private AnchorPane wordInputAnchor;

    @FXML
    private MaterialDesignIconView returnButton;


    @FXML
    private JFXButton submitButton, clearButton, randomWordButton;
    
    @FXML
    private JFXTextField textField;


    @FXML
    void handleClearButton(ActionEvent event) {
    	textField.clear();
    	
    }	

    @FXML
    void handleKeyTypedTextfield(KeyEvent event) {
    	if (!event.getCharacter().matches("[a-z\b]") || (textField.getText().length() > 20)) {
    		event.consume();
    	}
    }
    

    @FXML
    void handleMouseDragged(MouseEvent event) {
    	dragWindow.onWindowDragged(wordInputAnchor, event);
    }

    @FXML
    void handleMousePressed(MouseEvent event) {
    	dragWindow.onWindowPressed(event);
    }
    //Reads from Wordlist.txt, adds everything to an ArrayList and randomly picks a int then gets the String 
    //on that int which sets it as a value to the textfield
    @FXML
    void handleRandomWordButton(ActionEvent event) throws FileNotFoundException, IOException {
    	ArrayList<String> arrayList = new ArrayList<String>();
    	Random randomIndex = new Random();
    	String filename = "src/com/application/games/Hangman/Wordlist.txt";
    	FileReader fileReader = new FileReader(filename);
		
    	
    	try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
    		String line;
    		while ((line = bufferedReader.readLine()) != null) {
    			
    			arrayList.add(line);
    		}
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    	textField.setText(arrayList.get(randomIndex.nextInt(arrayList.size())));	  		
    }

    @FXML
    void handleSubmitButton(ActionEvent event) {
    	
    }
    
    @FXML
    void handleReturnButton(MouseEvent event) throws IOException {
    	
    	addScene.sceneCreation("Menu.fxml");
    	
    }

}
