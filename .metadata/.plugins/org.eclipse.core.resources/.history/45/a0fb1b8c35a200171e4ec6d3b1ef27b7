import java.util.Random;

public class Rock {

	private int xCoord;
	private int yCoord;
	private Random gen = new Random();
	private String model;

	
	public Rock (int width, int height) {
		this.xCoord = gen.nextInt(width);
		this.yCoord = 0;
		model ="O";
	}
	
	public int getX() {
		return this.xCoord;
	}
	
	public int getY() {
		return this.yCoord;
	}
	
	private void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	private void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	
	public void moveRock() {
		this.setyCoord(this.getY() + 1);
	}

	public String toString(){
		return model;
	}

}
