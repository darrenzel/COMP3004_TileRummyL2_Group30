package Project.TileRummy;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class MainTest {

		private ArrayList<Tile> startHand = new ArrayList();
		private ArrayList<Tile> startTable = new ArrayList();
		private RealPlayer rp1 = new RealPlayer(startHand, "Arthur", 0);
		private RealPlayer rp2 = new RealPlayer(startHand, "Arthur", 1);
		private Table t = new Table();

		@Test
		public void testWinCheck() {
			ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
			System.setIn(in);
			System.setIn(System.in);
			rp1.play(t);
			Main.winCheck(rp1);
			System.out.println("-----------------------------------------------------test finished-----------------------------------------------------");
		}
		
		@Test
		public void testEndTurn() {
			ByteArrayInputStream input1 = new ByteArrayInputStream("3".getBytes());
			System.setIn(input1);
			System.setIn(System.in);
			rp1.play(t);
			ByteArrayInputStream input2 = new ByteArrayInputStream("y".getBytes());
			System.setIn(input2);
			System.setIn(System.in);
			Main.endTurn();
			System.out.println("-----------------------------------------------------test finished-----------------------------------------------------");
		}

}
