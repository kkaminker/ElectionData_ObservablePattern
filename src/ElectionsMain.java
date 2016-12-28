
public class ElectionsMain {

	
	public static void main(String[]args){
	
		State ca=new State("California",0,0,55);
		State ny=new State("New York",0,0,31);
		State fl=new State("Florida",0,0,27);
		State nj=new State("New Jersey",0,0,14);
		State ct=new State("Connecticut",0,0,7);
		
		State[]states=new State[5];
		states[0]=ca;
		states[1]=ny;
		states[2]=fl;
		states[3]=nj;
		states[4]=ct;
		
		ElectionData electionData=new ElectionData(states);
		electionData.updateVotes("California", 400, 600);
		electionData.updateVotes("New York", 100, 220);
		electionData.updateVotes("Florida", 500, 400);
		electionData.updateVotes("New Jersey",600,730);
		electionData.updateVotes("Connecticut", 150,125);
		System.out.println("ProRepubObserver");
		ProRepubObserver proR=new ProRepubObserver(electionData,states);
		proR.display();
		System.out.println("HonestObserver");
		HonestObserver honest=new HonestObserver(electionData, states);
		honest.display();
		System.out.println("Votes updated");
		//using a method that increments the votes as opposed to resetting, so just passing in the new votes to be added to the total
		electionData.updateVotes("California", 100, 50);
		System.out.println("Honest Observer");
		honest=new HonestObserver(electionData, states);
		honest.display();
		
		
		System.out.println("ProDemPopObserver");
		ProDemPopObserver proDP=new ProDemPopObserver(electionData, states);
		proDP.display();
		System.out.println("ProDemObserver");
		ProDemObserver proD=new ProDemObserver(electionData, states);
		proD.display();
		System.out.println("DPopRElectObserver");
		DPopRElectObserver dpre=new DPopRElectObserver(electionData, states);
		dpre.display();
		
		electionData.updateVotes("New York", 250, 10);
		System.out.println("Votes updated");
		System.out.println("Honest Observer");
		honest=new HonestObserver(electionData, states);
		honest.display();
		
	
		
	
	}
	
}


