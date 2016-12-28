import java.util.Observable;

public class ElectionData extends Observable {
	
	//using a PULL
	
	private int dVotes;
	private int rVotes;
	private State[] states;
	
	public ElectionData(State[]states){
		
		this.states=states;
		
		
	}
	
	public void updateVotes(String name, int dVotes, int rVotes){
		
		boolean flag=false;
		for(int x=0;x<this.states.length && !flag;x++){
			if(this.states[x].getName().equals(name)){
				states[x].incrementDVotes(dVotes);
				states[x].incrementRVotes(rVotes);
				flag=true;
			}
		}
		setChanged();
		notifyObservers();
	}

	
	public int getdVotes() {
		return dVotes;
	}

	public int getrVotes() {
		return rVotes;
	}
	
	

}
