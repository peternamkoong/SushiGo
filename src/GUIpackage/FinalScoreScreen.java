package GUIpackage;
import Start.Main;
import TEXTpackage.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * the FinalScoreScreen is a class that is used at the end of the game. 
 * the score is calculated and returned from the FinalScore class 
 */
public class FinalScoreScreen {

	Stage window, highScoreStage;
	Scene finalScoreScene;
	ImageView Background;
	private int player1Score, player2Score;
	private FinalScore scoreBoard;
	private Human human1, human2;
	private Player[] playerArray;
	private PlayScreen play;
	private HighScore highScore;
	private Main main;
	Button checkBoard1, checkBoard2;
	
	/**
	 * the Background method returns a specific background depending on which 
	 * player wins the game. If player 1 wins, player 2 wins, or there is a tie,
	 * there is a specific image for each of the instances.
	 * @return background	returns the specific background as an ImageView.
	 */
	public ImageView Background() {
		if (player1Score > player2Score)
			Background = new ImageView("/GUIpackage/pictures/FinalScoreScreen1.png");
		else if (player2Score > player1Score)
			Background = new ImageView("/GUIpackage/pictures/FinalScoreScreen2.png");
		else
			Background = new ImageView("/GUIpackage/pictures/FinalScoreScreenTie.png");
		Background.setFitHeight(600);
		Background.setFitWidth(1000);
		return Background;
	}
	
	/**
	 * the FinalScore method displays the final score of
	 * both players as Buttons and makes sure that the
	 * all the elements are in a StackPane, prior to adding
	 * it to the Scene.
	 * @param primaryStage  		a stage which appears as a window
	 * @return finalScoreScene 	returns the finalScoreScene which contains
	 * 							all the elements in it.
	 */
	public Scene FinalScore(Stage primaryStage) {
		window = primaryStage;
		highScoreStage = new Stage();
		play = new PlayScreen();
		human1 = play.getPlayer(1);
		human2 = play.getPlayer(2);
		playerArray = new Player[2];
		playerArray[0] = human1;
		playerArray[1] = human2;

		play.resetGameVariables();
		scoreBoard = new FinalScore(playerArray);
		scoreBoard.calcScore();
		player1Score = human1.getScore();
		player2Score = human2.getScore();
		highScore = new HighScore();
		main = new Main();
		
		StackPane finalScore = new StackPane();
		
		Button Explain = new Button("YOU CAN ONLY CLICK ON THE WINNER TO CONTINUE");
		Explain.setOnAction(e -> Explain.isDisabled());
		Button player1ScoreButton = new Button("PLAYER 1 SCORED : " + player1Score);
		player1ScoreButton.setOnAction(e -> {
			if(player1Score > player2Score && PlayOptions.getPlayMode() == 3) {
				window.close();
				main.start(window);
				highScore.start(highScoreStage);
			}
			else if (player1Score >= player2Score) {
				window.close();
				main.start(window);
			}
			else
				player1ScoreButton.isDisabled();
		});
		
		Button player2ScoreButton = new Button("PLAYER 2 SCORED : " + player2Score);
		player2ScoreButton.setOnAction(e -> {
			if (player1Score <= player2Score) {
				window.close();
				main.start(window);
			}
			else
				player2ScoreButton.isDisabled();
		});
		
		HBox finalScoreHBox = new HBox(100);
		VBox finalScoreVBox = new VBox(100);
		finalScoreVBox.setAlignment(Pos.BOTTOM_CENTER);
		finalScoreHBox.setAlignment(Pos.CENTER);
		finalScoreHBox.getChildren().addAll(player1ScoreButton, player2ScoreButton);
		finalScoreVBox.getChildren().addAll(Explain, finalScoreHBox);
		finalScore.getChildren().addAll(Background(),finalScoreVBox);
		Scene finalScoreScene = new Scene(finalScore, 1000,600);
		return finalScoreScene;
	}
}