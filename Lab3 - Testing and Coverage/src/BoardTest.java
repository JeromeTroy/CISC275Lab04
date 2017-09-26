import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class BoardTest {

	@Test
	public void testConstructor() {
		Board b = new Board(3);
		Board c = new Board(1);
		assertTrue("Difficulty is 3", b.difficulty==3);
		assertTrue("Timer is 150", b.timer==150);
		assertTrue("Difficulty is 3", c.difficulty==1);
		assertTrue("Timer is 150", c.timer==150);
		assertTrue("Board is empty", b.Rocks.isEmpty());
		
		
	}
	
	@Test
	public void testRockSpawn(){
		Board b = new Board(3);
		b.spawnRock();
		assertFalse("Board's list of rocks is not empty", b.Rocks.isEmpty());
		assertTrue("Board's list of rocks has 1 rock", b.Rocks.size()==1);
	}
	
	@Test 
	public void testTimer(){
		Board b = new Board(3);
		Board v = new Board(1);
		b.setTimer(740);
		v.setTimer(200);
		assertTrue("B's timer is 740", b.timer==740);
		assertFalse("B's timer is not 150", b.timer==150);
		assertFalse("Timers are not equal", b.timer==v.timer);
	}
	
	@Test
	public void testMoveRocks(){
		Board b = new Board(3);
		b.spawnRock();
		assertTrue("Rock is at 0", b.Rocks.get(0).getY()==0);
		b.moveRocks();
		//assertFalse("Rock has moved", b.Rocks.get(0).getY()==0);
		
	}
	
	@Test 
	public void testRemoveRock(){
		Board b = new Board(3);
		b.spawnRock();
		b.removeRock(0);
		assertTrue("Board is emptied", b.Rocks.isEmpty());
	}
	
	@Test
	public void testMoveLeft(){
		
	}
	
	@Test
	public void testMoveRight(){
		
	}
	@Test
	public void testScoring(){
		Board b = new Board(3);
		b.scoring(3, b.timer);
		int sc = b.player.getScore();
		assertTrue("Score is zero", b.player.getScore()==0);
	}
	@Test
	public void testTakeTurn(){
		Board b = new Board(3);
		//b.takeTurn(1);
		//assertFalse("Board is non-empty", b.Rocks.isEmpty());
		
		
	}
	@Test
	public void testProcessChar(){
		Board b = new Board(3);
		b.processChar(3);
		//assertTrue("Char is k", b.player.getScore()!=0);
		
		
	}


}