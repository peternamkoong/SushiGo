package Start;
import TEXTpackage.*;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class FinalScoreTest {
	
	private FinalScore testScore;

	@Test
	public void two_player_puddingTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[2];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		playerArray[0] = p1;
		playerArray[1] = p2;
		board1.put("Pudding", 1);
		board2.put("Pudding", 0);
		p1.setBoard(board1);
		p2.setBoard(board2);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("Player 1 has more Pudding than player two, should have score of 6", 6, 6, 0.00001);
		assertEquals("Player 2 has less Pudding than player 1, should have score of -6", -6, p2.getScore(), 0.00001);
	}
	
	@Test
	public void two_player_wasabiNigiriTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[2];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		playerArray[0] = p1;
		playerArray[1] = p2;
		board1.put("Wasabi", 1);
		board1.put("SquidNigiri", 1);
		board2.put("Wasabi", 0);
		board2.put("EggNigiri", 5);
		p1.setBoard(board1);
		p2.setBoard(board2);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("One Wasabi with one Squid Nigiri", 9, p1.getScore(), 0.00001);
		assertEquals("Player 2 has less Pudding than player 1, should have score of -6", 5, p2.getScore(), 0.00001);
	}
	
	@Test
	public void two_player_makiRollTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[2];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		playerArray[0] = p1;
		playerArray[1] = p2;
		board1.put("MakiRoll", 3);
		p1.setBoard(board1);
		p2.setBoard(board2);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("3 MakiRolls", 5, p1.getScore(), 0.00001);
		assertEquals("0 MakiRolls", 0, p2.getScore(), 0.00001);
	}
	
	@Test
	public void two_player_SashimiTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[2];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		playerArray[0] = p1;
		playerArray[1] = p2;
		board1.put("Sashimi", 3);
		p1.setBoard(board1);
		p2.setBoard(board2);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("Player 1 has more Pudding than player two, should have score of 6", 10, p1.getScore(), 0.00001);
		assertEquals("Player 2 has less Pudding than player 1, should have score of -6", 0, p2.getScore(), 0.00001);
	}
	
	@Test
	public void two_player_DumplingTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[2];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		playerArray[0] = p1;
		playerArray[1] = p2;
		board1.put("Dumpling", 6);
		p1.setBoard(board1);
		p2.setBoard(board2);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("Player 1 has more Pudding than player two, should have score of 6", 15, p1.getScore(), 0.00001);
		assertEquals("Player 2 has less Pudding than player 1, should have score of -6", 0, p2.getScore(), 0.00001);
	}
	
	@Test
	public void three_player_puddingTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board3 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[3];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		Player p3 = new Human(2);
		playerArray[0] = p1;
		playerArray[1] = p2;
		playerArray[2] = p3;
		board1.put("Pudding", 4);
		board2.put("Pudding", 2);
		board3.put("Pudding", 0);
		p1.setBoard(board1);
		p2.setBoard(board2);
		p3.setBoard(board3);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("p1- 4 puddings, p2- 2 puddings, p3- 0 puddings", 6, p1.getScore(), 0.00001);
		assertEquals("p1- 4 puddings, p2- 2 puddings, p3- 0 puddings", 0, p2.getScore(), 0.00001);
		assertEquals("p1- 4 puddings, p2- 2 puddings, p3- 0 puddings", -6, p3.getScore(), 0.00001);
		
		
	}
	
	@Test
	public void three_player_wasabiNigiriTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board3 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[3];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		Player p3 = new Human(2);
		playerArray[0] = p1;
		playerArray[1] = p2;
		playerArray[2] = p3;
		board1.put("Wasabi", 2);
		board1.put("SalmonNigiri", 3);
		board2.put("Wasabi", 0);
		board2.put("EggNigiri", 5);
		p1.setBoard(board1);
		p2.setBoard(board2);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("2 wasabi, 3 salmon Nigiri", 14, p1.getScore(), 0.00001);
		assertEquals("no wasabi, 5 EggNigiri", 5, p2.getScore(), 0.00001);
		assertEquals("no wasabi in board", 0, p3.getScore(), 0.00001);
	}
	
	@Test
	public void three_player_makiRollTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board3 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[3];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		Player p3 = new Human(2);
		playerArray[0] = p1;
		playerArray[1] = p2;
		playerArray[2] = p3;
		board1.put("MakiRoll", 6);
		board2.put("MakiRoll", 2);
		p1.setBoard(board1);
		p2.setBoard(board2);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("Most MakiRolls", 5, p1.getScore(), 0.00001);
		assertEquals("less makirolls", 0, p2.getScore(), 0.00001);
		assertEquals("no makirolls in board", 0, p3.getScore(), 0.00001);
		
	}
	
	@Test
	public void three_player_SashimiTest() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board3 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[3];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		Player p3 = new Human(2);
		playerArray[0] = p1;
		playerArray[1] = p2;
		playerArray[2] = p3;
		board1.put("Sashimi", 5);
		board2.put("Sashimi", 2);
		p1.setBoard(board1);
		p2.setBoard(board2);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("5 Sashimi", 10, p1.getScore(), 0.00001);
		assertEquals("2 Sashimi", 0, p2.getScore(), 0.00001);
		assertEquals("no sashimi on board", 0, p3.getScore(), 0.00001);
	}
	
	@Test
	public void assorted_cards_Test() {
		Hashtable<String, Integer> board1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board2 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> board3 = new Hashtable<String, Integer>();
		Player[] playerArray = new Player[3];
		Player p1 = new Human(0);
		Player p2 = new Human(1);
		Player p3 = new Human(2);
		playerArray[0] = p1;
		playerArray[1] = p2;
		playerArray[2] = p3;
		board1.put("Sashimi", 5);
		board1.put("Dumpling", 3);
		board1.put("Tempura", 2);
		board2.put("Pudding", 2);
		board2.put("MakiRoll", 3);
		board2.put("Wasabi", 3);
		board2.put("EggNigiri", 2);
		board3.put("Dumpling", 1);
		board3.put("MakiRoll", 4);
		board3.put("Pudding", 1);
		board3.put("SquidNigiri", 4);
		p1.setBoard(board1);
		p2.setBoard(board2);
		p3.setBoard(board3);
		testScore = new FinalScore(playerArray);
		testScore.calcScore();
		assertEquals("5 Sashimi, 3 dumpling, 2 tempura, least pudding", 15, p1.getScore(), 0.00001);
		assertEquals("Most Pudding, not most Maki, 3 wasabi, 2 EggNigiri", 12, p2.getScore(), 0.00001);
		assertEquals("1 dumpling, most maki, middle pudding, 4 squidNigiri", 18, p3.getScore(), 0.00001);
		
	}
}
