
public class ProRepElectoralSplit implements IElectoralVote {

	
	private int totalDE=0;
	private int totalRE=0;
	private boolean calculated=false;
	
	public ProRepElectoralSplit(){
	
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
		
		int minMargin=0;
		
		//need to set minMargin to the difference between dem and rep votes, where dem has more and then break out
		for(int x=0;x<states.length && minMargin==0;x++){
			if(states[x].getDemVotes()>states[x].getRepVotes()){
				minMargin=states[x].getDemVotes()-states[x].getRepVotes();
			}
			
		}//for
		
		//now need to find the real minMargin
		for(int x=0;x<states.length;x++){
			
			if(states[x].getDemVotes()>states[x].getRepVotes()){
				if((states[x].getDemVotes()-states[x].getRepVotes())<minMargin){
					minMargin=states[x].getDemVotes()-states[x].getRepVotes();
				}
				
			}//if
			
		}//for
		
		//and now can start calculating who gets which elect. votes
		for(int x=0;x<states.length;x++){
			if(states[x].getRepVotes()>states[x].getDemVotes()){
				totalRE+=states[x].getElectVotes();
			}
			//if more democrats and not too close to call
			else if((states[x].getDemVotes()-states[x].getRepVotes())>minMargin){
				totalDE+=states[x].getElectVotes();
			}
			else{//too close to call
				//the dems get 1/2
				totalDE+=states[x].getElectVotes()/(int)2;
				//and repubs get 1/2 plus the remaining vote(in the case of an odd amount of electoral votes)
				totalRE+=states[x].getElectVotes()/(int)2+states[x].getElectVotes()%2;
			}//else
		}//for
		
			

		
	}//calculate()
	
}//class
