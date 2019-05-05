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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class WordInputController {
	
	AddingScenes addScene = new AddingScenes();
	DraggableWindow dragWindow = new DraggableWindow();
	private static String wordToGuess;
	
    @FXML
    private AnchorPane wordInputAnchor;

    @FXML
    private MaterialDesignIconView returnButton;


    @FXML
    private JFXButton submitButton, clearButton, randomWordButton;
    
    @FXML
    private JFXTextField textField;
    
    @FXML
    //Make a custom textfield to override the paste function of the parent thus restricting the user from pasting on it
    public void initialize() {
        textField = new JFXTextField() {
            @Override
            public void paste() {
            }
        };

        textField.setLayoutX(106.0);
        textField.setLayoutY(62.0);
        textField.prefHeight(37.0);
        textField.prefWidth(70.0);
        Font font = Font.font(18);
        textField.setFont(font);
        textField.setPromptText("Enter a-z letters only!");
        textField.setFocusColor(Paint.valueOf("2e27ae"));
        textField.setUnFocusColor(Paint.valueOf("2e27ae"));
        textField.setLabelFloat(true);
        //Allow user to enter only letters from a-z and backspace
        textField.setOnKeyTyped(event -> {
            if (!event.getCharacter().matches("[a-z\b]") || (textField.getText().length() > 20)) {
                event.consume();
            }
        });
        //Add the textfield to the anchorpane of the fxml
        wordInputAnchor.getChildren().add(textField);
        
    }
    
    @FXML
    void handleClearButton(ActionEvent event) {
    	textField.clear();
    	
    }	

    @FXML
    void handleMouseDragged(MouseEvent event) {
    	dragWindow.onWindowDragged(wordInputAnchor, event);
    }

    @FXML
    void handleMousePressed(MouseEvent event) {
    	dragWindow.onWindowPressed(event);
    }
    
    @FXML
    //Reads from Wordlist.txt, adds everything to an ArrayList and randomly picks a int then gets the String 
    //on that int which sets it as a value to the textfield
    void handleRandomWordButton(ActionEvent event) throws FileNotFoundException, IOException {
    	ArrayList<String> arrayList = new ArrayList<String>();
    	Random randomIndex = new Random();
    	String filename = "src/com/application/games/Hangman/Wordlist.txt";
    	FileReader fileReader = new FileReader(filename);
		
    	//Wrap a BufferedReader around the FileReader
    	try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
    		String line;
    		while ((line = bufferedReader.readLine()) != null) {
    			
    			arrayList.add(line);
    		}
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    	//Get random int from the arrayList and add the String on that position on the textfield
    	textField.setText(arrayList.get(randomIndex.nextInt(arrayList.size())));	  		
    }

    @FXML
    void handleSubmitButton(ActionEvent event) throws IOException {
    	if (textField.getLength() > 2) {
        	submitButton.setDisable(false);
        	wordToGuess = textField.getText();
        	addScene.sceneCreation("MainGame.fxml");
        } else {
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.initOwner(Main.getPrimaryStage());
        	alert.setHeaderText(null);
        	alert.setTitle("Error occured!");
        	alert.setContentText("Enter 3 or more letter words for the game to start!");
        	alert.showAndWait();

        }
    	
    }
    
    @FXML
    void handleReturnButton(MouseEvent event) throws IOException {
    	
    	addScene.sceneCreation("Menu.fxml");
    	
    }
    
	public String getWordToGuess() {
		return wordToGuess;
	}

}
