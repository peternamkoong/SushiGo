package GUIpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HighScore {
	Stage window, highScore;
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		highScore = new Stage();
		String fileName = "out.txt";
		VBox HighScoreVBox = new VBox(50);
		Label HighScoreText = new Label("Please Type in Your Name (No Longer Than 24 Characters)");
		TextField HighScoreField = new TextField();
		HighScoreField.setPromptText("Name");
		HighScoreField.setMaxWidth(200);
		Button Continue = new Button("Continue");
		Continue.setOnAction(e -> {
			try {
				if (HighScoreField.getText().length() > 24 || HighScoreField.getText().isEmpty()) {
					HighScoreField.clear();
				}
				else {
					PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName, true));
					String Text = HighScoreField.getText();
					outputStream.println(Text);
					outputStream.close();
				}
			}
			catch (FileNotFoundException ee) {
				System.out.println("Error opening the file " + fileName);
			}
		window.close();
		HighScoreScene(highScore);
		});
		StackPane HighScorePane = new StackPane();
		ImageView HighScoreBackground = new ImageView("/GUIpackage/pictures/Rulesdraw.png");
		HighScoreBackground.setFitWidth(1000);
		HighScoreBackground.setFitHeight(600);
		HighScoreVBox.setAlignment(Pos.CENTER);
		HighScoreVBox.getChildren().addAll(HighScoreText, HighScoreField, Continue);
		HighScorePane.getChildren().addAll(HighScoreBackground, HighScoreVBox);
		Scene HighScoreScene = new Scene(HighScorePane, 1000,600);
		window.setTitle("WINNER");
		window.setScene(HighScoreScene);
		window.show();
	}
	
	public void HighScoreScene (Stage primaryStage) {
		window = primaryStage;
		VBox showAndTell = new VBox(5);
		String fileName = "out.txt";
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		while(inputStream.hasNext()) {
			String line = inputStream.nextLine();
			Label name = new Label(line);
			name.setFont(new Font("Arial", 15));
			showAndTell.getChildren().add(name);
		}
		
		StackPane HighScorePane = new StackPane();
		ImageView HighScoreBackground = new ImageView("/GUIpackage/pictures/HighScore.png");
		HighScoreBackground.setFitWidth(1000);
		HighScoreBackground.setFitHeight(600);
		showAndTell.setAlignment(Pos.CENTER);
		HighScorePane.getChildren().addAll(HighScoreBackground, showAndTell);
		Scene HighScoreScene = new Scene(HighScorePane, 1000,600);
		
		window.setTitle("Recognition");
		window.setScene(HighScoreScene);
		window.show();
	}
}
