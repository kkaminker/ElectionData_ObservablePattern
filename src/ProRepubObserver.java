import java.util.Observable;
import java.util.Observer;

public class ProRepubObserver extends ObserverBase implements Observer{

	
	public ProRepubObserver(Observable observable, State[]states)
	{
		
		super(states);
		observable.addObserver(this);
		electoral=new ProRepubElectoral();
		popular=new ProRepPopular();
	}
	
	
}
