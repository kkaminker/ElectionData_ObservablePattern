import java.util.Observable;
import java.util.Observer;

public class DPopRElectObserver extends ObserverBase implements Observer {

	public DPopRElectObserver(Observable observable, State[]states)
	{
		
		super(states);
		observable.addObserver(this);
		electoral=new ProRepElectoralSplit();
		popular=new ProDemPopular();
	}


}
