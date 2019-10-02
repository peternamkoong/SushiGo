package TEXTpackage;
import java.util.*;

/**
*Represents the FinalScore class that is used to produce the final score once the game is over
*
*The FinalScore takes the cards that are on the boards of the players and adds up the points
*based on the cards on the board. The boards are compared to produce the result for the Pudding
*and Maki cards that add points based on who has the most of the respective cards
*
*Each card has a specific method to calculate their points based on the special rules attributed to
*the card.
*
*Once the scores are calculated, the player number and score are displayed
*/

public class FinalScore {
	private Hashtable<String, Integer>[] boards;
	Player[] players;
	private int score;

	/**
	*The FinalScore constructor takes the players boards and creates an array of hashtables
	*calls calcScore method for each player
	*@param game	This is the game object that is created from the GameConfiguration class
	*		This parameter is used to refer to the players and their boards and to be able to 
	*		compare the current player's board against their opponent to calculate
	*		special card scores that rely on comparing boards
	*/
	

	@SuppressWarnings("unchecked")
	public FinalScore(Player[] playerArray) {
		players = playerArray;
		boards = new Hashtable[players.length];
	}
	
	/*
	 * calcScore method calls all the scoring methods based on the specified player
	 * outputs the players score
	 * @param player    the player object for which the score will be calculated
	 */
	public void calcScore() {
		for (int count = 0; count < players.length; count ++) {
			boards[count] = players[count].getBoard();
		}
		for (int playerNum = 0; playerNum < players.length; playerNum ++) {
			Player player = players[playerNum];
			score = 0;
			dumplingScore(boards[playerNum]);
			sashimiScore(boards[playerNum]);
			tempuraScore(boards[playerNum]);
			wasabiNigiriScore(boards[playerNum]);
			nigiriScore(boards[playerNum]);
			puddingScore(boards[playerNum], playerNum);
			makiRollScore(boards[playerNum], playerNum);
			player.setScore(score);
		}
	}
	
	/**
	*The method dumplingScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*calls method player.updateScore(score) to update the player object's score based on the number of points
	*@param player    the player object for which the score is calculated
	*/
	
	private void dumplingScore(Hashtable<String, Integer> playerBoard) {
		switch(playerBoard.getOrDefault("Dumpling", 0)) {
		case 0:
			score += 0;
			break;
		case 1:
			score += 1;
			break;
		case 2:
			score += 3;
			break;
		case 3:
			score += 6;
			break;
		case 4:
			score += 10;
			break;
		default:
			score += 15;
			break;
		}
	}
	
	/**
	*The method puddingScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*compares the player's board to all of the boards in the Array boards. 
	*calls method player.updateScore(score) to update the player object's score based on the number of points
	*@param player    the player object for which the score is calculated
	*/
	
	private void puddingScore(Hashtable<String, Integer> playerBoard, int playerNum) {
		boolean mostPudding = true;
		boolean leastPudding = true;
		for(int num = 0; num < boards.length; num++) {
			if(playerNum != num) {
				if(playerBoard.getOrDefault("Pudding", 0) > boards[num].getOrDefault("Pudding", 0))
					mostPudding = true;
				else {
					mostPudding = false;
					break;
				}
			}
		}
		for(int num = 0; num < boards.length; num++) {
			if(playerNum != num) {
				if(playerBoard.getOrDefault("Pudding", 0) < boards[num].getOrDefault("Pudding", 0))
					leastPudding = true;
				else {
					leastPudding = false;
					break;
				}
			}
		}
		if(mostPudding == true && leastPudding == false)
			score += 6;
		
		else if(mostPudding == false && leastPudding == true)
			score += -6;
		else
			score += 0;
		
	}
	
	/**
	*The method makiRollScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*compares the player's board to all of the boards in the Array boards with the exception of its own. 
	*updates value of score accordingly
	*@param playerBoard   the player's board for which the score is calculated
	*@param playerNum   int value of the player used to ensure it doesnt compare its own board. 
	*/
	
	private void makiRollScore(Hashtable<String, Integer> playerBoard, int playerNum) {
		boolean mostMaki = true;
		for(int num = 0; num < boards.length; num++) {
			if(playerNum != num) {
				if(playerBoard.getOrDefault("MakiRoll", 0) > boards[num].getOrDefault("MakiRoll", 0))
					mostMaki = true;
				else {
					mostMaki = false;
					break;
				}
			}
		}
		if(mostMaki == true)
			score += 5;
		else
			score += 0;
	}
	
	/**
	*The method sashimiScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*
	*@param playerBoard   the player's board for which the score is calculated
	*/
	
	private void sashimiScore(Hashtable<String, Integer> playerBoard) {
		score += (playerBoard.getOrDefault("Sashimi", 0) / 3 * 10);
	}
	
	/**
	*The method tempuraScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*
	*@param playerBoard   the player's board for which the score is calculated
	*/
	
	private void tempuraScore(Hashtable<String, Integer> playerBoard) {
		score += (playerBoard.getOrDefault("Tempura", 0) / 2) * 5;
	}
	
	/**
	*The method nigiriScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*
	*@param playerBoard   the player's board for which the score is calculated
	*/
	
	private void nigiriScore(Hashtable<String, Integer> playerBoard) {
		score += (playerBoard.getOrDefault("SquidNigiri", 0) * 3);
		score += (playerBoard.getOrDefault("SalmonNigiri", 0) * 2);
		score += (playerBoard.getOrDefault("EggNigiri", 0) * 1);
	}
	
	/**
	*The method wasabiNigiriScore sets the specific conditions for dumpling card combinations  
	*that are necessary for the specific card on the board to accrue points
	*
	*@param playerBoard   the player's board for which the score is calculated
	*/
	
	private void wasabiNigiriScore(Hashtable<String, Integer> playerBoard) {
		while(playerBoard.getOrDefault("Wasabi", 0) > 0) {
			if(playerBoard.getOrDefault("SquidNigiri", 0) > 0) {
				score += 9;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("SquidNigiri", (playerBoard.get("SquidNigiri") - 1));
			}
			else if (playerBoard.getOrDefault("SalmonNigiri", 0) > 0) {
				score += 6;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("SalmonNigiri", (playerBoard.get("SalmonNigiri") - 1));
			}
			else if(playerBoard.getOrDefault("EggNigiri", 0) > 0) {
				score += 3;
				playerBoard.replace("Wasabi", (playerBoard.get("Wasabi") - 1));
				playerBoard.replace("EggNigiri", (playerBoard.get("EggNigiri") - 1));
			}
			else
				playerBoard.replace("Wasabi", 0);
		}
	}
}
