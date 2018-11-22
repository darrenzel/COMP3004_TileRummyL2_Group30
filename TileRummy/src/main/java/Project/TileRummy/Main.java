package Project.TileRummy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main( String[] args)
    {
    	Deck deck = new Deck();
    	ArrayList<Tile> h1 = new ArrayList<Tile>();
    	ArrayList<Tile>	h2 = new ArrayList<Tile>();
    	ArrayList<Tile>	h3 = new ArrayList<Tile>();
    	ArrayList<Tile>	h4 = new ArrayList<Tile>();
    	deck.shuffle();
    	for(int i = 0; i <= 14; i++)
    	{
    		h1.add(deck.dealTile());
    		h2.add(deck.dealTile());
    		h3.add(deck.dealTile());
    		h4.add(deck.dealTile());
    	}
    	RealPlayer p1 = new RealPlayer(h1,"Arthur",1);
    	RealPlayer p2 = new RealPlayer(h2,"Bob",2);
    	RealPlayer p3 = new RealPlayer(h3,"Chris",3);
    	RealPlayer p4 = new RealPlayer(h4,"David",4);
    	Table table = new Table();
    	for(int i = 0; i <= 33; i++) 
		{
			ArrayList<Tile> st = new ArrayList<Tile>();
			table.table.put(i, st);
		}
    	while(true)
    	{
    		ArrayList<Tile> checkDraw1 = p1.play(table);
    		winCheck(p1);
    		if(checkDraw1==null)
    		{
    			p1.hand.add(deck.dealTile());
    		}
    		ArrayList<Tile> checkDraw2 = p2.play(table);
    		winCheck(p2);
    		if(checkDraw2==null)
    		{
    			p2.hand.add(deck.dealTile());
    		}
    		ArrayList<Tile> checkDraw3 = p3.play(table);
    		winCheck(p3);
    		if(checkDraw3==null)
    		{
    			p3.hand.add(deck.dealTile());
    		}
    		ArrayList<Tile> checkDraw4 = p4.play(table);
    		winCheck(p4);
    		if(checkDraw4==null)
    		{
    			p4.hand.add(deck.dealTile());
    		}
    		
    		
    	}
    }
    
    
    
    public static void winCheck(Player p)
	{
		if(p.hand == null)
		{
			System.out.println("You have won the game!");
			System.exit(0);
		}
	}

    
    public static Boolean endTurn()
	{
		Scanner sca = new Scanner(System.in);
		String decision; 
		System.out.print("Do you want to end your turn?(y/n)");
		decision = sca.next();
		if(decision == "y")
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}
