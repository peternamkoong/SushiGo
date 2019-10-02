package GUIpackage;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Font;

/**
 * The ConfirmBox class is a class that is called if there needs to
 * be a confirmation pop up, before the user continues with an action.
 */
public class ConfirmBox {
	static Boolean answer, choice;
	
	/**
	 * The closeProgram method is the method that is called when a user
	 * presses the "quit" button on some scenes, or if they try to exit
	 * the window manually.
	 * @param window		takes the window stage and closes that specific
	 * 					window if the answer is true.
	 */
	public static void closeProgram(Stage window) {
		answer = ConfirmBox.display();
		if (answer)
			window.close();
	}
	
	/**
	 * The choiceCard method is the method that is called when a user
	 * want's to confirm their card selection. If the user clicks no,
	 * the choiceCard window will close and the user has the choice of
	 * selecting a different card. If the user clicks yes, the choiceCard
	 * window will close and the card will be selected. 
	 * @return choice	choice is a boolean, that returns true if the
	 * 					user chooses the "Yes" button, or returns false
	 * 					if the user chooses the "No" button.
	 */
	public static boolean choiceCard() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirmation");
		window.setMinWidth(300);
		
		Label label = new Label("Are you sure you want to choose this card?");
		label.setFont(new Font("Arial",15));
		label.setTextFill(Color.BLACK);
		
		Button yes = new Button("Yes");
		yes.setOnAction(e -> {
		choice = true;
		window.close();
		});
		Button no = new Button("No");
		no.setOnAction(e -> {
		choice = false;
		window.close();
		});
		StackPane displayPane = new StackPane();
		ImageView displayBackground = new ImageView("/GUIpackage/pictures/ConfirmationScreen.png");
		displayBackground.setFitWidth(328);
		displayBackground.setFitHeight(294);
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label,yes,no);
		displayPane.getChildren().addAll(displayBackground, layout);
		Scene scene = new Scene(displayPane, 328, 294);
		window.setScene(scene);
		window.showAndWait();
		return choice;
	}
	
	/**
	 * The display method is the method that is called when a user
	 * want's to quit the screen. If the user clicks no, the display 
	 * window will close and nothing will happen. If the user clicks 
	 * yes, the display window will close and the main window will close as well. 
	 * @return answer	answer is a boolean, that returns true if the
	 * 					user chooses the "Yes" button, or returns false
	 * 					if the user chooses the "No" button.
	 */
	public static boolean display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirmation");
		window.setMinWidth(300);
		
		Label label = new Label("Are you sure you want to quit?");
		label.setFont(new Font("Arial",20));
		label.setTextFill(Color.BLACK);
		
		Button yes = new Button("Yes");
		yes.setOnAction(e -> {
		answer = true;
		window.close();
		});
		Button no = new Button("No");
		no.setOnAction(e -> {
		answer = false;
		window.close();
		});
		StackPane displayPane = new StackPane();
		ImageView displayBackground = new ImageView("/GUIpackage/pictures/QuitScreen.png");
		displayBackground.setFitWidth(400);
		displayBackground.setFitHeight(300);
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label,yes,no);
		displayPane.getChildren().addAll(displayBackground, layout);
		Scene scene = new Scene(displayPane, 400, 300);
		window.setScene(scene);
		window.showAndWait();
		return answer;
	}

}