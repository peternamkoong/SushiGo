package GUIpackage;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Player1Turn class is called when the Player 1 Turn button is clicked
 * in the PlayScreen class. The first player then gets to select a card
 * on playing field, which will then be added to the player's board.
 */
public class Player1Turn {
	Stage window;
	LinkedList<Button> hand;
	private HBox player1Hbox;
	private int count = 1;
	private PlayScreen playGame;
	static ArrayList<String> boardOfStrings = new ArrayList<String>();
	
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
	 * the setHandPlayer1 method sets the hand with the newHand parameter
	 * @param newHand	newHand is a LinkedList of type button.
	 */
	public void setHandPlayer1(LinkedList<Button> newHand) {
		hand = new LinkedList<Button>(newHand);
	}
	
	/**
	 * getPlayer1Hand is a getter method of the LinkedList hand that is
	 * set from the setHandPlayer1 method. 
	 * @return hand		returns the hand of type LinkedList<Button>
	 */
	public LinkedList<Button> getPlayer1Hand() {
		return hand;
	}
	
	/**
	 * setHandButtons method sets the buttons of the cards in your current
	 * hand so you can see which card to choose and can physically click it
	 * on the GUI. As well, each button has actions that are taken to store the name
	 * in the boardOfString, remove the card from the hand, add it to the board, update
	 * the hand, and set the player.
	 * @param currentHand	the currentHand is used to get the buttons from.
	 */
	public void setHandButtons(LinkedList<Button> currentHand) {
		player1Hbox = new HBox(5);
		playGame = new PlayScreen();
		for(int card = 0; card < currentHand.size(); card++) {
			player1Hbox.getChildren().add(hand.get(card));
			currentHand.get(card).setOnAction(e -> {
				boolean answer = ConfirmBox.choiceCard();
				if (answer) {
					String cardPlayed = ((Button)(e.getSource())).getText();
					Button buttonPlayed = ((Button)(e.getSource()));
					boardOfStrings.add(cardPlayed);
					hand.remove(buttonPlayed);
					playGame.putOnBoard(playGame.getPlayerBoard(1), cardPlayed);
					player1Hbox.getChildren().remove(buttonPlayed);
					playGame.updateHand(getPlayer1Hand(), 1);
					playGame.setPlayerCount(count, 1);
					for(int allButtons = 0; allButtons <hand.size(); allButtons++)
						player1Hbox.getChildren().remove(hand.get(allButtons));
					window.setScene(playGame.playScene(window));
				}
			});
		}	
	}
	
	/**
	 * the p1Turn method used the other methods and adds them to a StackPane,
	 * including the background and buttons.
	 * @param primaryStage		a stage which appears as a window
	 * @return player1Scene		returns the player1Scene which contains all
	 * 							the elements in the scene.
	 */
	public Scene p1Turn(Stage primaryStage) {
		window = primaryStage;
		setHandPlayer1(hand);
		setHandButtons(hand);
		StackPane player1Pane = new StackPane();
		ImageView player1Background = new ImageView("/GUIpackage/pictures/board.png");
		player1Background.setFitHeight(600);
		player1Background.setFitWidth(1000);
		player1Hbox.setAlignment(Pos.BOTTOM_CENTER);
		player1Pane.getChildren().addAll(player1Background,player1Hbox);
		Scene player1Scene = new Scene(player1Pane, 1000, 600);
		return player1Scene;

	}
}