package GUIpackage;
import Start.*;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The PlayOptions class is called when the user decides to play
 * the game. It gives the option of playing a "Player vs Player",
 * "Player vs Easy Computer", or a "Player vs Hard Computer" mode.
 */
public class PlayOptions{
	Stage window;
	Button pvpButton, pveButton, pvhButton, backButton;
	private Main main;
	private PlayScreen playGame;
	private static int playMode;
	
	/**
	 * the getPlayMode method is a static method that returns
	 * the playMode value.
	 * @return playMode	playMode returns an integer depending on
	 * 					which game mode you select.
	 */
	public static int getPlayMode() {
		return playMode;
	}
	
	/**
	 * the Play Method is a method that sets the scene on the provided 
	 * window. It ensures that the buttons are all on the appropriate
	 * VBox and that that VBox and background image is in the StackPane.
	 * @param primaryStage		primaryStage is a stage parameter that uses
	 * 							the same window as the one that called it.
	 * @return playOptionsScene	Returns the scene that has all the elements
	 * 							required for it.
	 */
	public Scene optionsScene(Stage primaryStage) {
		main = new Main();
		playGame = new PlayScreen();
		window = primaryStage;
		
	//buttons for Selection
		pvpButton = new Button("Player vs Player");
		pvpButton.setOnAction(e -> {
			playGame.setGame(1, 2);
			playMode = 1;
			window.setScene(playGame.playScene(window));
		});
		
		pveButton = new Button("Player vs Easy Computer");
		pveButton.setDisable(false);
		pveButton.setOnAction(e -> {
			playGame.setGame(2, 2);
			playMode = 2;
			window.setScene(playGame.playScene(window));
		});
		
		pvhButton = new Button("Player vs Hard Computer");
		pvhButton.setDisable(false);
		pvhButton.setOnAction(e -> {
			playGame.setGame(3, 2);
			playMode = 3;
			window.setScene(playGame.playScene(window));
		});
		
		backButton = new Button("Back");
		backButton.setOnAction(e -> window.setScene(main.mainScene(window)));
		
		StackPane playOptionsPane = new StackPane();
		ImageView playOptionsBackground = new ImageView("/GUIpackage/pictures/Background.png");
		playOptionsBackground.setFitWidth(1000);
		playOptionsBackground.setFitHeight(600);
		VBox playOptionsScreenVBox = new VBox(20);
		playOptionsScreenVBox.setAlignment(Pos.CENTER);
		playOptionsScreenVBox.getChildren().addAll(pvpButton, pveButton, pvhButton,backButton);
		playOptionsPane.getChildren().addAll(playOptionsBackground, playOptionsScreenVBox);
		Scene playOptionsScene = new Scene(playOptionsPane, 1000,600);
		return playOptionsScene;
	}
}