package TEXTpackage;
import java.util.*;

/**
*Represents the GameConfiguration class that is used to set up the game Sushi-Go
*This class uses methods from the Deck class to create a deck and hands for the players.
*This class creates turns and boards that are specific for each player
*This class uses objects in the Player class to create players
*Players can view the cards in their hand, can select a card to keep and place on their board,
*update the hand to remove the chosen card, and updates the board to reflect the player's choice
*The hands are then switched between players at the end of the turn and the board is displayed
*/

public class GameConfiguration {
	private Player[] players; 
	private LinkedList<String>[] hands;
	private Deck deck;
	private int numPlayers;
	private FinalScore scoreBoard;
	
	/**
	*The GameConfiguration method creates the deck, the boards, an array of the player objects,
	* the player objects depending on the game type and the hands
	*Takes in no parameters and does not return anything
	*/
	
	public GameConfiguration(int mode, int numOfPlyrs) {
		numPlayers = numOfPlyrs;
		players = new Player[numPlayers];
		deck = new Deck();
		hands = deck.setHand(numPlayers);
		scoreBoard = new FinalScore(players);
		if(mode == 1) {
			for(int count = 0; count < numPlayers; count++) {
				players[count] = new Human(count);
			}
		}
		else if(mode == 2) {
			players[0] = new Human();
			for(int count = 1; count < numPlayers; count++) {
				players[count] = new EasyComputer(count - 1);
			}
		}
		
		else if(mode == 3) {
			players[0] = new Human();
			for(int count = 1; count < numPlayers; count++) {
				players[count] = new HardComputer(count - 1, hands);
			}
		}
	}
	
	/**
	*The getHand method returns a LinkedList of the hand depended on which hand number is specified
	*@param handNum    the int value of the required hand
	*@return the respective hand based on the parameter
	*/
	
	public LinkedList<String> getHand(int handNum) {
		return hands[handNum];
	}
	
	/**
	*The displayHand method displays the hand to the player
	*@param player 	is the player object, which determines
	*		the player's name
	*@param hand	is the hand that is currently assigned to 
	*		the player
	*/
	
	public void displayHand(Player player, int handNum) {
			System.out.println(player.toString() + ":" );
			for(int count = 0; count < hands[handNum].size(); count++) {
				System.out.println((count + 1) + ")" + "      " + hands[handNum].get(count));
			}
	}
	
	/**
	*The updateHands method is used to update the player's hand
	*after they've chosen which card to place on their board
	*This method removes the card they've chosen from their hand
	*@param playerNum 	which player in the Array
	*@param handNum	   which hand to update
	*/
	
	public void updateHand(int playerNum, int handNum) {
		hands[handNum].remove(players[playerNum].getCardPlayed());
	}	
	
	/*
	 * @return players     Array of player objects
	 */
	public Player[] getPlayers() {
		return players;
	}
	
	/**
	*The displayBoard method is used to display the board with the cards
	*that have been added to it by the respective player
	*@param player 	is to distinguish which player is being selected so 
	*		that their board is displayed
	*No value is returned, rather the board is displayed showing that 
	*player's cards
	*/
	
	public void displayBoard(Player player) {
		Hashtable<String, Integer> board = new Hashtable<String, Integer>();
		System.out.println(player.toString() + "'s board:");
		board = player.getBoard();
		for (String val : ((Hashtable<String,Integer>) board).keySet()) {
		    System.out.println(val + ":" + board.get(val));
		}
	}
	
	/**
	 * play method iterates for how ever many cards are in each hand for each player (2-4)
	 * after the player chooses a move, hands and boards are updated and displayed. 
	 * after each round, the hands alternate by one. 
	 * 
	 * @param numPlayers   the number of players in the game to determine how many 
	 * 			times to alternate hands and which players get which hands
	 * @param game       the gameConfiguration object which contains all of the methods 
	 * 					to play the game
	 * 
	 * uses while loop to iterate through players turns while the gameEnd variable is false
	 * checks length of hand each iteration, when the length in every hand is 0, breaks from loop
	 * 
	 * then calls scoreBoard.calcScore(); to calculate the score 
	 */
	public void play() {
		int handNum;
		int turn = 0;
		boolean gameEnd = false;
		while(gameEnd == false) {
			turn++;
			for(int count = 0; count < numPlayers; count++) { //count is the player for which the methods are being called
				handNum = turn % numPlayers; //turn % numPlayers is the value of the hand used. Each iteration increases turn by one, thus increasing handNum by 1
				players[count].setPossibleMoves(hands[(count + handNum) % numPlayers]); //increases the value used by getHand() based on the player
				this.displayHand(players[count], (count + handNum) % numPlayers);
				players[count].move(turn);
				this.updateHand(count, (count + handNum) % numPlayers);
			}
			for(int hand = 0; hand < numPlayers; hand++) {
				if(this.getHand(hand).isEmpty())
					gameEnd = true;
				else {
					gameEnd = false;
				}
			}
		}
		System.out.println("*********************************************************");
		for(int x = 0; x < numPlayers; x++) {
			this.displayBoard(players[x]);
			System.out.println("*********************************************************");
		}	
		scoreBoard.calcScore();
		for(int x = 0; x < numPlayers; x++) {
			System.out.println("*********************************************************");
			System.out.println(players[x].toString() + "'s score: " + players[x].getScore());
		}
	
	}
}