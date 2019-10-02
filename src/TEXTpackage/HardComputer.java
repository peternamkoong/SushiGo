package TEXTpackage;
import java.util.*;
/**
 * incomplete
 */
public class HardComputer extends Player {
	
	private Hashtable<String, Integer> allCards;
	private LinkedList<String>[] hands;
	private int numPlayers;
	private Random randNum;
	public static final String PLAYER_NAME = "Computer ";
	
	
	/**
	 * constructor HardComputer
	 * @param id    initializes playerID with specified value
	 */
	public HardComputer(int id, LinkedList<String>[] allHands ) {
		super(id + 1);
		this.hands = allHands;
		this.numPlayers = allHands.length;
	}

	/**
	 *toString to return the player's name + id
	 * @return PLAYER_NAME + player ID  	returns string value to identify the player object
	 */
	public String toString() {
		return PLAYER_NAME + super.getID();
	}
	
	/**
	 * uses switch and if statements to choose cards based on the cards in all of the hands, and its own hand
	 * uses basic strategy for choosin cards with highest pay off early on
	 * and chooses cards only with a high likely hood of guaranteeing points
	 * @param   the value of turn affects which switch statement will be used. Depending 
	 * how far in the game it is, different moves are selected 
	 */
	public void move(int turn) {
		updateHands();
		LinkedList<String> currentHand = super.getPossibleMoves();
		String card = "";
		randNum = new Random();
		int cardNum = 0;
		switch(turn) {
			case 0: {
				if(currentHand.contains("Pudding"))
					card = "Pudding";
				
				else if((allCards.getOrDefault("SquidNigiri", 0) / numPlayers >= 1) && currentHand.contains("Wasabi"))
					card = "Wasabi";
				
				else if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if((allCards.getOrDefault("Sashimi", 0) / numPlayers >= 3) && currentHand.contains("Sashimi"))
					card = "Sashimi";
				
				else if((allCards.getOrDefault("Tempura", 0) / numPlayers >= 2))
					card = "Tempura";
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
			}
			
			case 1:{
				if(currentHand.contains("Pudding"))
					card = "Pudding";
				
				else if((allCards.getOrDefault("SquidNigiri", 0) / numPlayers >= 1) && currentHand.contains("Wasabi"))
					card = "Wasabi";
				
				else if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if((allCards.getOrDefault("Sashimi", 0) / numPlayers >= 2) && currentHand.contains("Sashimi"))
					card = "Sashimi";
				
				else if((allCards.getOrDefault("Tempura", 0) / numPlayers >= 1))
					card = "Tempura";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) >= 1 && super.getBoard().getOrDefault("Tempura", 0) < 2)
					card = "Tempura";
				
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
					
						
			}
			
			case 2:{
				if(currentHand.contains("Pudding"))
					card = "Pudding";
				
				else if((allCards.getOrDefault("SquidNigiri", 0) / numPlayers >= 1) && currentHand.contains("Wasabi"))
					card = "Wasabi";
				
				else if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if((allCards.getOrDefault("Sashimi", 0) / numPlayers >= 1) && currentHand.contains("Sashimi"))
					card = "Sashimi";
				
				else if((allCards.getOrDefault("Tempura", 0) / numPlayers >= 1))
					card = "Tempura";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) >= 1 && super.getBoard().getOrDefault("Tempura", 0) < 2)
					card = "Tempura";
				
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
			}
			
			case 3:{
				if(currentHand.contains("Sashimi") && super.getBoard().getOrDefault("Sashimi", 0) >= 1)
					card = "Sashimi";
				
				else if((allCards.getOrDefault("SquidNigiri", 0) / numPlayers >= 1) && currentHand.contains("Wasabi"))
					card = "Wasabi";
				
				else if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if((allCards.getOrDefault("Sashimi", 0) / numPlayers >= 2) && currentHand.contains("Sashimi"))
					card = "Sashimi";
				
				else if((allCards.getOrDefault("Tempura", 0) / numPlayers >= 1))
					card = "Tempura";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) >= 1 && super.getBoard().getOrDefault("Tempura", 0) < 2)
					card = "Tempura";
				
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
				
				
			}
			
			case 4:{
				if(currentHand.contains("Sashimi") && super.getBoard().getOrDefault("Sashimi", 0) >= 1 && super.getBoard().getOrDefault("Sashimi", 0) < 3)
					card = "Sashimi";
				
				else if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if((allCards.getOrDefault("Sashimi", 0) / numPlayers >= 2) && currentHand.contains("Sashimi"))
					card = "Sashimi";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) >= 1 && super.getBoard().getOrDefault("Tempura", 0) < 2)
					card = "Tempura";
				
				else if((allCards.getOrDefault("Tempura", 0) / numPlayers >= 1))
					card = "Tempura";
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
			}
			
			case 5:{
				if(currentHand.contains("Sashimi") && super.getBoard().getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				
				if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
			}
			
			case 6:{
				if(currentHand.contains("Sashimi") && super.getBoard().getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				
				if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
			}
			
			case 7:{
				if(currentHand.contains("Sashimi") && super.getBoard().getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				
				if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
			}
			
			case 8:{
				if(currentHand.contains("Sashimi") && super.getBoard().getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				
				if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
			}
			
			case 9:{
				if(currentHand.contains("Sashimi") && super.getBoard().getOrDefault("Sashimi", 0) == 2)
					card = "Sashimi";
				
				if(currentHand.contains("SquidNigiri"))
					card = "SquidNigiri";
				
				else if(currentHand.contains("Tempura") && super.getBoard().getOrDefault("Tempura", 0) ==1)
					card = "Tempura";
				
				else if(currentHand.contains("SalmonNigiri"))
					card = "SalmonNigiri";
				
				else if(currentHand.contains("Dumpling"))
					card = "Dumpling";
				
				else {
					cardNum = randNum.nextInt(currentHand.size());
					card = currentHand.get(cardNum);
				}
				break;
			}
			
			default:{
				cardNum = randNum.nextInt(currentHand.size());
				card = currentHand.get(cardNum);
			}
		}
		super.setCardPlayed(card);
		super.updateBoard();
		System.out.println(this.toString() + " chooses: " + card);
			
	}
	
	/**
	 * update hands takes no parameters and returns nothing
	 * used to update the hashtable contains all of the hands being used
	 * so that the computer can continuously choose the best options
	 */
	private void updateHands() {
		this.allCards = new Hashtable<String, Integer>();
		for(int handNum = 0; handNum < hands.length; handNum++) {
			for(int card = 0; card < hands[handNum].size(); card++) {
				
				if(allCards.containsKey(hands[handNum].get(card))) {
					allCards.replace(hands[handNum].get(card), 
							(allCards.get(hands[handNum].get(card)) + 1));
				}
				else {
					allCards.put(hands[handNum].get(card), 1);
				}
			}
		}
	}
}