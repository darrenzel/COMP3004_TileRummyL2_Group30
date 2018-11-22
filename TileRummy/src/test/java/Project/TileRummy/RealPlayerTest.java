package Project.TileRummy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Project.TileRummy.RealPlayer;
import Project.TileRummy.Table;
import Project.TileRummy.Tile;

class RealPlayerTest {
	private ArrayList<Tile> startHand = new ArrayList();
	private ArrayList<Tile> startTable = new ArrayList();
	private RealPlayer rp = new RealPlayer(startHand, "Arthur", 0);
	private Tile tile1 = new Tile(2, "red");
	private Tile tile2 = new Tile(3, "red");
	private Tile tile3 = new Tile(4, "red");
	private Tile tile4 = new Tile(5, "red");
	private Tile tile5 = new Tile(6, "red");
	private Tile tile6 = new Tile(7, "red");
	private Tile tile7 = new Tile(7, "green");
	private Tile tile8 = new Tile(7, "black");
	private Tile tile9 = new Tile(7, "blue");
//	private Tile tile10 = new Tile("red", 2);
//  private String name = "Arthur";
	private ArrayList<Tile> t1 = new ArrayList();
	private ArrayList<Tile> t2 = new ArrayList();
//	private ArrayList<Tile> t3 = new ArrayList();
	private Table t = new Table();
	
	@Test
	public void testChangeHandTile() 
	{
		for(int i = 0; i <= 33; i++) 
		{
			ArrayList<Tile> st = new ArrayList<Tile>();
			t.table.put(i, st);
		}
		
		rp.hand.add(tile1);
		rp.hand.add(tile2);
		System.out.println("hand : " + rp.hand);
		System.out.println("table : " + t.table);
		rp.changeHandTile(t, 0, 1, 0);
		assertEquals(tile1, t.table.get(1).get(0));
		System.out.println("hand : " + rp.hand);
		System.out.println("table : " + t.table);
		System.out.println("-----------------------------------------------------test finished-----------------------------------------------------");
	}
	
	@Test
	public void testChangeTableTile()
	{
		for(int i = 0; i <= 33; i++) 
		{
			ArrayList<Tile> st = new ArrayList<Tile>();
			t.table.put(i, st);
		}
		t1.add(tile1);
		t1.add(tile2);
		t1.add(tile3);
		t1.add(tile4);
		t1.add(tile5);
		t1.add(tile6);
		t2.add(tile7);
		t2.add(tile8);
		t2.add(tile9);
		t.table.put(0,t1);
		t.table.put(1,t2);
		System.out.println("hand : " + rp.hand);
		System.out.println("table : " + t.table);
		rp.changeTableTile(t, 0, 5, 1, 0);
		assertEquals(tile6, t.table.get(1).get(0));
		System.out.println("hand : " + rp.hand);
		System.out.println("table : " + t.table);
		System.out.println("-----------------------------------------------------test finished-----------------------------------------------------");
	}

}
