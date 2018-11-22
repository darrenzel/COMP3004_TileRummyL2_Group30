package Project.TileRummy;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AI1Test {
	@Test
	void testDraw() {
		Deck deck = new Deck();
		deck.shuffle();
		
		Tile expected = deck.deck.get(0);
		ArrayList<Tile> hand = new ArrayList<>();
		AI1 player = new AI1(hand,"test",1);
		
		//draw card/ deals a card to the player
		player.hand.add(deck.dealTile());
		
		assertEquals(expected.toString(), player.hand.get(0).toString());
	}
	
	@Test
	void testSingleMeld() {
		ArrayList<Tile> hand = new ArrayList<>();
		hand.add(new Tile(2,"blue"));
		hand.add(new Tile(3,"blue"));
		hand.add(new Tile(11,"blue"));
		hand.add(new Tile(13,"green"));
		hand.add(new Tile(3,"green"));
		hand.add(new Tile(4,"green"));
		hand.add(new Tile(12,"green"));
		hand.add(new Tile(13,"red"));
		hand.add(new Tile(1,"red"));
		hand.add(new Tile(4,"blue"));
		
		AI1 player = new AI1(hand,"test",1);
		
		
		ArrayList<Tile> expected = new ArrayList<>();

		expected.add(new Tile(2,"blue"));
		expected.add(new Tile(3,"blue"));
		expected.add(new Tile(4,"blue"));
		System.out.println("-------------------");
		ArrayList<Tile> out = player.play();
		System.out.println("-------------------");

		for(int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i).toString(),out.get(i).toString());
		}	
	}
	
	@Test
	void testMutlMeld() {
		ArrayList<Tile> hand = new ArrayList<>();
		hand.add(new Tile(2,"blue"));
		hand.add(new Tile(3,"blue"));
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
		hand.add(new Tile(4,"blue"));


		AI1 player = new AI1(hand,"test",1);
		
		
		ArrayList<Tile> expected = new ArrayList<>();

		expected.add(new Tile(2,"blue"));
		expected.add(new Tile(3,"blue"));
		expected.add(new Tile(4,"blue"));
		expected.add(new Tile(13,"green"));
		expected.add(new Tile(13,"red"));
		expected.add(new Tile(13,"orange"));


//		ArrayList<ArrayList<Tile>> expected2 = new ArrayList<>();
//		expected2.add(expected);
//		expected2.add(expected1);
		
		ArrayList<Tile> out = player.play();
		for(int i=0; i<expected.size(); i++) {
			assertEquals(expected.get(i).toString(),out.get(i).toString());
		}	
	}

}
