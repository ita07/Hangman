package com.application.games.Hangman;


import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainGameController {
	
	AddingScenes addScene = new AddingScenes();
	DraggableWindow dragWindow = new DraggableWindow();
	WordInputController wordInput = new WordInputController();
	private int index;
	private String secretWord, value;
	private StringBuilder wordToGuess;
	private  double  labelLayoutX = 173.0;
	private  double labelLayoutY = 302.0;

    @FXML
    private AnchorPane mainGameAnchor;

    @FXML
    private Circle head;

    @FXML
    private Line body, rightFoot, leftArm, rightArm, leftFoot;

    @FXML
    private Label guessesLeft, word;
    
    @FXML
    private Text textWord;
    
    @FXML
    //On window creation
    public void initialize() {
    	//The word the user has to guess
    	secretWord = wordInput.getWordToGuess();
    	//Use StringBuilder because it's mutable unlike Strings
    	wordToGuess = new StringBuilder();
    	//Set number of * equal to the length of our word to guess
    	wordToGuess.append(StringUtils.repeat("*", secretWord.length()));
    	//Update our ui from the StringBuilder variable which holds the text we see
    	textWord.setText(wordToGuess.toString());
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
    			value = label.getText();
    			//Since every letter is in capital on the label we have to check for its existance in lowercase inside the word
    			boolean check = secretWord.contains(value.toLowerCase());
    			if (check) {
    				//Swapping letters with *
    				index = secretWord.indexOf(value.toLowerCase());
    				//Find all occurrences of the same letter in the word and replace them 
    		    	while(index > -1) {
    		    		handleCorrectLetter();
    		    		index = secretWord.indexOf(value.toLowerCase(), index + 1);
    		    	}
    				//Winning message
    				if (!textWord.getText().contains("*")) {
    					Alert alert2 = new Alert(AlertType.INFORMATION);
    					alert2.initOwner(Main.getPrimaryStage());
    					alert2.setHeaderText(null);
    			    	alert2.setTitle("You won");
    			    	alert2.setContentText("You managed to save the hanging person and beat the game!");
    			    	alert2.showAndWait();
    			    	System.exit(0);
        			}

    			} else {
    				//Deduct points
    				handleGuesses();
    			}
  		});
    		mainGameAnchor.getChildren().add(label);
    		labelLayoutX += 40.0;
    		
    	}
    	
    	
    }
    
    void handleGuesses() {

    	int counter = Integer.parseInt(guessesLeft.getText());
    	counter--;
    	guessesLeft.setText(Integer.toString(counter));
    	switch (counter) {
    	
    	case 5:
    		head.setVisible(true);
    		break;
    	case 4:
    		body.setVisible(true);
    		break;
    	case 3:
    		leftArm.setVisible(true);
    		break;
    	case 2:
    		rightArm.setVisible(true);
    		break;
    	case 1:
    		leftFoot.setVisible(true);
    		break;
    	case 0:
    		rightFoot.setVisible(true);
    		mainGameAnchor.setDisable(true);
    		Alert alert1 = new Alert(AlertType.INFORMATION);
    		alert1.initOwner(Main.getPrimaryStage());
    		alert1.setHeaderText(null);
        	alert1.setTitle("You lost!");
        	alert1.setContentText("The correct word was " + secretWord +"\nYou didnt manage to save the hanging person. Better luck next time!");
        	alert1.showAndWait();
        	System.exit(0);
    	}
    }

    void handleCorrectLetter() {
    	//Get the index of the letter we pressed from the secretWord
    	char c = secretWord.charAt(secretWord.indexOf(value.toLowerCase()));
    	//Replace * with the actual letter in the word
        wordToGuess.setCharAt(index, c);
        //Update the word on the screen
    	textWord.setText(wordToGuess.toString());
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