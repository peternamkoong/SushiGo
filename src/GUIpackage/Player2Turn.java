package GUIpackage;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Player2Turn class is called when the Player 2 Turn button is clicked
 * in the PlayScreen class. The second player or the AI then gets to select a card
 * on playing field, which will then be added to the player's board.
 */
public class Player2Turn {
	Stage window;
	LinkedList<Button> hand;
	private HBox player2Hbox;
	private HBox player2Hbox2 = new HBox(5);
	private int count = 1;
	private PlayScreen playGame;
	static ArrayList<String> boardOfStrings = new ArrayList<String>();
	Random randNum;

	/**
	 * the getBoardOfStrings method is a getter method to get the player's
	 * board, but as a string in the ArrayList.
	 * @return boardOfStrings	Board of Strings is an ArrayList that stores
	 * 							the card's name in each index of the ArrayList.
	 */
	public ArrayList<String> getBoardOfStrings() {
		return boardOfStrings;
	}
	
	/**
	 * the setHandPlayer2 method sets the hand with the newHand parameter
	 * @param newHand	newHand is a LinkedList of type button.
	 */
	public void setHandPlayer2(LinkedList<Button> newHand) {
		hand = new LinkedList<Button>(newHand);
	}
	
	/**
	 * getPlayer2Hand is a getter method of the LinkedList hand that is
	 * set from the setHandPlayer2 method. 
	 * @return hand		returns the hand of type LinkedList<Button>
	 */
	public LinkedList<Button> getPlayer2Hand() {
		return hand;
	}
	
	/**
	 * the easyAI method randomly selects a card using the Random
	 * Import and uses that random integer, it gets it from the hand.
	 * @param hand		hand is a LinkedList of type Button
	 * @return card		returns the selected card after the AI selects
	 * 					the random integer and gets it from the hand.
	 */
	public Button easyAI(LinkedList<Button> hand) {
		randNum = new Random();
		int cardNum = randNum.nextInt(hand.size());
		Button card = hand.get(cardNum);
		return card;
	}
	
	/**
	 * putOnBoard is a method that puts the card that the user selects onto the
	 * board that is correlated to the player. If cardPlayed is already in the board,
	 * the board will add +1 to the Hashtable, else it will add that cardPlayed to the
	 * Hashtable.
	 * @param board			takes in a Hashtable that contains the names of the cards
	 * 						and how many of that card there is.
	 * @param cardPlayed		takes the string of the card that was played and checks
	 * 						to see if that card is already in the board or not.
	 */
	public void putOnBoard(Hashtable<String, Integer> board, String cardPlayed) {
        if (board.containsKey(cardPlayed))
			board.replace(cardPlayed, (board.get(cardPlayed) + 1));
		else
			board.put(cardPlayed, 1);
	}
	
