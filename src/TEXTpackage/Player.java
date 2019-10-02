package TEXTpackage;
import java.util.*;

/**
*This is the abstract superclass used by all types of players
*contains empty methods that will be used by subclasses as well
* as defined methods that are the same for all subclasses
*/

public abstract class Player {
	//instance variables
	private LinkedList<String> possibleMoves;
	private String card;
	private int playerID;
	private Hashtable<String, Integer> board;
	private int score = 0;
	/**
	 * Player constructor
	 * takes no parameters, sets playerID to 1
	 * creates new hashtable
	 */
	public Player() {
		this.playerID = 1;
		board = new Hashtable<String, Integer>();
	}
	
	/**
	 * Player constructor 
	 * @param playerID  playedID is assigned to the value of the paramter
	 * creates new hashtable
	 */
	public Player(int playerID) {
		this.playerID = playerID;
		board = new Hashtable<String, Integer>();
	}
	
	//Constructor to take GUI info and create Players out of it
		
	public Player(Hashtable<String, Integer> playerBoard, int playerNumber) {
		this.playerID = playerNumber;
		this.board = playerBoard;
	}
	/**
	 * getPossibleMoves  takes no parameters
	 * @return possibleMoves    returns linkedList of all possible moves
	 */
	public LinkedList<String> getPossibleMoves() {
		return possibleMoves;
	}
	
	/**
	 * takes no parameters
	 * @return   playerID   returns int value of playerID
	 */
	public int getID() {
		return playerID;
	}
	
	/**
	 * void method
	 * @param hand   sets value to possible moves to the parameter hand
	 */
	public void setPossibleMoves(LinkedList<String> hand) {
		possibleMoves = hand;
	}
	/**
	 * abstract method, to be defined by subclass
	 * @param turn    takes an int parameter of turn
	 */
	public abstract void move(int turn) ;
	
	/**
	 * abstract method toString 
	 * to be defined by subclasses
	 */
	public abstract String toString() ;
	
	
	/**
	 * getBoard method is used to get the value of the player's board
	 * @return board     returns hashtable of the board
	 */
	public Hashtable<String,Integer> getBoard() {
		return board;
	}
	/**
	 * assigns new value to the variable score
	 * @param newScore   int value to be assigned to score
	 */
	public void setScore(int newScore) {
		score = newScore;
	}
	
	
	/**
	 * taked no parameters and returns nothing
	 * updates the board based on the value of the card variable
	 */
	public void updateBoard() {
		if(board.containsKey(card)) {
			board.replace(card, (board.get(card) + 1));
		}
		else {
			board.put(card, 1);
		}
	}
	
	/**
	 * getScore method is used to get the value of the player's score
	 * @return this.score    returns the int value of the player's score
	 */
	public int getScore() {
		return this.score;
	}
	
	
	/**
	 * used to set player's board to specific hashtable, used by test class and GUI 
	 * @param newBoard     hashtable to be assigned to the player's board variable
	 */
	public void setBoard(Hashtable<String, Integer> newBoard) {
		this.board = newBoard;
	}
	
	
	/**
	 * assigns value to the player's card variable
	 * @param card   string value to be assigned
	 */
	protected void setCardPlayed(String card) {
		this.card = card;
	}
	
	/**
	 * getCardPlayed method is used to get the string value of the card played
	 * @return  card  returns string value of card variable
	 */
	public String getCardPlayed() {
		return card;
	}
}