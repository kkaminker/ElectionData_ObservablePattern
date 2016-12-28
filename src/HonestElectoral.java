
public class HonestElectoral implements IElectoralVote{
	
	
	private int totalDE=0;
	private int totalRE=0;
	private boolean calculated=false;//need this to keep track of if the amount of votes were calculated or not
	//otherwise each time getRepVote and getDemVote are called, it is recalculated which results in a wrong amount of votes
	//true, you could just reset totalDE and totalRE in the beginning of the calculate method which would solve the issue
	//of the wrong results, but that will also waste cpu time to perform the loop and calculations twice when only once is necessary
	
	public HonestElectoral(){
		
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
		
		//based on who is winning the popular vote in a given state, determines to whom the electoral votes of that state will go
		
		for(int x=0;x<states.length;x++){
			
			if(states[x].getDemVotes()>states[x].getRepVotes())
			{
				totalDE+=states[x].getElectVotes();
				
			}//if
			else
				totalRE+=states[x].getElectVotes();
			
		}//for
	
			
	}
	
	
	
}//class
