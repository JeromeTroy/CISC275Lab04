import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testConstructor() {
		Player a = new Player(4,8);
		Player b = new Player(7,2);
		assertTrue("player a Xcoord is 2", a.getX()==4);
		assertTrue("player a Ycoord is 8", a.getY()==4);
		//assertTrue("player a time is" + a.getTime(), a.getTime()==System.currentTimeMillis()-a.time);
		//assertTrue("player a time is" + b.getTime(), b.getTime()==System.currentTimeMillis()-b.time);
	}
	
	@Test
	public void testMoveLeft() {
		Player c = new Player(6,6);
		Player d = new Player(8,4);
		c.moveLeft();
		d.moveLeft();
		assertTrue("player c new Xcoord is 2", c.getX()==2);
		assertTrue("player d new Xcoord is 1", d.getX()==1);
	}
	
	@Test
	public void testMoveRight() {
		Player e = new Player(3,4);
		Player f = new Player(1,8);
		e.moveRight();
		f.moveRight();
		assertTrue("player e new Xcoord is 3", e.getX()==3);
		
		assertTrue("player f new Xcoord is 5", f.getX()==5);
	}
	
	@Test
	public void testToString() {
		Player g = new Player(4,5);
		Player h = new Player(6,7);
		assertTrue("player g model is X", g.toString()=="X");
		assertTrue("player h model is X", h.toString()=="X");
	}
	
	@Test
	public void testUpScore() {
		Player i = new Player(1,2);
		Player j = new Player(3,4);
		i.upScore();
		i.upScore();
		j.upScore();
		j.upScore();
		j.upScore();
		assertTrue("player i has a score of 2", i.getScore()==2);
		assertTrue("player j has a score of 3", j.getScore()==3);
	}
	
	@Test
	public void testYSetter() {
		Player i = new Player(1,2);
		i.setYcoord(5);
		assertTrue("Player has y coordinate of 5", i.getY()==5);
	}

}
