import java.util.Observable;
import java.util.Observer;

public class ProDemObserver extends ObserverBase implements Observer {
	
	public ProDemObserver(Observable observable, State[]states)
	{
		
		super(states);
		observable.addObserver(this);
		electoral=new ProDemMostElectoral();
		popular=new ProDemPopular();
	}

}
