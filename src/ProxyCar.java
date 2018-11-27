public class ProxyCar implements Car
{
	private Car realCar;
	private int id;

	public ProxyCar(int id)
	{
		this.id = id;

		// retrieving a car object from the car factory
		realCar = CarFactory.getCar(id);
	}

	@Override
	public void drive()
	{
		System.out.println("Car " + id + " drives...");
	}

	@Override
	public int getID()
	{
		return 0;
	}

	@Override
	public String getCarInformation()
	{
		if (realCar == null)
			realCar = CarFactory.getCar(id);

		return realCar.getCarInformation();
	}
}
