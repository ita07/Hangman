package com.application.games.Hangman;


import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import org.apache.commons.lang3.StringUtils;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class MainGameController {
	
	AddingScenes addScene = new AddingScenes();
	DraggableWindow dragWindow = new DraggableWindow();
	WordInputController wordInput = new WordInputController();
	private  double  labelLayoutX = 173.0;
	private  double labelLayoutY = 302.0;
	
	
	private Text text;
	String secretWord;

    @FXML
    private AnchorPane mainGameAnchor;

    @FXML
    private Circle head;

    @FXML
    private Line body, rightFoot, leftArm, rightArm, leftFoot;

    @FXML
    private Label guessesLeft, word;
    
    @FXML
    private Text wordToGuess;
    
    @FXML
    //On window creation
    public void initialize() {
    	secretWord = wordInput.getWordToGuess();
    	//Set number of * equal to the length of our word to guess
    	wordToGuess.setText(StringUtils.repeat("*", secretWord.length()));
    	
    	//Make a labels list to store all the labels from A-Z while creating them and setting them on the pane
    	ArrayList<Label> labels = new ArrayList<>();
    	//
    	char ch = 'A';
    	for (int i =0; i<26; i++) {
    		//Set the name of every label on its constructor parameter
    		Label label = new Label(String.valueOf(ch));
    		labels.add(label);    	
    		ch++;
    		//Print from A-M then place N below A and keep placing then in a row so they are all aligned 
    		if (label.getText().equals("N")) {
    			labelLayoutX = 172;
    			label.setLayoutX(labelLayoutX);
        		labelLayoutY+= 44.0;
        		label.setLayoutY(labelLayoutY);

    		} else {
    			label.setLayoutX(labelLayoutX);
        		label.setLayoutY(labelLayoutY);

    		}
    		
    		label.setUnderline(true);
    		label.setFont(Font.font("System", 25));
    		label.setCursor(Cursor.HAND);
    		//When a label is clicked get the value of that label
    		label.setOnMouseClicked(event -> {
    			label.setDisable(true);
    			String value = label.getText();
    			//Since every letter is in capital on the label we have to check for it in lowercase inside the word
    			boolean check = secretWord.contains(value.toLowerCase());
    			if (check) {
    				System.out.println("This letter is in the word");
    				//Deduct points - guessesLeft--
    			} else {
    				System.out.println("This letter isn't in the word");
    				//Replace the * on the screen with this letter
    			}

    		});
    		mainGameAnchor.getChildren().add(label);
    		labelLayoutX += 40.0;
    		
    	}
    	
    	
    }
    
    @FXML
    void handleLetterClick() {
    	
    }
    
    @FXML
    void handleXIcon(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void handleMouseDragged(MouseEvent event) {
    	dragWindow.onWindowDragged(mainGameAnchor, event);

    }

    @FXML
    void handleMousePressed(MouseEvent event) {
    	dragWindow.onWindowPressed(event);

    }

}