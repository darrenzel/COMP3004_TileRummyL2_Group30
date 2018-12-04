package Project.TileRummy;

import java.util.ArrayList;


public class Table {
	private static final boolean True = false;
	private ArrayList<Player> players = new ArrayList<Player>();
	protected Deck deck;
	protected ArrayList<Meld> melds = new ArrayList<Meld>();
	
	
	public void clearTable() {
		melds.clear();
	}

	//attach
	public void attach(Player player){
	      players.add(player);		
	   }
	
	//notify
	public void askToPlay(Player nextPlayer) {
	         nextPlayer.play();
	}
	
	//print table
		public void printTable() {
		for(int i=0;i<melds.size();i++) {
			melds.get(i).printMeld();
		}
	}
	
		//setState
		public void initalTable() {
			Deck deck = new Deck();
			deck.shuffle();
			for(int i=0;i<4;i++) {
				for(Player player:players)
				{
					player.hand.add(player.table.deck.dealTile());
				}
			}	
		}
		
		public void startGame() {
			while(True) {
				
			}
		}
}
	
	/*
	 * Iteration 1 code
	public String tableToString() {
		String shortCut = "";
		for(Meld meld:melds)
		System.println(meld);
	}
		
	return table.toString();
	}
	 */

