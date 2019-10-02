package GUIpackage;
import TEXTpackage.*;
import javafx.scene.image.ImageView;
import java.util.Hashtable;
import java.util.LinkedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * The PlayScreen class is where most of the game is happening. It sets
 * all the required variables and objects. It makes sure to switch between
 * turns of player 1 and player 2 and also has the end-game condition.
 */
public class PlayScreen {
	Stage window, board1, board2, ruleStage;
	static Hashtable<String, Integer> player1Hash, player2Hash;
	static LinkedList<Button> hand1, hand2, tempHand1, tempHand2;
	Button checkBoard1, checkBoard2, finalScoreButton, p1, p2, doubleCheckRules; 
	static int numPlayer1Turn, numPlayer2Turn;
	private Player1Turn p1Turn;
	private Player2Turn p2Turn;
	private Rules rules;
	private FinalScoreScreen finalScore;
	private Player1Board p1Board;
	private Player2Board p2Board;
	private GameConfiguration game;
	
	/**
	 * resetGameVariables is a method that resets the game variables stored in
	 * this class, thus being able to start the game over again.
	 */
	public void resetGameVariables() {
		player1Hash = new Hashtable<String, Integer>();
		player2Hash = new Hashtable<String, Integer>();
		hand1 = new LinkedList<Button>();
		hand2 = new LinkedList<Button>();
		numPlayer1Turn = 0;
		numPlayer2Turn = 0;
	}
	
	/**
	 * getPlayerTurnCount method returns how many turns each player has had.
	 * @param player		player is an integer which refers to which player's
	 * 					value you would like to have returned.
	 * @return numPlayer1Turn or numPlayer2Turn which is then the case where the 
	 */
	public int getPlayerTurnCount(int player) {
		if (player == 1)
			return numPlayer1Turn;
		else
			return numPlayer2Turn;
	}

	/**
	 * setPlayerCount method increments the value of numPlayer1Turn or numPlayer2Turn
	 * by the value of count.
	 * @param count		count is an int that is added to the total of numPlayer1Turn
	 * @param player		player is an integer which refers to which player's
	 * 					value you would like to have returned.
	 */
	public void setPlayerCount(int count, int player) {
		if (player == 1)
			numPlayer1Turn += count;
		else
			numPlayer2Turn+=count;
	}
	
	/**
	 * getGame method is a getter method for the GameConfiguration
	 * @return game 		returns game which is an instance of GameConfiguration
	 */
	public GameConfiguration getGame() {
		return game;
	}
	
	/**
	 * setGame method is a setter method for the gameConfiguration
	 * @param gameMode		gameMode is an int that tells the GameConfiguration which
	 * 						mode to enter.
	 * @param players		player is an integer which refers to how many player's to
	 * 						create.
	 */
	public void setGame(int gameMode, int players) {
		this.game = new GameConfiguration(gameMode,players);
	}
	
	/**
	 * getBackground method gets the background image in the folder of our project
	 * @return Background	returns the background that is set as an ImageView.
	 */
	public ImageView getBackground() {
		ImageView Background = new ImageView("/GUIpackage/pictures/Background.png");
		Background.setFitWidth(1000);
		Background.setFitHeight(600);
		return Background;
	}
	/**
	 * getCard method gets the card image in the folder of our project from the chosen
	 * hand and card from the hand.
	 * @param hand			determines which hand to get the image from
	 * @param card			determines which card to get, from the hand that was chosen.
	 * @return cardImage		returns the cardImage that is set as an ImageView.
	 */
	public ImageView getCard(int hand, int card) {
		ImageView cardImage = new ImageView("/GUIpackage/pictures/" + game.getHand(hand).get(card) + ".png");
		cardImage.setFitHeight(100);;
		cardImage.setFitWidth(67);
		return cardImage;	
	} 
	
