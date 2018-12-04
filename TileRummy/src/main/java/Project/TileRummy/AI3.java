package Project.TileRummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class AI3 extends Player{
	
	public AI3(ArrayList<Tile> hand, String name, int index) {
		super(hand, name, index);
		// TODO Auto-generated constructor stub
	}
	
	Player player;
	
	
	/*This AI player p3 plays its initial 30 (or more) points as soon as it can.
	- If it can play all its tiles (possibly using what’s on the table), it does.
	- Else, each turn
		If no other player has 3 fewer tiles than p3, then p3 plays only the tiles of its hand that require using tiles on the table to make melds (as in Strategy 2).
		Else p3 plays all the tiles it can.
	*/
	

	//function to make meld only the card in hand
	public ArrayList<Meld> makeMeldsOnlyInHand(ArrayList<Tile> hands, Table table) {
		ArrayList<Meld> melds = table.getMelds();
		ArrayList<Meld> tempMelds = melds;
		//tempHand = hands;     
		
		int endIndex = hands.size() - 1;
		int beginIndex = 0;
		boolean hasSetWithFour = false;
		
		Collections.sort(hands, Tile.valueComparator);
		
		// find all runs in hand
		for(int i = 0; i < hands.size(); i ++ ) {
			for (int j = hands.size() - 1; j - i > 1; j--) {
				Collections.sort(hands, Tile.colorComparator);
				beginIndex = i;
				endIndex = j;
				Meld tempRun = new Meld();
				for(int n = endIndex; n >= beginIndex; n--) {
					tempRun.add(hands.get(n));
				}
				if(tempRun.isRun()){
					//tempMelds.add(tempRun);
					for(Tile t: tempRun.getTiles()) {
						hands.remove(t);
					}
					//System.out.println("yes" + tempHand.toString());
					if(tempRun.sum() >= 30) {
						tempMelds.add(tempRun);
					}
				}
			}
		}
		

		for (int i = 0; i < hands.size() - 4; i++) {
			Meld tempSet = new Meld();
			for (int m = i; m < i + 4; m++) {
				tempSet.add(hands.get(m));
			}
			if(tempSet.isSet()) {
				hasSetWithFour = true;
				//tempMelds.add(tempSet);
				for(Tile t: tempSet.getTiles()) {
					hands.remove(t);
				}
				tempMelds.add(tempSet);
			}
		}
		
		if(!hasSetWithFour) {
			for(int i = 0; i < hands.size() - 3; i++) {
				Meld tempSet = new Meld();
				for (int m = i; m < i + 3; m++) {
					//Meld tempSet = new Meld();
					tempSet.add(hands.get(m));
				}
				if(tempSet.isSet()) {
					//tempMelds.add(tempSet);
					for(Tile t: tempSet.getTiles()) {
						hands.remove(t);
					}
					tempMelds.add(tempSet);
				}
				
			}
		}
		return tempMelds;
	}
	
	public String MeldsInHandToString(ArrayList<Tile> hands, Table table) {
		ArrayList<Meld> melds = table.getMelds();
		String s = "";
		ArrayList<Meld> meldList = makeMeldsOnlyInHand(hands, table);
		if(!meldList.isEmpty()) {
			for (Meld m : melds) {
				if(m.sum() >= 30) {
					s += m.meldToString() + " Sum: " + m.sum() + " Success" + '\n' ;
				}else {
					s += m.meldToString() + " Sum: " + m.sum() + " Fail" + '\n' ;
				}
				
			}
		}else s = "Impossible";
		
		//System.out.println(hand.toString());
			
		return s;
	}
	
	/*public boolean addMeldsInHandToTable(ArrayList<Tile> hands, Table table) {
		//ArrayList<Meld> melds = table.getMelds();
		ArrayList<Meld> meldList = makeMeldsOnlyInHand(hands, table);
		
		if(!meldList.isEmpty()) {
			for (Meld m : meldList) {
				System.out.println("ya" + m.meldToString());
				if(m.sum() >= 30) {
					table.addMeld(m);
				}else {
					System.out.println(m.meldToString() + "Fail to Table, the sum is less than 30");
				}
				
			}
			return true;
		}
		return false;
	}*/
	
	public boolean canMakeMeldsOnlyInHand(ArrayList<Tile> hands, Table table) {
		ArrayList<Meld> meldList = makeMeldsOnlyInHand(hands, table);
		
		if(!meldList.isEmpty()) {
			return true;
		}
		return false;
	}
	
	//the functions that play only tiles of hand and tiles on the table(do not play hands only)
	public boolean makeMeldBetweenHandAndTable(ArrayList<Tile> hands, Table table){
		ArrayList<Meld> tempMelds = table.getMelds();
		
		Iterator<Tile> iterator = hands.iterator();
		while(iterator.hasNext()) {
			Tile tempTile = iterator.next();
			for(Meld m : tempMelds) {
				ArrayList<String> colors = new ArrayList<String>();
				m.sortByValue();
				//add to the front of a run
				if(m.isRun()){
					if(tempTile.color == m.getTiles().get(0).color && tempTile.value == m.getTiles().get(0).value - 1) {
						iterator.remove();
						m.addFront(tempTile);
						return true;
					}
					//add to the back of a run
					if(tempTile.color == m.getTiles().get(0).color && tempTile.value == m.getTiles().get(m.getSize() - 1).value + 1) {
						iterator.remove();
						m.addBack(tempTile);
						return true;
					}
				}
				//add to a set
				if(m.isSet()) {
					m.sortByColor();
					for(Tile tiles: m.getTiles()) {
						colors.add(tiles.color);
					}
					if((!colors.contains(tempTile.color)) && tempTile.value == m.getTiles().get(0).value) {
						iterator.remove();
						m.add(tempTile);
						return true;
					}
				}	
				
				//separate the meld to two sets and take two cards to combine with one set with one card, and the set with several cards is valid also
				
			}
			
		}
		
		/*String s = "";
		System.out.println("After adding " + hands.toString());
		for(Meld m : tempTable) {
			s += m.meldToString();
		}
		System.out.println("----------table----------");
		System.out.println(s);
		*/
		return false;
	}
	
	/*public Table addTileInHandToTable(ArrayList<Tile> hands, ArrayList<Meld> melds, Table table) {
		ArrayList<Meld> meldList = makeMeldBetweenHandAndTable(hands, melds);
		
		if(!meldList.isEmpty()) {
			for (Meld m : melds) {
				table.addMeld(m);
			}
		}
		return table;
	}*/
	
		
	
	
	public boolean hasALessHand(int[] handSize) {
		for(int i = 0; i < handSize.length; i++) {
			if(handSize[i] >= hand.size() - 3) {
				return true;
			}
		}
		return false;
		
	}
	
	
	public void play(int[] handSize, Table table){
		//if p3 can't win on its turn (play all its tiles)
		
		Table copyTable = new Table();
		copyTable = table;
		
		boolean canPlay = false;
		//ArrayList<Tile> melds = table.getMelds();
		
		//ArrayList<Meld> copyMelds = (ArrayList<Tile>)table.getMelds().clone();
		ArrayList<Tile> copyHand =(ArrayList<Tile>)hand.clone();
		//ArrayList<Meld> copyTable = (ArrayList<Meld>)melds.clone();
		
		//makeMeldsOnlyInHand(copyHand, copyTable);
		//makeMeldBetweenHandAndTable(copyHand, copyTable);
		
		/*System.out.println("copyhand" + copyHand.toString());
		System.out.println("copyTable" + copyTable.toString());
		*/
		
		if(copyHand.isEmpty()){
			canPlay = canMakeMeldsOnlyInHand(hand, table);
			canPlay = makeMeldBetweenHandAndTable(hand, table);
			System.out.println(hand.toString());
		}else {
			//if someone has 3 tiles more than p3
			if(!hasALessHand(handSize)) {
				//p3 can plays only the tiles of its hand that require using tiles on the table to make melds
				canPlay = makeMeldBetweenHandAndTable(hand, table);
			}else {
				canPlay = canMakeMeldsOnlyInHand(hand, table);
			}
		}
		if(canPlay == false) {
			player.drawTile(hand,table);
		}
	}

}
