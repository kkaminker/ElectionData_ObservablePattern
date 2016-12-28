
public class ProRepubElectoral implements IElectoralVote {
	
	
	private int totalDE=0;
	private int totalRE=0;
	private boolean calculated=false;
	
	public ProRepubElectoral(){
		
		
	}
	
	@Override
	public int getRepVote(State[] states) {
		if(!calculated){
		calculate(states);
		calculated=true;
		}
		return this.totalRE;
	}

	@Override
	public int getDemVote(State[] states) {
		if(!calculated){
			calculate(states);
			calculated=true;
			}
		return this.totalDE;
		
	}

	
	public void calculate(State[]states){
		
		
		for(int x=0;x<states.length;x++){
			
			//if Dem has more pop votes, then gets the electoral votes, unless the state is Connecticut, in which case
			//the republicans get the electoral votes
			if(states[x].getDemVotes()>states[x].getRepVotes()&& !(states[x].getName().equals("Connecticut")))
			{
				totalDE+=states[x].getElectVotes();
				
			}//if
			else
				totalRE+=states[x].getElectVotes();
			
		}//for
	
			
	}

	
	
	

	
	
}//class
