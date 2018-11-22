package Project.TileRummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TableTest extends TestCase {
	ArrayList<Tile> tileSet1, tileSet2;
	
	
	Tile tile1 = new Tile(1, "green");
	Tile tile2 = new Tile(2, "green");
	Tile tile3 = new Tile(3, "green");
	
	Tile tile4 = new Tile(4, "green");
	Tile tile5 = new Tile(4, "orange");
	Tile tile6 = new Tile(4, "blue");
	Tile tile7 = new Tile(4, "red");

		
	//test for clearing all elements in a table
	public void testClearTable() throws Exception{
		Table newTable = new Table();
		ArrayList<Tile> tileSet1 = new ArrayList<Tile>();
		tileSet1.add(tile1);
		tileSet1.add(tile2);
		tileSet1.add(tile3);
		
		newTable.table.put(1, tileSet1);
		newTable.clearTable();
		assertTrue(newTable.table.isEmpty());
	}
	
	//test for sending data to player
	/*public void testNotifyPlayer() {
		
	}*/
	
	//test for printing the table
	public void testToString() {
		ArrayList<Tile> tileSet2 = new ArrayList<Tile>();
		tileSet2.add(tile4);
		tileSet2.add(tile5);
		tileSet2.add(tile6);
		tileSet2.add(tile7);
		
		Table newTable2 = new Table();
		newTable2.table.put(2, tileSet2);
		String testCase = "Row 2: green 4 orange 4 blue 4 red 4 ";
		assertEquals(testCase, newTable2.tableToString());
	}
	
	
}

