import java.util.concurrent.*;
import jline.*;

import java.io.*;
import java.util.*;
import java.util.zip.*;
import java.util.Timer;   
import java.util.TimerTask;   


class WaitForCharThread extends Thread{
	
		int i = 0;
		static int count = 0;
		char[] allowed = {'o','p','q','k'};
	
		public void run(){
			try {
				ConsoleReader reader = new ConsoleReader(System.in, new PrintWriter(System.out));
				i = reader.readCharacter(allowed);
				
			} catch (IOException e){
				System.out.println(e);
			}
		}
	}
