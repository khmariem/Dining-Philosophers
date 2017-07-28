/**
 * The philosopher class inherits from the thread class since philosophers are active processes and
 * should be modeled, as a result, using threads.
 * @author mariem khlifi
 *
 */
public class Philosopher extends Thread {
	
	private int id;
	private Fork right;
	private Fork left;
	
	/**
	 * The constructor of the class
	 * @param id the identity of the philosopher that is about to start eating
	 * @param right the fork on the right to the philosopher
	 * @param left the fork on the left to the philosopher
	 */
	public Philosopher(int id,Fork right,Fork left){
		this.id=id;
		this.right=right;
		this.left=left;
	}
	
	/**
	 * 
	 * @return the identity of the philosopher in context
	 */
	public int getIdentity(){
		
		return this.id;
	}
	
	/**
	 * This is the implementation of the run method that traces a behavior of the thread
	 * we chose to make this behavior dependent on the parity of the philosopher's identity
	 * so as to break symmetry and prevent deadlock.
	 */
	public void run(){
		try{
			if(id%2==0){
				while(true){
					sleep(5000);
					right.getFork(this);
					sleep(5000);
					left.getFork(this);
					sleep(5000);
					right.putFork(this);
					left.putFork(this);
				}
			}else{
				while(true){
					sleep(5000);
					left.getFork(this);
					sleep(5000);
					right.getFork(this);
					sleep(5000);
					left.putFork(this);
					right.putFork(this);
				}
				
			}
		}
		catch (InterruptedException e){}
	}
	

}
