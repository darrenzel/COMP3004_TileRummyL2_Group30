package Project.TileRummy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class TileTest {

	@Test
	void testtoSting() {
		//test toString method
		Tile tile = new Tile(3,"green");
		String tileString = "green 3";
	assertEquals(tileString, tile.toString());
	
	
	
	}
	@Test
	void testColorComparator() {
		//test color comparator
		Tile tile = new Tile(3,"green");
		Tile tile2 = new Tile(5,"blue");
		ArrayList<Tile> hand = new ArrayList<Tile>();
		ArrayList<Tile> expected = new ArrayList<Tile>();
		
		expected.add(tile2);
		expected.add(tile);
		
		hand.add(tile);
		hand.add(tile2);
		Collections.sort(hand, Tile.colorComparator);
		
		assertEquals(expected, hand);
	}
	@Test
	void testValueComparator() {
		//test color comparator
		Tile tile = new Tile(3,"green");
		Tile tile2 = new Tile(5,"blue");
		ArrayList<Tile> hand = new ArrayList<Tile>();
		ArrayList<Tile> expected = new ArrayList<Tile>();
		
		expected.add(tile);
		expected.add(tile2);
		
		hand.add(tile2);
		hand.add(tile);
		Collections.sort(hand, Tile.valueComparator);
		
		assertEquals(expected, hand);
	}
}
