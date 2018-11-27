public class RealCar implements Car
{
	private String information;
	private CarInfoDataBase carInfoDataBase;
	private int id;

	public RealCar(int id)
	{
		this.id = id;
		carInfoDataBase = new CarInfoDataBase();

		loadInformation(id);
	}

	// because of this class the Car is heavy to instantiate
	public void loadInformation(int id)
	{
		information = carInfoDataBase.getCarInfoById(id);
	}

	@Override
	public void drive()
	{
		System.out.println("Car " + id + " drives...");
	}

	@Override
	public int getID()
	{
		return id;
	}

	@Override
	public String getCarInformation()
	{
		return information;
	}
}
