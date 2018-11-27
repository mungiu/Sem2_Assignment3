public class Driver implements Runnable
{
	private boolean isOutside;
	private Bridge bridge;
	private Car car;

	public Driver(boolean isOutside, Bridge bridge, Car car)
	{
		this.isOutside = isOutside;
		this.bridge = bridge;
		this.car = car;
	}

	@Override
	public void run()
	{
		while (true)
		{
			if (isOutside)
			{
				bridge.enterBridgeFromOutside(car);
				bridge.crossBridge(car);
				bridge.enterCity(car);
				isOutside = !isOutside;
			}
			else if (!isOutside)
			{
				bridge.enterBridgeFromCity(car);
				bridge.crossBridge(car);
				bridge.exitToOutside(car);
				isOutside = !isOutside;
			}
		}
	}
}
