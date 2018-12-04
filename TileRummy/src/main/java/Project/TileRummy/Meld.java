package Project.TileRummy;

import java.util.ArrayList;
import java.util.Collections;

public class Meld {
	protected ArrayList<Tile> meld;

	public Meld(ArrayList<Tile> meld) {
		this.meld = meld;
	}
	
	public void sortOnMeld(){
				Collections.sort(meld, Tile.valueComparator);
	}
	
	public void printMeld() {
		System.out.print("[ ");
		for(Tile tile:meld) {
			System.out.print(tile+" ");
		}
		System.out.print("]");
	}
}
