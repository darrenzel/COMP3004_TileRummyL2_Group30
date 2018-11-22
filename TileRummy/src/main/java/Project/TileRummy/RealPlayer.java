package Project.TileRummy;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class RealPlayer extends Player implements Observer {
	public HashMap<Integer, ArrayList<Tile>> table;

	public RealPlayer(ArrayList<Tile> hand, String name, int index)
	{
		super(hand, name, index);
	}
	@Override
	public ArrayList<Tile> play(Table table){
		int moveChoice;
		int countHandSize = hand.size();
		
		Scanner sca = new Scanner(System.in);
		Collections.sort(hand, Tile.colorComparator);
		Collections.sort(hand, Tile.valueComparator);
		printPlayerInformation();
		System.out.println("This is the table.");
		System.out.println(table.table);
		System.out.println("---------------------------------------------------------");
		System.out.println("Your turn to move.");
		System.out.println("Do you want to move tile on your hand or table?(input '1' for hand, '2' for table, '3' for do nothing.)");
		moveChoice = sca.nextInt();
		if(moveChoice == 1)
		{
			System.out.println("Write down the index of the tile you want to move.(Press Enter after each)");
			int startIndex = sca.nextInt()-1;
			System.out.println("Write down the row and the index of the tile you want to put.(Press Enter after each)");
			int endRow = sca.nextInt()-1;
			int endIndex = sca.nextInt()-1;
			changeHandTile(table,startIndex,endRow,endIndex);
		}
		else if(moveChoice == 2)
		{
			System.out.println("Write down the row and the index of the tile you want to move.(Press Enter after each)");
			int startRow = sca.nextInt()-1;
			int startIndex = sca.nextInt()-1;
			System.out.println("Write down the row and the index of the tile you want to put.(Press Enter after each)");
			int endRow = sca.nextInt()-1;
			int endIndex = sca.nextInt()-1;
			changeTableTile(table,startRow, startIndex, endRow, endIndex);
		}
		else if(moveChoice == 3)
		{
			return null;
		}

		System.out.println("This is the table.");
		System.out.println("---------------------------------------------------------");
		System.out.println(table.table);
		if(!endTurn())
		{
			play(table);
		}
			
		ArrayList<Tile> check = new ArrayList<Tile>();
		Tile checkTile  = new Tile(0,"red");
		check.add(checkTile);
		return check;
		
		
	}
	
	public void changeTableTile(Table table,int startRow, int startIndex, int endRow, int endIndex)
	{
			ArrayList<Tile> tempMeld = table.table.get(startRow);
			Tile tempTile = tempMeld.get(startIndex);
			ArrayList<Tile> endMeld = table.table.get(endRow);
			endMeld.add(endIndex, tempTile);
			table.table.put(endRow, endMeld);
			table.table.get(startRow).remove(startIndex);
	}
	
	public void changeHandTile(Table table, int startIndex, int endRow, int endIndex)
	{
		
			Tile tempTile = this.hand.get(startIndex);
			ArrayList<Tile> endMeld = table.table.get(endRow);
			endMeld.add(endIndex, tempTile);
			table.table.put(endRow, endMeld);
			this.hand.remove(startIndex);
	}
	
	public boolean endTurn() {
		Scanner sca = new Scanner(System.in);
		System.out.println("Do you want to end your turn?(y/n");
		String res = sca.next();
		if(res.equals("y"))
		{
			return true;
		}
		
		return false;
	}

	@Override
	ArrayList<Tile> play() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Observable o, Object arg) {
		this.table=(HashMap<Integer, ArrayList<Tile>>) arg;
		this.table.toString();
	}
	
		
}
  


