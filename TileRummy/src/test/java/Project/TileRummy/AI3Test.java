package Project.TileRummy;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AI3Test extends TestCase {
	public void testMakeMeldsOnlyInHand() {
		/*Tile tile1 = new Tile(1, "blue");
		Tile tile2 = new Tile(1, "red");
		Tile tile3 = new Tile(2, "blue");
		Tile tile4 = new Tile(5, "red"); 
		Tile tile5 = new Tile(3, "blue");
		Tile tile6 = new Tile(6, "orange");
		Tile tile7 = new Tile(4, "blue");
		Tile tile8 = new Tile(5, "blue");
		Tile tile9 = new Tile(5, "orange");
		Tile tile10 = new Tile(5, "green");
		Tile tile11 = new Tile(1, "blue");
		
		ArrayList<Tile> hands = new ArrayList<Tile>();
		hands.add(tile1);
		hands.add(tile2);
		hands.add(tile3);
		hands.add(tile4);
		hands.add(tile5);
		hands.add(tile6);
		hands.add(tile7);
		hands.add(tile8);
		hands.add(tile9);
		hands.add(tile10);
		hands.add(tile11);
		*/
		
		Table newTable = new Table();
		ArrayList<Meld> melds = new ArrayList<Meld>();
		Meld meld = new Meld();
		
		Tile tile1 = new Tile(1, "blue");
		Tile tile2 = new Tile(1, "green");
		Tile tile3 = new Tile(10, "green");
		Tile tile4 = new Tile(9, "red"); 
		Tile tile5 = new Tile(11, "green");
		Tile tile0 = new Tile(12, "green");
		
		Tile tile6 = new Tile(2, "blue");
		Tile tile7 = new Tile(2, "green");
		Tile tile8 = new Tile(2, "orange");
		
		ArrayList<Tile> hands = new ArrayList<Tile>();
		hands.add(tile1);
		hands.add(tile2);
		hands.add(tile3);
		hands.add(tile4);
		hands.add(tile5);
		hands.add(tile0);
		
		meld.add(tile6);
		meld.add(tile7);
		meld.add(tile8);
		
		
		newTable.addMeld(meld);
		
		AI3 player3 = new AI3(hands, "Andraw", 3);
		
		System.out.println(newTable.tableToString());
		
		System.out.println("Name: " + player3.name);
		System.out.println(player3.hand);
		System.out.println(player3.MeldsInHandToString(hands, newTable));
		//player3.addMeldsInHandToTable(hands, newTable);
		
		System.out.println(newTable.tableToString());
		System.out.println("After adding :" + player3.hand);
		
	}
	
	public void TestAddToRun() {
		ArrayList<Meld> melds = new ArrayList<Meld>();
		
		Tile tile1 = new Tile(1, "blue");
		Tile tile2 = new Tile(1, "green");
		Tile tile3 = new Tile(2, "blue");
		Tile tile4 = new Tile(9, "red"); 
		Tile tile5 = new Tile(3, "green");
		Tile tile0 = new Tile(5, "green");
		
		Tile tile6 = new Tile(2, "green");
		Tile tile7 = new Tile(3, "green");
		Tile tile8 = new Tile(4, "green");
		
		Tile tile9 = new Tile(6, "red");
		Tile tile10 = new Tile(7, "red");
		Tile tile11 = new Tile(8, "red");
		
		ArrayList<Tile> hands = new ArrayList<Tile>();
		hands.add(tile1);
		hands.add(tile2);
		hands.add(tile3);
		hands.add(tile4);
		hands.add(tile5);
		hands.add(tile0);
		
		Meld meld1 = new Meld();
		Meld meld2 = new Meld();
		
		meld1.add(tile6);
		meld1.add(tile7);
		meld1.add(tile8);
		
		meld2.add(tile9);
		meld2.add(tile10);
		meld2.add(tile11);
		
		//Meld tempMeld1 = new Meld();
		//Meld tempMeld2 = new Meld();
		
		//tempMeld1 = meld1;
		//tempMeld2 = meld2;
		
		Table newTable = new Table();
		
		melds.add(meld1);
		melds.add(meld2);
		
		newTable.addMeld(meld1);
		newTable.addMeld(meld2);
		
		System.out.println(newTable.tableToString());
		
		AI3 player3 = new AI3(hands, "Sue", 3);
		
		System.out.println("Name: " + player3.name);
		System.out.println(player3.hand.toString());
		
		player3.makeMeldBetweenHandAndTable(hands, newTable);
		//player3.addTileInHandToTable(hands, melds, newTable);
		
		//System.out.println("AfterAdding: " + player3.hand);
		System.out.println(newTable.tableToString());
		
		
	}
	public void TestAddToSet() {
		
		//ArrayList<Meld> melds = new ArrayList<Meld>();
		
		//Tile tile1 = new Tile(1, "blue");
		Tile tile2 = new Tile(1, "green");
		Tile tile3 = new Tile(2, "blue");
		Tile tile4 = new Tile(9, "red"); 
		Tile tile5 = new Tile(3, "green");
		Tile tile0 = new Tile(5, "green");
		
		Tile tile6 = new Tile(2, "green");
		Tile tile7 = new Tile(2, "orange");
		Tile tile8 = new Tile(2, "red");
		
		Tile tile9 = new Tile(9, "green");
		Tile tile10 = new Tile(9, "blue");
		Tile tile11 = new Tile(9, "orange");
		
		
		ArrayList<Tile> hands = new ArrayList<Tile>();
		//hands.add(tile1);
		hands.add(tile2);
		hands.add(tile3);
		hands.add(tile4);
		hands.add(tile5);
		hands.add(tile0);
		
		Meld meld1 = new Meld();
		Meld meld2 = new Meld();
		
		meld1.add(tile6);
		meld1.add(tile7);
		meld1.add(tile8);
		
		meld2.add(tile9);
		meld2.add(tile10);
		meld2.add(tile11);
		
		
		Table newTable = new Table();
		
		//melds.add(meld1);
		//melds.add(meld2);
		
		newTable.addMeld(meld1);
		newTable.addMeld(meld2);
		
		System.out.println(newTable.tableToString());
		
		AI3 player3 = new AI3(hands, "Ann", 3);
		
		System.out.println("Name: " + player3.name);
		System.out.println(player3.hand);
		
		player3.makeMeldBetweenHandAndTable(hands, newTable);
		
		System.out.println("AfterAdding: " + player3.hand);
		System.out.println(newTable.tableToString());
		

		
		
		
	}
	
	public void testPlay() {
		
		Tile tile1 = new Tile(1, "blue");
		Tile tile2 = new Tile(1, "green");
		Tile tile3 = new Tile(10, "green");
		Tile tile4 = new Tile(9, "red"); 
		Tile tile5 = new Tile(11, "green");
		Tile tile0 = new Tile(12, "green");
		
		
		Tile tile6 = new Tile(2, "green");
		Tile tile7 = new Tile(3, "green");
		Tile tile8 = new Tile(4, "green");
		
		Tile tile9 = new Tile(6, "red");
		Tile tile10 = new Tile(7, "red");
		Tile tile11 = new Tile(8, "red");
		
		ArrayList<Tile> hands = new ArrayList<Tile>();
		hands.add(tile1);
		hands.add(tile2);
		hands.add(tile3);
		hands.add(tile4);
		hands.add(tile5);
		hands.add(tile0);
		
		
		Meld meld1 = new Meld();
		Meld meld2 = new Meld();
		
		meld1.add(tile6);
		meld1.add(tile7);
		meld1.add(tile8);
		
		meld2.add(tile9);
		meld2.add(tile10);
		meld2.add(tile11);
		
		Table table = new Table();
		table.addMeld(meld1);
		table.addMeld(meld2);
				
		
		System.out.println(table.tableToString());
		System.out.println("initial hand cards: " + hands.toString());
		System.out.println(hands.size());
		
		AI3 player3 = new AI3(hands, "Wei", 3);
		
		int[] handSize = {2,22};

		player3.play(handSize, table);
		
		System.out.println(table.tableToString());
		
		System.out.println("After adding to table: " + hands.toString());
	}
	

}
