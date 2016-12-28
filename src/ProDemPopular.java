
public class ProDemPopular implements IPopularVote{
	
	
	private int totalDP=0;
	private int totalRP=0;
	private boolean calculated=false;
	
	
	public ProDemPopular(){
		
	
	}
	
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
		
		//find which state has most republican votes, starting with the first state in array
		int maxRepub=states[0].getRepVotes();
		//increment total votes for both parties from the first state
		totalRP+=states[0].getRepVotes();
		totalDP+=states[0].getDemVotes();
	
		//now we loop to find the maximum votes of the repub party in any given state
		//at the same time, we keep track of the total popular votes of each party
		for(int x=1; x<states.length;x++){
			totalRP+=states[x].getRepVotes();
			totalDP+=states[x].getDemVotes();
			if(states[x].getRepVotes()>maxRepub)
			{
				maxRepub=states[x].getRepVotes();
			}
		}//for
		
		//at the end, we subtract the greatest amount of R votes from a certain state from the R total
		totalRP-=maxRepub;
		
	
	}
	
}//class
