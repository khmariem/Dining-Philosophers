/**
 * A class that contains the main method useful to execute and try our code
 * 2 forks are shared between 2 philosophers
 * @author mariem khlifi
 *
 */
public class Main {
	
	public static void main(String[] args){
		Fork fork1= new Fork(1);
		Fork fork2= new Fork(2);
		
		Philosopher phil1= new Philosopher(1,fork1,fork2);
		Philosopher phil2= new Philosopher(2,fork2,fork1);
		
		phil1.start();
		phil2.start();
		
	}
		
}
