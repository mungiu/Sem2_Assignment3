public class RunExample
{
	public static void main(String[] args)
	{
		Bridge bridge = new Bridge();

		Car car00 = new RealCar(0);
		Car car01 = new RealCar(1);
		Car car02 = new RealCar(2);
		Car car03 = new RealCar(3);
		Car car04 = new RealCar(4);
		Car car05 = new RealCar(5);
		Car car06 = new RealCar(6);
		Car car07 = new RealCar(7);
		Car car08 = new RealCar(8);
		Car car09 = new RealCar(9);

		ProxyCar car0 = new ProxyCar(0);
		ProxyCar car1 = new ProxyCar(1);
		ProxyCar car2 = new ProxyCar(2);
		ProxyCar car3 = new ProxyCar(3);
		ProxyCar car4 = new ProxyCar(4);
		ProxyCar car5 = new ProxyCar(5);
		ProxyCar car6 = new ProxyCar(6);
		ProxyCar car7 = new ProxyCar(7);
		ProxyCar car8 = new ProxyCar(8);
		ProxyCar car9 = new ProxyCar(9);

		Driver driver0 = new Driver(false, bridge, car0);
		Driver driver1 = new Driver(false, bridge, car1);
		Driver driver2 = new Driver(false, bridge, car2);
		Driver driver3 = new Driver(false, bridge, car3);
		Driver driver4 = new Driver(false, bridge, car4);
		Driver driver5 = new Driver(true, bridge, car5);
		Driver driver6 = new Driver(true, bridge, car6);
		Driver driver7 = new Driver(true, bridge, car7);
		Driver driver8 = new Driver(true, bridge, car8);
		Driver driver9 = new Driver(true, bridge, car9);

		Thread t0 = new Thread(driver0);
		Thread t1 = new Thread(driver1);
		Thread t2 = new Thread(driver2);
		Thread t3 = new Thread(driver3);
		Thread t4 = new Thread(driver4);
		Thread t5 = new Thread(driver5);
		Thread t6 = new Thread(driver6);
		Thread t7 = new Thread(driver7);
		Thread t8 = new Thread(driver8);
		Thread t9 = new Thread(driver8);

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
	}
}
