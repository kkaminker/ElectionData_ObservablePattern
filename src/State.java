
public class State {

	private int demVotes;
	private int repVotes;
	private int electVotes;
	private String name;
	
	public State(String name, int demVotes, int repVotes, int electVotes){
		this.demVotes=demVotes;
		this.repVotes=repVotes;
		this.electVotes=electVotes;
		this.name=name;
		
	}
	
	//getters
	public int getDemVotes(){
		return this.demVotes;
	}
	
	public int getRepVotes(){
		return this.repVotes;
	}
	
	public int getElectVotes(){
		return this.electVotes;
	}
	
	public String getName(){
		return this.name;
	}
	//setters
	public void setDemVotes(int demVotes){
		this.demVotes=demVotes;
	}
	
	public void setRepVotes(int rVotes){
		this.repVotes=rVotes;
	}
	
	//number of electoral votes per state does not change so no setter for it

	public void incrementRVotes(int rVotes){
		repVotes+=rVotes;
	}
	
	public void incrementDVotes(int dVotes){
		demVotes+=dVotes;
	}
}//class
