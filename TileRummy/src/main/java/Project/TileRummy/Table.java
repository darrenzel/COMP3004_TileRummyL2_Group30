package Project.TileRummy;

import java.util.ArrayList;


public class Table {
	private ArrayList<Player> players = new ArrayList<Player>();
	protected Deck deck;
	protected ArrayList<Meld> melds = new ArrayList<Meld>();
	
	
	public void clearTable() {
		melds.clear();
	}

	public void attach(Player player){
	      players.add(player);		
	   }
	public void nextPlayer(Player nextPlayer) {
	         nextPlayer.play();
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
}
	 */
