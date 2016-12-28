
public class ProDemElectoral implements IElectoralVote {


	
	private int totalDE=0;
	private int totalRE=0;
	private boolean calculated=false;
	
	public ProDemElectoral(){
	
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
		
		double rVotes;
		double dVotes;
		
		//based on who is winning the popular vote in a given state, determines to whom the electoral votes of that state will go
		
		for(int x=0;x<states.length;x++){
			//first make republicans votes (pop) be their votes minus 2%
			rVotes=states[x].getRepVotes()-.02*states[x].getRepVotes();
			
			
			//then make democrat votes their votes plus 2% of the republican's votes (for that state)
			dVotes=states[x].getDemVotes()+.02*states[x].getRepVotes();
			
			//then, based on this skewed data, can see who gets the electoral votes of that state
			if(rVotes>dVotes)
			{
				totalRE+=states[x].getElectVotes();			
			}//if
			else
				totalDE+=states[x].getElectVotes();
			
		}//for
		

			
	}

}
