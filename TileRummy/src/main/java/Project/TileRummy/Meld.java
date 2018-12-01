package Project.TileRummy;

import java.util.ArrayList;
import java.util.Collections;

public class Meld {
	protected ArrayList<Tile> meld;

	public void sortOnMeld(){
				Collections.sort(meld, Tile.valueComparator);
	}
}
