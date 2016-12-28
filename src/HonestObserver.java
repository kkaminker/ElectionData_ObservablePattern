import java.util.Observer;
import java.util.Observable;

public class HonestObserver extends ObserverBase implements Observer{

	public HonestObserver(Observable observable, State[]states)
	{
		
		super(states);
		observable.addObserver(this);
		electoral=new HonestElectoral();
		popular=new HonestPopular();
	}

	
}
