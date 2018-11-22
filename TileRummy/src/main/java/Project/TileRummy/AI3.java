package Project.TileRummy;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class AI3 extends Player{
	
	public AI3(ArrayList<Tile> hand, String name, int index) {
		super(hand, name, index);
		// TODO Auto-generated constructor stub
	}

	/*This AI player p3 plays its initial 30 (or more) points as soon as it can.
	- If it can play all its tiles (possibly using what’s on the table), it does.
	- Else, each turn
		If no other player has 3 fewer tiles than p3, then p3 plays only the tiles of its hand that require using tiles on the table to make melds (as in Strategy 2).
		Else p3 plays all the tiles it can.
	*/
	

	//function to make meld only the card in hand
	public ArrayList<Tile> makeMeldOnlyInHand() {
		//check the meld those have the same color
		for(int i = 0; i < hand.size(); i ++ ) {
			if(hand.get(i).sameColor(hand.get(i+1)) && hand.get(i) == hand.get(i+1)){
				
			}
		}
		return null;
		
	}
	
	//the functions that play only tiles of hand and tiles on the table(do not play hands only)
	public void makeMeldBetweenHandAndTable(ArrayList<Tile> hand,Table t){
		Set<Integer> keys = t.table.keySet();
		//tiles that not be melded with others
		/*ArrayList<Tile> tilesNotMeld = new ArrayList<Tile>();
		for(int i = 0; i < d.size(); i ++ ) {
			if(!d.contains(XXX)) {
				tilesNotMeld.add(d.hand.get(i));
			}
		}*/
		for(Map.Entry<Integer,ArrayList<Tile>> meld:t.table.entrySet()){
			ArrayList<Tile> temp = new ArrayList<Tile>();
			for(int i:keys) {
				ArrayList<Tile> tList = t.table.get(i);
	            for(Tile tile : tList) {
	            	temp.add(tile);
	            }
			}
			for(int k = 0; k < hand.size(); k++) {
				Tile currTile = hand.get(k);
				//check if the tile can be added to the front of a meld on table
				if(meld.getValue().get(0).value == currTile.value + 1 && currTile.color == meld.getValue().get(meld.getValue().size() - 1).color) {
					temp.add(0,currTile);
					t.table.put(meld.getKey(), temp);
					hand.remove(currTile);
				}
				//check if the tile can be added to the back of a meld on table
				if(meld.getValue().get(meld.getValue().size() - 1).value == currTile.value - 1 && currTile.color == meld.getValue().get(0).color) {
					temp.add(currTile);
					t.table.put(meld.getKey(), temp);
					hand.remove(currTile);
				}
				
				//check the tile can be added to the meld have the same value
				ArrayList<String> colors = new ArrayList<String>();
				if(temp.size() == 3) {
					for(int n = 0; n < temp.size(); n++) {
						colors.add(temp.get(n).color);
					}
					if(colors.contains(currTile.color)) {
						temp.add(currTile);
						t.table.put(meld.getKey(), temp);
					}
					
				}
				/*while(k!=hand.size()-1){
					makeMeldBetweenHandAndTable(hand,t);
				}*/
			}
			//check the tile can be added to the meld have the same value
			//temp.clear();
		}	
		
		
	}
	
	/*
	//check the tile can be added to the meld have the same value
	ArrayList<String> colors = new ArrayList<String>();
	if(temp.size() == 3) {
		for(int n = 0; n < temp.size(); n++) {
			colors.add(temp.get(n).color);
		}
		if(colors.contains(currTile.color)) {
			temp.add(currTile);
			t.table.put(meld.getKey(), temp);
		}
		
	}*/
	
	
	public void play(){
		//if p3 can't win on its turn (play all its tiles)
		
			//if someone has 3 tiles more than p3
			//p3 can plays only the tiles of its hand that require using tiles on the table to make melds
		//else strategy1
	}

}
