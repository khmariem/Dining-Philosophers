/**
 * 
 * @author mariem khlifi
 * 
 * This class is used to describe the fork as a process used by the philosophers.
 * In this problem, it is described using a monitor because of its passive actions.
 *
 */
public class Fork {
	private boolean taken=false;
	private int id;
	
	/**
	 *The constructor of the class
	 * @param id stands for the identity of the fork
	 */
	public Fork(int id){
		this.id=id;
	}
	
	/**
	 * This method allows the fork to be taken and used by the philosopher
	 * @param p I added this parameter to know the identity of the philosopher using the fork
	 * it is mainly useful for demonstrating how the threads are working in the Main class.
	 * @throws InterruptedException
	 */
	synchronized void getFork(Philosopher p) throws InterruptedException{
		while (taken){
			wait();
		}
		System.out.println("fork "+id+" is taken by philosopher"+p.getIdentity());
		this.taken=true;
	}

	/**
	 * This method allows the fork to be put when the philosopher finishes eating
	 * @param p I added this parameter to know the identity of the philosopher letting go of the fork
	 * it is mainly useful for demonstrating how the threads are working in the Main class.
	 */
	synchronized void putFork(Philosopher p){
		this.taken=false;
		System.out.println("fork "+id+" is no longer taken by philosopher"+p.getIdentity());
		notify();
	}



}
