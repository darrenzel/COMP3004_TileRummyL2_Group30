package Project.TileRummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


public class Table extends Observable {
	
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
	    
	
	
	public ArrayList<Meld> getMelds(){
		return melds;
	}
	
	public ArrayList<Meld> addMeld(Meld meld){
		melds.add(meld);
		return melds;
	}
	
	
	
	
	public String tableToString() {
		System.out.println("-------Table--------");
		String s = "";
		for(Meld m: melds) {
			s += m.meldToString();
		}
		return s;
	}

	
	public void nextPlayer(Player nextPlayer) {
	         nextPlayer.play();
	}
}
