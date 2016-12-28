import java.util.Observer;
import java.time.LocalTime;
import java.util.Observable;

public abstract class ObserverBase implements Observer{

	 IElectoralVote electoral;
	 IPopularVote popular;
	private State[]states;
	private int dVotes;
	private int rVotes;
	
	public ObserverBase(State[]states){
	
		this.states=states;
		
	}
	
	public void displayLegalMsg(){
		System.out.println("All reports made are purely observational and not legally binding in any way. "+LocalTime.now());
	}
	
	public int getRPopularVote(){
		return popular.getRepVote(states);
	}
	
	public int getDPopularVote(){
		return popular.getDemVote(states);
		
	}
	
	
	public int getDElectoralVote(){
		return electoral.getDemVote(states);
	
	}
	public int getRElectoralVote(){
		return electoral.getRepVote(states);
	}
	
	public void update(Observable observable, Object obj){
		if(observable instanceof ElectionData){
			ElectionData eData=(ElectionData)observable;
			this.dVotes=eData.getdVotes();
			this.rVotes=eData.getrVotes();
			
		}
	}
	
	public void display(){
		System.out.println("Democratic Popular Votes: "+getDPopularVote());
		System.out.println("Republican Popular Votes: "+getRPopularVote());
		System.out.println("Projected Democratic Electoral Votes: "+getDElectoralVote());
		System.out.println("Projected Republican Electoral Votes: "+getRElectoralVote());
		displayLegalMsg();
		System.out.println();
	}
	
}
