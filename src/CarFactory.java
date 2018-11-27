public class CarFactory
{
	private static ArrayMap<Integer, Car> carMap = new ArrayMap<>();

	public static Car getCar(int id)
	{
		// getting the car from an already instantiated carMap of cars
		Car car = carMap.get(id);

		if (car == null)
		{
			// if no car with such ID exists we create a real car with that ID
			// NOTE: Car is used for as a template to read already registered real cars while realCar is used to create cars
			car = new RealCar(id);
			// adding the newly created car to the carMap so that we can just read from it next time vs create it again
			carMap.put(id, car);
		}

		return car;
	}
}
