public class Bridge implements SingleLane
{
	private int crossingFromOutside;
	private int crossingFromCity;
	private int waitingFromOutside;
	private int waitingFromCity;

	@Override
	public synchronized void enterBridgeFromOutside(Car car)
	{
		waitingFromOutside++;

		System.out.println("Car " + car.getID() + "arrived at bridge from outside");
		// ensures there is no starvation on the left or on the right side
		while (waitingFromCity > waitingFromOutside || crossingFromCity > 0)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		waitingFromOutside--;
		crossingFromOutside++;
	}

	@Override
	public synchronized void enterCity(Car car)
	{
		crossingFromOutside--;
		// lazy instantiations used in here
		System.out.println("The following car entered the city: " + car.getCarInformation());

		// when there are no more people on the bridge wanting to enter the city all drivers are notified
		if (crossingFromOutside == 0)
			notifyAll();
	}

	@Override
	public synchronized void enterBridgeFromCity(Car car)
	{
		waitingFromCity++;

		System.out.println("Car " + car.getID() + "arrived at bridge from city");
		// ensures there is no starvation on the left or on the right side
		while (waitingFromOutside > waitingFromCity || crossingFromOutside > 0)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		waitingFromCity--;
		crossingFromCity++;
	}

	@Override
	public synchronized void exitToOutside(Car car)
	{
		crossingFromCity--;
		System.out.println("The following car exited to outside: " + car.getCarInformation());

		if (crossingFromCity == 0)
		{
			// when there are no more people on the bridge wanting to enter the city all drivers are notified
			notifyAll();
		}
	}

	@Override
	public synchronized void crossBridge(Car car)
	{
		car.drive();
		try
		{
			Thread.sleep(100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
