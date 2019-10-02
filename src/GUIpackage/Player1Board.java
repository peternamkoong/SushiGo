package GUIpackage;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * the Player1Board is a class that saves all the cards
 * that are selected in the Player1Turn, onto a separate
 * board that can be accessed.
 */
public class Player1Board {
	private Player1Turn p1Turn;
	
	Stage window;
	ArrayList<String> board;
	
	/**
	 * the P1Board method places the images of the cards from the boardOfStrings
	 * onto the screen, along with the background. They are added accordingly to
	 * the StackPane and placed in the boardScene Scene.
	 * @param primaryStage	 a stage which appears as a window
	 */
	public void P1Board(Stage primaryStage) {
		p1Turn = new Player1Turn();
		window = primaryStage;

		//Button
		Button back = new Button("Back");
		back.setOnAction(e -> window.close());
		//Display
		StackPane player1BoardStackPane = new StackPane();
		ImageView player1BoardBackground = new ImageView("/GUIpackage/pictures/board.png");
		player1BoardBackground.setFitHeight(600);
		player1BoardBackground.setFitWidth(1000);
		HBox boardBox = new HBox(5);
		boardBox.setAlignment(Pos.CENTER);
		////////////////////////////////
		//Lets make player 1's board
		board = p1Turn.getBoardOfStrings();
		if(board.size() > 0) {
			for(int card = 0; card <board.size(); card++) {
				ImageView boardCard = new ImageView("/GUIpackage/pictures/" + board.get(card) +".png");
				boardCard.setFitHeight(100);
				boardCard.setFitWidth(67);
				boardBox.getChildren().add(boardCard);
			}
		}
		boardBox.getChildren().add(back);
		player1BoardStackPane.getChildren().addAll(player1BoardBackground, boardBox);
		Scene boardScene = new Scene (player1BoardStackPane, 1000,600);
		window.setTitle("PLAYER 1 Board");
		window.setScene(boardScene);
		window.show();	
	}
}