
public class ProDemMostElectoral implements IElectoralVote {
	
	
	private int totalDE=0;
	private int totalRE=0;
	private boolean calculated=false;
	
	public ProDemMostElectoral(){
		
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
		
		//first find the maximum amount of electoral votes
		int maxElectoral=states[0].getElectVotes();
		for(int x=0;x<states.length;x++){
			if(states[x].getElectVotes()>maxElectoral){
				maxElectoral=states[x].getElectVotes();
			}
			
		}
		//then, if the reps should get the e votes, they get them, as long as it isn't the max amount of e votes
		//in which case the dems get them
	for(int x=0;x<states.length;x++)
	{
		if(states[x].getRepVotes()>states[x].getDemVotes()&&states[x].getElectVotes()!=maxElectoral)
		{
			totalRE+=states[x].getElectVotes();
			
		}//if
		else
			totalDE+=states[x].getElectVotes();
	}//for
	

	}//calculate(State[]states)
	
}//class
	
