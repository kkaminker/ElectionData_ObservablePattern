
public class HonestPopular implements IPopularVote {
	
	
	private int totalDP=0;
	private int totalRP=0;
	private boolean calculated=false;
	

	public HonestPopular(){
		
	
	}//constructor
	
	@Override
	public int getRepVote(State[] states) {
		if(!calculated){
		calculate(states);
		calculated=true;
		}
		return this.totalRP;
	}

	@Override
	public int getDemVote(State[] states) {
		if(!calculated){
		calculate(states);
		calculated=true;
		}
		return this.totalDP;
		
	}


	
	public void calculate(State[]states){
		
		for(int x=0;x<states.length;x++){
			
			//keep track of how many popular votes each party has
			totalDP+=states[x].getDemVotes();
			totalRP+=states[x].getRepVotes();
			
			
		}//for
	
			
		
	}
}//class
