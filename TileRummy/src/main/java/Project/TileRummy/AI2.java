package Project.TileRummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Observer;
import java.util.Observable;
public class AI2 extends Player implements Observer{
	ArrayList<Tile> nextplay =new ArrayList<>();
	ArrayList<Tile> meld = new ArrayList<>();
	
	Queue<Integer> melds = new LinkedList<>();
	Queue<Integer> rowkey = new LinkedList<>();
	public HashMap<Integer, ArrayList<Tile>> table;


	Queue<Integer> index = new LinkedList<>();

	public AI2(ArrayList<Tile> hand, String name, int index) {
		super(hand, name, index);
	}
	public ArrayList<Tile> play(){
		ArrayList<Tile> output = new  ArrayList<>();
		if(playHand().size()+playTable(this.table).size()==hand.size()) {
			output.addAll(playHand());
			output.addAll(playTable(this.table));
			return output;
		}
		return output;
	}
	public ArrayList<Tile> playHand() {
		
		
		ArrayList<Tile> temp = new ArrayList<Tile>();
		temp.addAll(hand);
		
		if(temp.size()>0) {
			int count =1;
			Tile prev = temp.get(0);
			Collections.sort(hand, Tile.colorComparator);
			
			meld.add(0,temp.get(0));
//			System.out.println("meld added 0");

//			for(int i=0; i<meld.size(); i++) {
//				System.out.println(meld.get(i).toString());
//			}
			//find all melds on hand with same color
			for(int i=1; i<temp.size(); i++) {
				if(temp.get(i).sameColor(prev) && temp.get(i).value==prev.value+1){
					count++;
					meld.add(temp.get(i));
					prev=temp.get(i);
				}else if(count>=3 && (i==temp.size()-1 ||!temp.get(i+1).sameColor(prev))) {
					//a valid meld
					nextplay.addAll(meld);
					melds.add(count);
					meld.clear();
					meld.add(temp.get(i));
					count=1;
				}
				else {
					//start a new meld
					meld.clear();
					meld.add(temp.get(i));
					count =1;
					prev = temp.get(i);
				}
			}
		}
		temp.clear();
		temp.addAll(hand);
		temp.removeAll(nextplay);
//		for(int i=0; i<temp.size(); i++) {
//			System.out.println("temp before value eval: "+temp.get(i).toString());
//		}
		
		if(temp.size()>1) {
			int count2 =1;
			Tile prev2 = temp.get(0);
			Collections.sort(temp, Tile.valueComparator);
			
			prev2=temp.get(0);
			meld.clear();
			
			meld.add(0,temp.get(0));
			ArrayList<String> colors = new ArrayList<>();
			for(int i=1; i<temp.size(); i++) {
//				System.out.println("temp value eval : "+temp.get(i).toString());
				
				if(!colors.contains(temp.get(i).color) && temp.get(i).value==prev2.value){
					count2++;
					meld.add(temp.get(i));
					prev2=temp.get(i);
					colors.add(temp.get(i).color);
					
//					for(Tile s : meld) {
//						System.out.println("adding to meld : "+s+" size: "+meld.size());
//
//					}
				}
				 if(count2==3||count2==4){
					//a valid meld
					nextplay.addAll(meld);
//					System.out.println("adding to meld!!!!!!!!!!!!!! : ");
					melds.add(count2);
					meld.clear();
					meld.add(temp.get(i));
					count2=1;
					colors.clear();
				}
				 else if(temp.get(i).value!=prev2.value && count2<3) {
//					System.out.println("clearing meld?????? ");

					meld.clear();
					meld.add(temp.get(i));
					count2 =1;
					prev2 = temp.get(i);
					colors.clear();
					colors.add(prev2.color);
				}
				
				
			}
		}
//		nextplay.addAll(meld);
//		for(int i=0; i<nextplay.size(); i++) {
//			System.out.println("final output: "+nextplay.get(i).toString());
//		}
		return nextplay;
	}
	
	public ArrayList<Tile> playTable(HashMap<Integer, ArrayList<Tile>> table){
		ArrayList<Tile> temp = new ArrayList<>();
		System.out.println("0");

		temp.addAll(hand);
		temp.removeAll(playHand());
		System.out.println("1");
		ArrayList<Tile> playable = new ArrayList<>();
		ArrayList<String> colors = new ArrayList<>();
		ArrayList<Tile> refrash = new ArrayList<>();
		for(Tile curr:temp) {
			for(int key : table.keySet()) {
				
					for(Tile t:table.get(key)) {
						colors.add(t.color);
					}
					System.out.println("4");

					if(curr.value==table.get(key).get(0).value-1 && curr.color.equals(table.get(key).get(0).color)) {
						rowkey.add(key);
						index.add(0);
						playable.add(curr);
//						System.out.println("value");
						return playable;

					}else if(curr.value==table.get(key).get(table.get(key).size()-1).value && curr.color.equals(table.get(key).get(table.get(key).size()-1).color)) {
						rowkey.add(key);
						index.add(table.get(key).size()-1);
						playable.add(curr);
						return playable;

					}
					if(table.get(key).size()==3 &&!colors.contains(curr.color) ) {
							rowkey.add(key);
							index.add(0);
							playable.add(curr);
//							colors.add(curr.color);
							refrash.add(curr);
							refrash.addAll(table.get(key));
							Collections.sort(refrash, Tile.colorComparator);
							table.put(key, refrash);
//							System.out.println("color");

					
					}
				colors.clear();
			}
		}
		
		return playable;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.table=(HashMap<Integer, ArrayList<Tile>>) arg1;
		this.table.toString();		
	}
	
}
