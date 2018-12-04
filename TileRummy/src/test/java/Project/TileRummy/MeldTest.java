package Project.TileRummy;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class MeldTest extends TestCase {
	@Test
	public void printMeldTest() {
		Tile tile1 = new Tile(3,"green");
		Tile tile2 = new Tile(5,"blue");
		ArrayList<Tile> testMeld = new ArrayList<Tile>();
		testMeld.add(tile1);
		testMeld.add(tile2);
		Meld meld =new Meld(testMeld);
		assertEquals("[ Green3 Blue5 ]",meld.printMeld());
	}
}
