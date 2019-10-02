	package GUIpackage;
	import javafx.scene.image.ImageView;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.scene.control.ScrollPane;
	 
	/**
	 * the Rules class shows the rules of the game when the
	 * user clicks the "rules" button.
	 */
public class Rules {
	Stage window;
	
	/**
	 * the start method opens the image "rules.png" which has all the instructions
	 * of the game on it. If was manually created and was put on a ScrollPane
	 * so you can scroll down to read it.
	 * @param primaryStage	sets the primaryStage as the window, which is
	 * 						a separate stage.
	 */
	public void start(Stage primaryStage) {
		window = primaryStage;
		ImageView background = new ImageView("/GUIpackage/pictures/rules.png");
		background.setFitWidth(1000);
		background.setFitHeight(2995);
		ScrollPane ruleLayout = new ScrollPane();
		ruleLayout.setContent(background);
				
		Scene mainScene = new Scene(ruleLayout, 1000,600);
					
		window.setTitle("Sushi Go Rules");
		window.setScene(mainScene);
		window.show();
	}
	

}