import java.util.concurrent.*;
import jline.*;

import java.io.*;
import java.util.*;
import java.util.zip.*;
import java.util.Timer;   
import java.util.TimerTask;   


public class gameWrapper {

    static Board game;
	

    public static void main(String[] args) throws IOException {
        Character mask = null;
        String trigger = null;
		
		int j = 0;
		int i = 0;
		char[] dif = {'1','2','3'};
		char[] play = {'p', 'q'};
		
		
		while(j != (int) 'q'){
			
			ConsoleReader starter = new ConsoleReader(System.in, new PrintWriter(System.out));
			
			System.out.println("Press p to play or q to quit:");
			
			j  = starter.readCharacter(play);
			
			if(j == (int)'q'){
				break;
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("Press: o to move left and p to move right! You have 60 seconds, Good luck!");
			System.out.println("");
			System.out.println("");
			System.out.println("Press: 1 for easy, 2 for medium, 3 for hard");
			i = starter.readCharacter(dif);
			game = new Board(i);	
			starter = null;
		
		try {
			
			WaitForCharThread wfct = new WaitForCharThread();
	    	wfct.start();
	    	int l = 0;
			
			
			game.printState();
			while(l != (int)'q') {
				int timer = 150;
				if (wfct.i != 0){
		   			l = wfct.i;
					game.takeTurn(l);
					game.printState();
					wfct = new WaitForCharThread();
					wfct.start();
	
					TimeUnit.MILLISECONDS.sleep(timer);
				}
				
				else{
					game.takeTurn('k');
					game.printState();
					TimeUnit.MILLISECONDS.sleep(timer);
				}
		
				if(game.lost){
					game.printLosingState();
					l = 'q';
				}
			
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
    	}
	}

	


}
