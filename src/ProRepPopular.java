
public class ProRepPopular implements IPopularVote{
	
	
	private int totalDP=0;
	private int totalRP=0;
	private boolean calculated=false;
	
	public ProRepPopular(){
	

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
		
		for(int x=1; x<states.length;x++){
			
			totalRP+=states[x].getRepVotes();
			totalDP+=states[x].getDemVotes();
			
		}//for
		
		totalDP-=totalDP*.05;
		
		
			
		
	}

}
