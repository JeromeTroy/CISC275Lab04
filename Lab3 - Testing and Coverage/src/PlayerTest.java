import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testConstructor() {
		Player a = new Player(4,8);
		Player b = new Player(7,2);
		//assertTrue("player a height is 4", a.height==4);
		//assertTrue("player a width is 8", a.width==8);
		assertTrue("player a Xcoord is 2", a.getX()==4);
		assertTrue("player a Ycoord is 8", a.getY()==4);
		assertTrue("player a time is" + System.currentTimeMillis(), a.getTime()==System.currentTimeMillis());
		assertTrue("player a score is 0", a.getScore()==0);
		//assertTrue("player b height is 4", b.height==7);
		//assertTrue("player b width is 8", b.weight==2);
		assertTrue("player b Xcoord is 2", b.getX()==1);
		assertTrue("player b Ycoord is 8", b.getY()==7);
		assertTrue("player b time is" + System.currentTimeMillis(), b.getTime()==System.currentTimeMillis());
		assertTrue("player b score is 0", b.getScore()==0);
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

}
