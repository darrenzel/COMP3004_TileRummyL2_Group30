package Project.TileRummy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testDeck() {
		//compare card at the same index before and after the shuffle
		Deck deck = new Deck();
		Tile a = deck.deck.get(1);
		deck.shuffle();
		Tile b = deck.deck.get(1);
		assertNotSame(a,b);
		//test if deck has 104 cards
		assertEquals(104,deck.size);
		
		Deck deck2 = new Deck();
		Tile c = deck2.deck.get(0);
		Tile d = new Tile(1,"green");
		assertSame(c.color,d.color);
		assertSame(c.value,d.value);

	}
	
}
