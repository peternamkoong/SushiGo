package TEXTpackage;
import java.util.*;
/**
 * EasyComputer is a subclass of player
 * Defines all methods that an easy computer object uses
 */
public class EasyComputer extends Player{
	
	private Random randNum;
	public static final String PLAYER_NAME = "Computer ";
	
	/**
	 * constructor EasyComputer
	 * @param id    initializes playerID with specified value
	 */
	public EasyComputer(int id) {
		super(id + 1);
	}
	
	/**
	 *@return    returns string value of the PLAYER_NAME and ID
	 */
	public String toString() {
		return PLAYER_NAME + super.getID();
	}
	/**
	 * generated random number based on the length of the possible moves, 
	 * selectes card from hand based on random number
	 * @param int turn     does not affect the move in the EasyCimputer class
	 */
	public void move(int turn) {
		randNum = new Random();
		int cardNum = randNum.nextInt(super.getPossibleMoves().size());
		String card = super.getPossibleMoves().get(cardNum);
		super.setCardPlayed(card);
		super.updateBoard();
		System.out.println(this.toString() + " chooses: " + card);
		
	}
}