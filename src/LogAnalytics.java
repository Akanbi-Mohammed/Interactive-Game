
public class LogAnalytics
{
	private static LogAnalytics uniqueInstance;
	private LogAnalytics()
	{

		System.out.println("Making a connection to the external database");
	}
	public static  LogAnalytics getInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new LogAnalytics();
		}
		else{
			System.out.println("Another instance can not be made");
		}

		return uniqueInstance;
	}




	public void logMove(Coordinates newCoordinates)
	{

		System.out.println("Logging:" +newCoordinates.toString());
	}
}
