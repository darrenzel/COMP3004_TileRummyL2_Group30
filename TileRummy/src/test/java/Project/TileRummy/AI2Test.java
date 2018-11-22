package Project.TileRummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class AI2Test {
	@Test
	void testPlayTable() {
		ArrayList<Tile> row1 = new ArrayList<>();
		ArrayList<Tile> row2 = new ArrayList<>();
		row1.add(new Tile(2,"blue"));
		row1.add(new Tile(3,"blue"));
		row1.add(new Tile(4,"blue"));

			
		
		HashMap<Integer, ArrayList<Tile>> table = new HashMap<>();
		table.put(0, row1);
		table.put(1,row2);
		
		ArrayList<Tile> hand = new ArrayList<>();
		hand.add(new Tile(1,"blue"));
		
		AI2 player = new AI2(hand,"test",2);

		ArrayList<Tile> out = new ArrayList<>();
		ArrayList<Tile> expected = new ArrayList<>();

		expected.add(new Tile(1,"blue"));
		out = player.playTable(table);
		System.out.println("1");
		System.out.println("expected: "+ expected.get(0).toString());
		System.out.println("getting : "+ out.get(0).toString());


		for(int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i).toString(), out.get(i).toString());
		}
	}
	@Test
	void testPlayHand() {
		ArrayList<Tile> hand = new ArrayList<>();
		hand.add(new Tile(2,"blue"));
		hand.add(new Tile(3,"blue"));
		hand.add(new Tile(4,"blue"));
		hand.add(new Tile(11,"blue"));
		hand.add(new Tile(13,"green"));
		hand.add(new Tile(3,"green"));
		hand.add(new Tile(4,"green"));
		hand.add(new Tile(12,"green"));
		hand.add(new Tile(13,"red"));
		hand.add(new Tile(1,"red"));
		hand.add(new Tile(7,"red"));
		hand.add(new Tile(13,"orange"));
		hand.add(new Tile(2,"orange"));
		hand.add(new Tile(5,"orange"));

		AI2 player = new AI2(hand,"test",2);
		
		
		ArrayList<Tile> expected = new ArrayList<>();
		ArrayList<Tile> expected1 = new ArrayList<>();

		expected.add(new Tile(2,"blue"));
		expected.add(new Tile(3,"blue"));
		expected.add(new Tile(4,"blue"));
		expected.add(new Tile(13,"green"));
		expected.add(new Tile(13,"orange"));
		expected.add(new Tile(13,"red"));

//		ArrayList<ArrayList<Tile>> expected2 = new ArrayList<>();
//		expected2.add(expected);
//		expected2.add(expected1);
		
		ArrayList<Tile> out = player.playHand();
		for(int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i).toString(),out.get(i).toString());
		}
		
		ArrayList<Tile> output = new ArrayList<>();
		int index=0;
		int curr =0;
		while(player.melds.peek()!=null) {
			curr += player.melds.poll();
			for(int i=index; i<curr; i++) {
				System.out.print(out.get(i).toString()+ " ");
			}
			index += curr;
			System.out.println("");
		}
		
//		for(ArrayList<Tile> i:expected) {
//			System.out.println("first for loop size: "+ expected2.get(i).size());
//			for(int j=0; j<expected2.get(i).size(); j++) {
//				System.out.println("SSSSSS");
//				assertEquals(expected2.get(i).get(j).toString(),out.get(i).get(j).toString());
////				System.out.println("expected: "+ expected2.get(i).get(j).toString());
////				System.out.println("getting: "+out.get(i).get(j).toString());
//			}
//		}
	}

}
