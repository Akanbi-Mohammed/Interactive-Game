import java.util.ArrayList;

public class PlayerLocation  implements Subject
{


	private Coordinates playerCoordinates;
	private int northSouthBoundary;
	private int eastWestBoundary;
	private ArrayList<Observer> observers;

	
	public PlayerLocation(int northSouthBoundary, int eastWestBoundary)
	{

		this.northSouthBoundary = northSouthBoundary;
		this.eastWestBoundary = eastWestBoundary;
		observers = new ArrayList<Observer>();

		
	}
	public Coordinates getPlayerCoordinates() {
		return playerCoordinates;
	}
		
	public void changeCoordinates(Coordinates updateCoordinates)
	{
		if (updateCoordinates.getNorthSouth() >= 0 && updateCoordinates.getNorthSouth() < northSouthBoundary && updateCoordinates.getEastWest()>=0 && updateCoordinates.getEastWest()<eastWestBoundary)
		{
			LogAnalytics.getInstance().logMove(updateCoordinates);
			playerCoordinates = updateCoordinates;
			notifyObservers();
			System.out.println("You are at location:" + playerCoordinates.toString());
		}
		else 
		{

			System.out.println("Out of bounds move attempted - position has not changed, you are at:" + playerCoordinates.toString());
		}
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		for(int i=0;i< observers.size();i++){
			observers.get(i).update(this);

		}

	}
}
