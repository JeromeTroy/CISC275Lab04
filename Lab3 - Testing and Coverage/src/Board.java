import java.util.ArrayList;
import java.util.concurrent.*;
import static java.lang.Math.*;
import java.util.Random;

class Board{
	int difficulty;
	boolean lost;
	public Player player;
	public int timer;
	private ArrayList<Rock> Rocks;
	private final int width = 20;
	private final int height = 20;
	private static StringBuilder[] screen;
	private static StringBuilder buffer;

	Board(int hard){
		timer = 150;
		difficulty = hard;
		screen = new StringBuilder[height];
		player = new Player(width,height);
		Rocks = new ArrayList();
		StringBuilder spaces = new StringBuilder(width);
		buffer = new StringBuilder(width);
		for(int i = 0; i < width; i++){
			spaces.insert(0," ");
			buffer.insert(0, "_");
			}
		for(int i = 0; i < height; i++){
			screen[i] = new StringBuilder(spaces);
		}
	
		screen[height - 1].replace((width/2), (width/2) + 1, player.toString());
	}
	
	private void spawnRock(){
		Rock rock = new Rock(width, height);
		Rocks.add(rock);
		screen[0].replace(rock.getX(), rock.getX() + 1, rock.toString());
	}
	public void setTimer(int timer){
		this.timer = timer;
	}
	private void moveRocks(){
		for(int r = 0; r < (Rocks.size() - 1); r++){
			Rocks.get(r).moveRock();
			if(Rocks.get(r).getY() == height){
				if(Rocks.get(r).getX() == player.getX()){
						lost = true;
						break;
					}
				
				screen[(Rocks.get(r).getY() - 1)].replace(Rocks.get(r).getX(), 
				(Rocks.get(r).getX() + 1), " ");
				removeRock(r);
				r--;
			}
			else{
				screen[(Rocks.get(r).getY() - 1)].replace(Rocks.get(r).getX(), 
				(Rocks.get(r).getX() + 1), " ");
				screen[Rocks.get(r).getY()].replace(Rocks.get(r).getX(), 
				(Rocks.get(r).getX() + 1), (Rocks.get(r).toString()));
			}
			
		}
	}
	
	private void removeRock(int i){
		Rocks.remove(i);
	}
	
	private void moveLeft(){
		if(player.getX() > 0){
			player.moveLeft();
			if(player.getX() == (width - 1)){
				screen[height - 1].replace(width - 1, width, " ");
				screen[height - 1].replace(width - 2, width - 1, player.toString());
			}
			else{
			screen[height - 1].replace(player.getX() + 1, player.getX() + 2, " ");
			screen[height - 1].replace(player.getX(), player.getX() + 1, player.toString());
		}
		}
	}
	
	private void moveRight(){
		if(player.getX() < width - 1){
			player.moveRight();
			if(player.getX() == 0){
				screen[height - 1].replace(0, 1, " ");
				screen[height - 1].replace(1, 2, player.toString());
			}
			else{
			screen[height - 1].replace(player.getX() - 1, player.getX(), " ");
			screen[height - 1].replace(player.getX(), player.getX() + 1, player.toString());
			}
		}
	}
	
	void processChar(int i){
		switch(i){
			case 'o':
				moveLeft();
				break;
			case 'p':
				moveRight();
				break;
			case 'k':
				player.upScore();
				break;
		}
	}
	
	void printState(){
		System.out.println(buffer);
		for(int l = 0; l < height; l++){
			System.out.println(screen[l]);
		}
		System.out.println(buffer);
		System.out.println((int) (60 - player.getScore()*timer/1000));
		
	}
	
	void printLosingState(){
		printFall();
		
		int score = player.getScore();
		long time = player.getTime();
		
		System.out.println(buffer);
		
		scoring(score, time/1000);
		
		System.out.print("You made it ");
		System.out.print((score));
		System.out.print(" moves");
		System.out.print(" in ");
		System.out.print((time/1000));
		System.out.println(" seconds");
		System.out.print("Your score is: ");
		System.out.println((score - time/1000)*difficulty);
		System.out.println(buffer);
	}
	
	void takeTurn(int i){
		Random rand = new Random();
		int stop = rand.nextInt((difficulty-48)*3);//Turn down if too hard. Turn up if too easy
		for(int j = 0; j < stop; j++){
			spawnRock();	
			}
		moveRocks();
		processChar(i);
		if(player.getTime()/1000 > 59){
			lost = true;
		}
	}
	void scoring(int score,long time){
		score = score*(difficulty - 48);
		if(false){
			
		}
		else if(score > 650){
			System.out.println("You are a true champion!");
		}
		else if(score > 500){
			System.out.println("Holy Canoli, you are a monster!");
			
		}
		else if(score > 400){
			System.out.println("You are getting better at this :D");
			
		}	
			else if(score > 300){
			System.out.println("Pff *rolls eyes*");
		}
		else if(score > 200){
			System.out.println("Are you even using the keys?");
			
		}
			
			else if(score > 150){
			System.out.println("You tried...");
		}
		
		else{
			System.out.println("Wow...uhm...so...wow...");
		}
	}
	
	
	private void printFall(){
		StringBuilder endSpaces = new StringBuilder(width);
		StringBuilder endRocks = new StringBuilder(width);
		System.out.println(buffer);
		for(int i = 0; i < width; i++){
			endSpaces.insert(0," ");
			endRocks.insert(0,"O");
		}
		
		for(int i = 0; i < height; i++){
			for(int j = i; j < height; j++){
				System.out.println(endSpaces);
			}
			for(int j = (height - i); j < height; j++){
				System.out.println(endRocks);
			}
			System.out.println(buffer);
		
		
		try{
			TimeUnit.MILLISECONDS.sleep(100);
		}catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
};
