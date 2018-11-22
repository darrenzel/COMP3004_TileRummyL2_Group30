package Project.TileRummy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AI3Test {
	//test 
	@Test
	public void testMakeMeldBetweenHandAndTable() {
		ArrayList<Tile> hand = new ArrayList<Tile>();
		Table table = new Table();
		ArrayList<Tile> meld = new ArrayList<Tile>();
		Tile tile1 = new Tile(1, "green");
		Tile tile2 = new Tile(5, "green");
		Tile tile3 = new Tile(4, "green");
		
		
		Tile tile4 = new Tile(2, "green");
		Tile tile5 = new Tile(3, "green");
		Tile tile6 = new Tile(4, "green");
		hand.add(tile1);
		hand.add(tile2);
		hand.add(tile3);
		
		meld.add(tile4);
		meld.add(tile5);
		meld.add(tile6);
		table.table.put(2, meld);
		System.out.println(table.tableToString());
		
		AI3 player3 = new AI3(hand,"Ann",2);
		//a test to add a tile into the front of meld
		assertTrue(player3.makeMeldBetweenHandAndTable(hand,table));
		System.out.println(table.tableToString());
		//a test to add a tile into the back of meld
		assertTrue(player3.makeMeldBetweenHandAndTable(hand,table));
		System.out.println(table.tableToString());
		assertTrue(!player3.makeMeldBetweenHandAndTable(hand,table));
		System.out.println(player3.name + "'s hand: " + hand.toString());
		
	}

}
