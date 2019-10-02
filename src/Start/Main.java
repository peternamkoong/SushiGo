package Start;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import GUIpackage.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is the main class that is used to start the GUI of our
 * SushiGo Game. The class extends Application and lets the
 * player decide to play the game, check the rules, or quit
 */

public class Main extends Application {
	Stage window, ruleStage, highScoreStage;
	private Rules rules;
	private PlayOptions options;
	private HighScore highScore;
	
	/**
	 * The closeProgram method opens a new stage and 
	 * prompts the user if the are sure if they want
	 * to quit.
	 * @param window 	window is a new stage, so it appears
	 * 					on top of the game window. 
	 */
	public void closeProgram(Stage window) {
		boolean answer = ConfirmBox.display();
		if (answer)
			window.close();
	}
	
	/**
	 * The main method ensures that the game starts from
	 * this main class, instead of starting from a different
	 * class. 
	 * @param args
	 */
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * The mainScene method is a scene that creates all the buttons,
	 * pane, images, and VBox, and stores it into the scene before it
	 * gets returned.
	 * @param primaryStage	a stage which appears as a window
	 * @return mainScene 	returns the mainScene with all the elements
	 * 						that goes in it.
	 */
	public Scene mainScene(Stage primaryStage) {
		window = primaryStage;
		window.setOnCloseRequest(e -> {
			e.consume();
			ConfirmBox.closeProgram(window);
		});
		
		rules = new Rules();
		ruleStage = new Stage();
		highScoreStage = new Stage();
		options = new PlayOptions();
		highScore = new HighScore();
		
		Button playButton = new Button("Let's Play");
		playButton.setOnAction(e -> window.setScene(options.optionsScene(window)));
		
		Button rulesButton = new Button("Rules");
		rulesButton.setOnAction(e -> rules.start(ruleStage));
		
		Button highScoreButton = new Button ("Recognition");
		highScoreButton.setOnAction(e -> {
			String fileName = "out.txt";
				try {
					Scanner inputStream = new Scanner(new File(fileName));
					inputStream.close();
					highScore.HighScoreScene(highScoreStage);
				}
				catch (FileNotFoundException ee) {
					highScoreButton.setDisable(true);
				}
			});
		
		Button exitButton = new Button("Quit");
		exitButton.setOnAction(e -> closeProgram(window));
		
		StackPane mainScreenPane = new StackPane();
		ImageView mainScreenBackground = new ImageView("/GUIpackage/pictures/mainscreen.png");
		mainScreenBackground.setFitHeight(600);
		mainScreenBackground.setFitWidth(1000);
		VBox mainScreenVBox = new VBox(20);
		mainScreenVBox.setAlignment(Pos.CENTER);
		mainScreenVBox.getChildren().addAll(playButton, rulesButton, highScoreButton, exitButton);
		mainScreenPane.getChildren().addAll(mainScreenBackground, mainScreenVBox);
		Scene mainScene = new Scene(mainScreenPane, 1000,600);
		return mainScene;
	}
	
	/**
	 * the start method essentially tells the GUI which
	 * stage to use and which scene to set the stage as
	 * 
	 * @param primaryStage a stage which appears as a window
	 */
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Sushi Go!");
		window.setScene(mainScene(window));
		window.show();		
	}
}