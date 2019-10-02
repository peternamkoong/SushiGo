package TEXTpackage;
import java.util.Hashtable;
import java.util.Scanner;
/**
 * Class human is a subclass of Player.
 * Defines all methods that a human player object uses
 */
public class Human extends Player {
	
	private int selection;
	private Scanner user_input;
	public static final String PLAYER_NAME = "Player ";
	
	/**
	 * constructor Human takes no parameters 
	 * initializes the variables
	 */
	public Human() {
		super();
	}
	
	public Human(int id) {
		super(id + 1);
	}
	
	public Human(Hashtable<String, Integer> playerBoard, int playerNumber) {
		super(playerBoard,playerNumber);
		
	}

	/**
	 * toString to return the player's name + id
	 * @return PLAYER_NAME + player ID  	returns string value to identify the player object
	 */
	public String toString() {
		return PLAYER_NAME + super.getID();
	}
	
	/**
	 * takes no parameters, and prompts user for input. 
	 * if selection is valid, it is removed from the hand and added to the player's board 
	 * via super.setCardPlayed() and super.updateBoard()
	 */
	public void move(int turn) {
		user_input = new Scanner(System.in);
		do {
            System.out.println(this.toString() + ", Enter the number of the card you choose:");
            while (!user_input.hasNextInt()) {
                String input = user_input.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            selection = user_input.nextInt();
        } while (selection > (super.getPossibleMoves().size()) || selection < 1);
		
		super.setCardPlayed((super.getPossibleMoves().get(selection - 1)));
		super.updateBoard();
	}
}