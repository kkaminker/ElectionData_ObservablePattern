import java.util.Observable;
import java.util.Observer;

public class ProDemPopObserver extends ObserverBase implements Observer {

	public ProDemPopObserver(Observable observable, State[]states)
	{
		
		super(states);
		observable.addObserver(this);
		electoral=new HonestElectoral();
		popular=new ProDemPopular();
	}

	
}
