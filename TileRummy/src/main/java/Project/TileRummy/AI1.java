package Project.TileRummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Observer;
import java.util.Observable;

public class AI1 extends Player implements Observer {
	ArrayList<Tile> nextplay =new ArrayList<>();
	ArrayList<Tile> meld = new ArrayList<>();
	public HashMap<Integer, ArrayList<Tile>> table;

	Queue<Integer> melds = new LinkedList<>();
	public AI1(ArrayList<Tile> hand, String name, int index) {
		super(hand, name, index);
	}
	
	public void update(HashMap<Integer, ArrayList<Tile>> table) {
		this.table=table;
	}
	public ArrayList<Tile> play() {
		
		
		ArrayList<Tile> temp = new ArrayList<Tile>();
		temp.addAll(hand);
		
		if(temp.size()>0) {
			int count =1;
			Tile prev = temp.get(0);
			Collections.sort(temp, Tile.colorComparator);
			
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
		for(int i=0; i<nextplay.size(); i++) {
			System.out.println("final output: "+nextplay.get(i).toString());
		}
		return nextplay;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.table=(HashMap<Integer, ArrayList<Tile>>) arg;
		this.table.toString();
	}




}
