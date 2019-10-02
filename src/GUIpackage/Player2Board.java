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
 * the Player2Board is a class that saves all the cards
 * that are selected in the Player2Turn, onto a separate
 * board that can be accessed.
 */
public class Player2Board{
	Stage window;
	ArrayList<String> board;
	private Player2Turn p2Turn;

	/**
	 * the P2Board method places the images of the cards from the boardOfStrings
	 * onto the screen, along with the background. They are added accordingly to
	 * the StackPane and placed in the boardScene Scene.
	 * @param primaryStage	 a stage which appears as a window
	 */
	public void P2Board(Stage primaryStage) {
		p2Turn = new Player2Turn();
		window = primaryStage;
		
		Button back = new Button("Back");
		back.setOnAction(e -> window.close());
		
		StackPane player2BoardStackPane = new StackPane();
		ImageView player2BoardBackground = new ImageView("/GUIpackage/pictures/board.png");
		player2BoardBackground.setFitHeight(600);
		player2BoardBackground.setFitWidth(1000);
		HBox boardBox = new HBox(5);
		boardBox.setAlignment(Pos.CENTER);
		board = p2Turn.getBoardOfStrings();
		if(board.size() > 0) {
			for(int card = 0; card <board.size(); card++) {
				ImageView boardCard = new ImageView("/GUIpackage/pictures/" + board.get(card) +".png");
				boardCard.setFitHeight(100);
				boardCard.setFitWidth(67);
				boardBox.getChildren().add(boardCard);
			}
		}
		boardBox.getChildren().add(back);
		player2BoardStackPane.getChildren().addAll(player2BoardBackground, boardBox);
		Scene boardScene = new Scene (player2BoardStackPane, 1000,600);
		window.setTitle("PLAYER 2 Board");
		window.setScene(boardScene);
		window.show();	
	}
}