	/**
	 * the hardAI method is a lot more detailed method in the way the
	 * AI selects the card. It does a lot of checks to see what is in the
	 * hand and what is most likely to give the AI a greater score.
	 * @param hand			hand is a LinkedList of type Button
	 * @return aiChoice		returns the card that is chosen after
	 * 						going through multiple checks to see what
	 * 						will provide the highest score.
	 */
	public Button hardAI(LinkedList<Button> hand) {
		LinkedList<String> aiHand = new LinkedList<String>();
		Hashtable<String, Integer> allCards = new Hashtable<String, Integer>();
		int turn = playGame.getPlayerTurnCount(2);
		
		
		for(int card = 0; card < hand.size(); card++) {
			String theCard = hand.get(card).getText();
			aiHand.add(theCard);
			putOnBoard(allCards,theCard);
		}
		
		//adds the other player's hand into the hashtable that contains all cards
		for(int p1Cards = 0; p1Cards<playGame.getHand(1).size(); p1Cards ++) {
			String otherCard = playGame.getHand(1).get(p1Cards).getText();
			putOnBoard(allCards,otherCard);
		}
		String card = "";
		int cardNum;
		Random randNum = new Random();
		switch(turn) {
			case 0: {
				if(aiHand.contains("Pudding"))
					card = "Pudding";
				else if((allCards.getOrDefault("SquidNigiri", 0)  >= 1) && aiHand.contains("Wasabi"))
					card = "Wasabi";
				else if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if((allCards.getOrDefault("Sashimi", 0)  >= 3) && aiHand.contains("Sashimi"))
					card = "Sashimi";
				else if((allCards.getOrDefault("Tempura", 0)  >= 2) && aiHand.contains("Tempura"))
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;
			}
			case 1:{
				if(aiHand.contains("Pudding"))
					card = "Pudding";	
				else if((allCards.getOrDefault("SquidNigiri", 0)  >= 1) && aiHand.contains("Wasabi"))
					card = "Wasabi";
				else if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if((allCards.getOrDefault("Sashimi", 0)  >= 2) && aiHand.contains("Sashimi"))
					card = "Sashimi";
				else if((allCards.getOrDefault("Tempura", 0)  >= 1) && aiHand.contains("Tempura"))
					card = "Tempura";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) >= 1 && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) < 2)
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;		
			}
			
			case 2:{
				if(aiHand.contains("Pudding"))
					card = "Pudding";
				else if((allCards.getOrDefault("SquidNigiri", 0)  >= 1) && aiHand.contains("Wasabi"))
					card = "Wasabi";
				else if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if((allCards.getOrDefault("Sashimi", 0)  >= 1) && aiHand.contains("Sashimi"))
					card = "Sashimi";
				else if((allCards.getOrDefault("Tempura", 0)  >= 1) && aiHand.contains("Tempura"))
					card = "Tempura";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) >= 1 && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) < 2)
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;
			}
			case 3:{
				if(aiHand.contains("Sashimi") && playGame.getPlayerBoard(2).getOrDefault("Sashimi", 0) >= 1)
					card = "Sashimi";
				else if((allCards.getOrDefault("SquidNigiri", 0)  >= 1) && aiHand.contains("Wasabi"))
					card = "Wasabi";
				else if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if((allCards.getOrDefault("Sashimi", 0)  >= 2) && aiHand.contains("Sashimi"))
					card = "Sashimi";
				else if((allCards.getOrDefault("Tempura", 0)  >= 1) && aiHand.contains("Tempura"))
					card = "Tempura";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) >= 1 && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) < 2)
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;
			}
			case 4:{
				if(aiHand.contains("Sashimi") && playGame.getPlayerBoard(2).getOrDefault("Sashimi", 0) >= 1 && playGame.getPlayerBoard(2).getOrDefault("Sashimi", 0) < 3)
					card = "Sashimi";
				else if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if((allCards.getOrDefault("Sashimi", 0)  >= 2) && aiHand.contains("Sashimi"))
					card = "Sashimi";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) >= 1 && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) < 2)
					card = "Tempura";
				else if((allCards.getOrDefault("Tempura", 0)  >= 1) && aiHand.contains("Tempura"))
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;
			}
			case 5:{
				if(aiHand.contains("Sashimi") && playGame.getPlayerBoard(2).getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;
			}
			case 6:{
				if(aiHand.contains("Sashimi") && playGame.getPlayerBoard(2).getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
			}
			case 7:{
				if(aiHand.contains("Sashimi") && playGame.getPlayerBoard(2).getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;
			}
			case 8:{
				if(aiHand.contains("Sashimi") && playGame.getPlayerBoard(2).getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;
			}
			case 9:{
				if(aiHand.contains("Sashimi") && playGame.getPlayerBoard(2).getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				if(aiHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				else if(aiHand.contains("Tempura") && playGame.getPlayerBoard(2).getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				else if(aiHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				else if(aiHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(aiHand.size());
					card = aiHand.get(cardNum);
				}
				break;
			}
			default:{
				cardNum = randNum.nextInt(aiHand.size());
				card = aiHand.get(cardNum);
			}
		}
		Button aiChoice = null;
		for(int chosenButton = 0; chosenButton < hand.size(); chosenButton++) {
			if(card == hand.get(chosenButton).getText())
				aiChoice = hand.get(chosenButton);	
		}
		return aiChoice;		
	}
	
	/**
	 * setHandButtons method sets the buttons of the cards in your current
	 * hand so you can see which card to choose and can physically click it
	 * on the GUI. As well, each button has actions that are taken to store the name
	 * in the boardOfString, remove the card from the hand, add it to the board, update
	 * the hand, and set the player.
	 * @param hand	the hand is used to get the buttons from.
	 */
	
	public void setHandButtons(LinkedList<Button> hand) {
		player2Hbox = new HBox(5);
		playGame = new PlayScreen();
		for(int card = 0; card < hand.size(); card++) {
			player2Hbox.getChildren().add(hand.get(card));
			hand.get(card).setOnAction(e -> {
				boolean answer = ConfirmBox.choiceCard();
				if (answer) {
					String cardPlayed = ((Button)(e.getSource())).getText();
					Button buttonPlayed = ((Button)(e.getSource()));
					boardOfStrings.add(cardPlayed);
					hand.remove(buttonPlayed);
					playGame.putOnBoard(playGame.getPlayerBoard(2), cardPlayed);
					player2Hbox.getChildren().remove(buttonPlayed);
					playGame.updateHand(getPlayer2Hand(), 2);
					playGame.setPlayerCount(count, 2);
					for(int allButtons = 0; allButtons <hand.size(); allButtons++)
						player2Hbox.getChildren().remove(hand.get(allButtons));
					window.setScene(playGame.playScene(window));
					
				}
			});
		}
	}
	
	/**
	 * the p2Turn method used the other methods and adds them to a StackPane,
	 * including the background and buttons. In order to determine whether or 
	 * not it is a pvp, pve, or pvh mode, it gets the playMode int value and
	 * uses that as a check.
	 * @param primaryStage		a stage which appears as a window
	 * @return player2Scene		returns the player1Scene which contains all
	 * 							the elements in the scene.
	 */
	public Scene p2Turn(Stage primaryStage) {
		window = primaryStage;
		playGame = new PlayScreen();
		
		setHandPlayer2(hand);
		setHandButtons(hand);
		StackPane player2Pane = new StackPane();
		ImageView player2Background = new ImageView("/GUIpackage/pictures/board.png");
		player2Background.setFitHeight(600);
		player2Background.setFitWidth(1000);
		
		Button EasyAI = new Button("EASY AI MOVE");
		EasyAI.setOnAction(e -> {			
			Button buttonPlayed = easyAI(hand);
			String cardPlayed = buttonPlayed.getText();
			boardOfStrings.add(cardPlayed);
			hand.remove(buttonPlayed);
			playGame.putOnBoard(playGame.getPlayerBoard(2), cardPlayed);
			player2Hbox.getChildren().remove(buttonPlayed);
			playGame.updateHand(getPlayer2Hand(), 2);
			playGame.setPlayerCount(count, 2);
				for(int allButtons = 0; allButtons <hand.size(); allButtons++)
					player2Hbox.getChildren().remove(hand.get(allButtons));
			window.setScene(playGame.playScene(window));
		});
		
		Button HardAI = new Button("HARD AI MOVE");
		HardAI.setOnAction(e -> {			
			Button buttonPlayed = hardAI(hand);
			String cardPlayed = buttonPlayed.getText();
			boardOfStrings.add(cardPlayed);
			hand.remove(buttonPlayed);
			playGame.putOnBoard(playGame.getPlayerBoard(2), cardPlayed);
			player2Hbox.getChildren().remove(buttonPlayed);
			playGame.updateHand(getPlayer2Hand(), 2);
			playGame.setPlayerCount(count, 2);
				for(int allButtons = 0; allButtons <hand.size(); allButtons++)
					player2Hbox.getChildren().remove(hand.get(allButtons));
			window.setScene(playGame.playScene(window));
		});
		
		if (PlayOptions.getPlayMode() == 2) {
			player2Hbox2.getChildren().add(EasyAI);
			player2Hbox2.setAlignment(Pos.CENTER);
			player2Hbox.setAlignment(Pos.TOP_CENTER);
			player2Pane.getChildren().addAll(player2Background,player2Hbox,player2Hbox2);
		}
		else if(PlayOptions.getPlayMode() == 3) {
			player2Hbox2.getChildren().add(HardAI);
			player2Hbox2.setAlignment(Pos.CENTER);
			player2Hbox.setAlignment(Pos.TOP_CENTER);
			player2Pane.getChildren().addAll(player2Background,player2Hbox,player2Hbox2);
		}
		else {
			player2Hbox.setAlignment(Pos.TOP_CENTER);
			player2Pane.getChildren().addAll(player2Background,player2Hbox);
		}
		Scene player2Scene = new Scene(player2Pane, 1000, 600);
		return player2Scene;
	}
}