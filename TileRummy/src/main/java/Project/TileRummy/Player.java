package Project.TileRummy;

import java.util.*;

public abstract class Player {
	protected Table table;
	protected String name;
	protected int index;
	protected ArrayList<Tile> hand;
	
	public Player(ArrayList<Tile> hand, String name, int index)
	{
		this.hand = hand;
		this.name = name;
		this.index = index;
	}
	
	//update()
	public abstract void play();
	
}
	
	/*
	 * Iteration 1 code
	Boolean winCheck(ArrayList<Integer> hand)
	{
		if(hand == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	Boolean endTurn(ArrayList<Integer> hand)
	{
		Scanner scanner = new Scanner(System.in);
		String decision; 
		System.out.print("Do you want to end your turn?(y/n");
		decision = scanner.next();
		if(decision == "y" || decision == "Y")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		return this.hand + " " + this.name + " " + this.index;
	}
	public void printPlayerInformation() {
		System.out.println("---------------------------------------------------------");
		System.out.println("Name: "+name);
		System.out.println("Index: "+index);
		System.out.println("Number of Tiles: "+hand.size());
		System.out.println(hand);

		System.out.println("---------------------------------------------------------");
	}

	


}
	*/