	/**
	 * getButton method gets the button that has the image from the getCard method 
	 * and the name from the hand.
	 * @param hand			determines which hand to get 
	 * @param card			determines which card to use in the hand
	 * @return cardButton	returns the cardButton that has the name and the image set
	 * 						as the display on the card.
	 */
	public Button getButton(int hand, int card) {
		Button cardButton = new Button (game.getHand(hand).get(card), getCard(hand,card));
		cardButton.setContentDisplay(ContentDisplay.TOP);
		return cardButton;
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
	 * setBoardPlayer is a method that sets the board for the specific player. it
	 * makes the board a Hashtable.
	 * @param player		player is an integer which refers to which player you
	 * 					are creating the Hashtable for.
	 */
	public void setBoardPlayer(int player) {
		if (player == 1)
			player1Hash = new Hashtable<String, Integer>();
		else
			player2Hash = new Hashtable<String, Integer>();
	}
	
	/**
	 * the getPlayerBoard method is a getter method for the player1Hash 
	 * or player2Hash object.
	 * @param player		player is an integer which refers to which player's
	 * 					value you would like to have returned.
	 * @return player1hash or player2hash	returns the specific Hashtable.			
	 */
 	public Hashtable<String, Integer> getPlayerBoard(int player) {
 		if (player == 1)
 			return player1Hash;
 		else
 			return player2Hash;
	}
	
 	/**
 	 * the setHand method is a setter method for setting the hand of the player. it
 	 * goes through each card in the hand, adds the button from the getButton method
 	 * to each index of the LinkedList.
 	 * @param player		player is an integer with refers to which player you are setting
 	 * 					the hand for.
 	 */
	public void setHand(int player) {
		if (player == 1) {
			hand1 = new LinkedList<Button>();
			for(int card = 0; card < game.getHand(0).size(); card++) {
				getCard(0,card);
				Button cardButton = getButton(0,card);
				hand1.add(cardButton);
			}
		}
		else {
			hand2 = new LinkedList<Button>();
			for(int card = 0; card < game.getHand(1).size(); card++) {
				getCard(1,card);
				Button cardButton = getButton(1,card);
				hand2.add(cardButton);
			}
		}
	}
	
	/**
	 * the getHand method is a getter method that returns 
	 * the hand of the selected player.
	 * @param player 	player is an integer which refers to which player's
	 * 					value you would like to have returned.
	 * @return hand1 or hand2	returns the LinkedList of the selected player.
	 */
	public LinkedList<Button> getHand(int player) {
		if (player == 1)
			return hand1;
		else
			return hand2;
	}
	
	/**
	 * the updateHand method changes the hand1 or hand2 value to that with the
	 * newHand linkedList.
	 * @param newHand	newHand is a LinkedList with a new set of buttons within it.
	 * @param player		player is an integer which refers to which player's
	 * 					hand would you like to update.
	 */
	public void updateHand(LinkedList<Button> newHand, int player) {
		if (player == 1)
			hand1 = new LinkedList<Button>(newHand);
		else
			hand2 = new LinkedList<Button>(newHand);
	}
	
	/**
	 * the switchHands method swaps the two hands of the players, after both players
	 * has a turn. Once both turns have been complete, it sets the other person's hand
	 * in the updateHand method above.
	 */
	public void switchHands() {
		int totalTurns = numPlayer1Turn + numPlayer2Turn;
		if(totalTurns % 2 ==0 && totalTurns > 0) {
			tempHand1 = hand1;
			tempHand2 = hand2;
			updateHand(tempHand2, 1);
			updateHand(tempHand1, 2);
		}
	}
	
	/**
	 * the createHumanPlayer method is used to create a specific Human object with
	 * the board of the selected player.
	 * @param player		player is an integer which refers to which player you want
	 * 					to create as a human.
	 * @return Human1 or Human2	returns the newly created instance of a Human.
	 */
	public Human createHumanPlayer(int player){
		if (player == 1) {
			Human Human1 = new Human(getPlayerBoard(1), 1);
			return Human1;
		}
		else {
			Human Human2 = new Human(getPlayerBoard(2), 2);
			return Human2;
		}
	}
	
	/**
	 * the getPlayer method is a getter method for the Human that is created
	 * from the createHumanPlayer method.
	 * @param player		player is an integer which refers to which player you want
	 * 					to be created.
	 * @return Human		returns the human that is returned from create HumanPlayer.
	 */
	public Human getPlayer(int player) {
		if (player == 1)
			return createHumanPlayer(1);
		else 
			return createHumanPlayer(2);
	}
	
	/**
	 * the gameButton method determines which button shows based off of the
	 * numPlayer1Turn and numPlayer2Turn.
	 * @return p1, p2, or finalScoreButton	If numPlayer1turn is greater than 
	 * numPlayer2Turn, the p2 button is returned, else the p1 button is returned.
	 * If the sum of numPlayer1Turn and numPlayer2Turn is equal to 20, the
	 * finalScoreButton is returned. 
	 */
	public Button gameButton() {
		if ((numPlayer1Turn + numPlayer2Turn) == 20)
			return finalScoreButton;
		else if(numPlayer1Turn > numPlayer2Turn)
			return p2;
		else
			return p1;
	}
	/**
	 * the play method is where the PlayScreen scene is set. it adds all the
	 * buttons and the VBox and HBox to the appropriate StackPane and sets the
	 * alignment for them as well. Then they are placed into a Scene.
	 * @param primaryStage	a stage which appears as a window.
	 * @return playScreenScene	returns the playScreenScene which contains
	 * 							all the elements in it.
	 */
	public Scene playScene(Stage primaryStage) {
		window = primaryStage;
		ruleStage = new Stage();
		board1 = new Stage();
		board2 = new Stage();
		p1Turn = new Player1Turn();
		p2Turn = new Player2Turn();
		rules = new Rules();
		finalScore = new FinalScoreScreen();
		p1Board = new Player1Board();
		p2Board = new Player2Board();
		
		if (numPlayer1Turn == 0 && numPlayer2Turn == 0) {
			setBoardPlayer(1);
			setBoardPlayer(2);
			setHand(1);
			setHand(2);
		}
		
		checkBoard1 = new Button("Player 1 Board");
		checkBoard1.setOnAction(e -> p1Board.P1Board(board1));
		
		checkBoard2 = new Button("Player 2 Board");
		checkBoard2.setOnAction(e -> p2Board.P2Board(board2));
		
		finalScoreButton = new Button("FINAL SCORE");
		finalScoreButton.setOnAction(e -> {
			createHumanPlayer(1);
			createHumanPlayer(2);
			window.setScene(finalScore.FinalScore(window));
		});
		
		p1 = new Button("Player 1 Turn!");
		p1.setOnAction(e -> {
			if(numPlayer1Turn > 0)
				switchHands();
			p1Turn.setHandPlayer1(hand1);
			window.setScene(p1Turn.p1Turn(window));
		});
		
		p2 = new Button("Player 2 Turn!");
		p2.setOnAction(e ->{
			if(numPlayer2Turn > 0)
				switchHands();
			p2Turn.setHandPlayer2(hand2);
			window.setScene(p2Turn.p2Turn(window));
		});
		
		doubleCheckRules = new Button("RULES");
		doubleCheckRules.setOnAction(e -> rules.start(ruleStage));

		StackPane playScreen = new StackPane();
		HBox playScreenHBox = new HBox(20);
		VBox playScreenVBox = new VBox(20);
		playScreenHBox.setAlignment(Pos.BOTTOM_CENTER);
		playScreenVBox.setAlignment(Pos.CENTER);
		playScreenHBox.getChildren().addAll(checkBoard1,doubleCheckRules, checkBoard2);
		playScreenVBox.getChildren().addAll(gameButton(), playScreenHBox);
		playScreen.getChildren().addAll(getBackground(),playScreenVBox);
		Scene playScreenScene = new Scene(playScreen, 1000, 600);
		return playScreenScene;
	}
}
	