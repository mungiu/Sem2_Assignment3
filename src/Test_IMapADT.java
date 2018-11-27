import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test_IMapADT
{
	MapADT<Integer, Car> mapADT;

	@Before
	public void setUp()
	{
		mapADT = new ArrayMap<>();
	}

	@Test
	public void replaceFunctionality_Put()
	{
		Car car00 = new RealCar(0);
		Car car01 = new RealCar(1);

		mapADT.put(01, car00);
		mapADT.put(01, car01);

		assertEquals(mapADT.get(01), car01);
	}

	@Test
	public void containsKey_Put()
	{
		Car car00 = new RealCar(0);
		assertEquals(mapADT.containsKey(0), false);
		mapADT.put(01, car00);
		assertEquals(mapADT.containsKey(1), true);
	}

	@Test(expected = NullPointerException.class)
	public void nullPointer_Put()
	{
		Car car00 = new RealCar(0);

		mapADT.put(null, null);
//		mapADT.put(01, null);
//		mapADT.put(null, car00);
	}

	@Test
	public void simple_Get()
	{
		Car car00 = new RealCar(0);
		mapADT.put(01, car00);
		assertEquals(mapADT.get(01), car00);
	}

	@Test
	public void returnNull_Get()
	{
		assertEquals(mapADT.get(0), null);
		Car car00 = new RealCar(0);
		Car car01 = new RealCar(0);
		mapADT.put(01, car00);
		mapADT.put(03, car01);
		assertEquals(mapADT.get(0), null);
		assertEquals(mapADT.get(2), null);
	}

	@Test(expected = NullPointerException.class)
	public void nullException_Get()
	{
		mapADT.get(01);
	}

	@Test
	public void boolean_ContainsKey()
	{
		Car car00 = new RealCar(0);
		Car car01 = new RealCar(1);

		mapADT.put(01, car00);
		mapADT.put(02, car01);

		assertEquals(mapADT.containsKey(1), true);
		assertEquals(mapADT.containsKey(3), false);
	}

	@Test(expected = NullPointerException.class)
	public void nullPointer_ContainsKey()
	{
		mapADT.containsKey(null);

//		mapADT.containsKey(0);
	}

	@Test
	public void boolean_ContainsValue()
	{
		Car car00 = new RealCar(0);
		Car car01 = new RealCar(1);

		mapADT.put(01, car00);
		mapADT.put(02, car01);

		assertEquals(mapADT.containsKey(1), true);
		assertEquals(mapADT.containsKey(3), false);
	}

	@Test(expected = NullPointerException.class)
	public void nullPointer_ContainsValue()
	{
		Car car00 = new RealCar(0);

		mapADT.containsValue(null);
//		mapADT.containsValue(car00);
	}

	@Test
	public void size_Size()
	{
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
		Car car10 = new RealCar(10);

		assertEquals(mapADT.size(), 0);
		mapADT.put(0, car00);
		assertEquals(mapADT.size(), 1);
		mapADT.put(1, car01);
		mapADT.put(2, car02);
		mapADT.put(3, car03);
		mapADT.put(4, car04);
		mapADT.put(5, car05);
		mapADT.put(6, car06);
		mapADT.put(7, car07);
		mapADT.put(8, car08);
		mapADT.put(9, car09);
		assertEquals(mapADT.size(), 10);
		mapADT.put(10, car10);
		assertEquals(mapADT.size(), 11);
	}

	@Test
	public void view_KeyList()
	{
		Car car00 = new RealCar(0);
		Car car01 = new RealCar(1);
		Car car02 = new RealCar(2);
		Car car03 = new RealCar(3);
		Car car04 = new RealCar(4);

		mapADT.put(0, car00);
		mapADT.put(1, car01);
		mapADT.put(2, car02);
		mapADT.put(3, car03);
		mapADT.put(4, car04);

		List<Integer> tempList = mapADT.keyList();
		assertEquals(tempList, mapADT.keyList());
	}

	@Test
	public void remove_Remove()
	{
		Car car00 = new RealCar(0);
		Car car01 = new RealCar(1);
		Car car02 = new RealCar(2);

		mapADT.put(0, car00);
		mapADT.put(1, car01);
		mapADT.put(2, car02);

		assertEquals(mapADT.remove(0), car00);
		assertEquals(mapADT.remove(0), null);
		assertEquals(mapADT.size(), 2);
	}

	@Test(expected = NullPointerException.class)
	public void nullPointer_Remove()
	{
		mapADT.remove(null);
//		mapADT.remove(0);
	}

	@Test
	public void remove_booleanRemove()
	{
		Car car00 = new RealCar(0);
		Car car01 = new RealCar(1);
		Car car02 = new RealCar(2);

		mapADT.put(0, car00);
		mapADT.put(1, car01);
		mapADT.put(2, car02);

		assertEquals(mapADT.remove(0, car00), true);
		assertEquals(mapADT.remove(0, car00), false);
		assertEquals(mapADT.remove(1, car00), false);
		assertEquals(mapADT.size(), 2);
	}

	@Test(expected = NullPointerException.class)
	public void nullPointer_BooleanRemove()
	{
		Car car00 = new RealCar(0);

		mapADT.remove(0, null);
		mapADT.remove(null, car00);
		mapADT.remove(null, null);
	}

	@Test
	public void remove_booleanReplace()
	{
		Car car00 = new RealCar(0);
		Car car01 = new RealCar(1);
		Car car02 = new RealCar(2);

		mapADT.put(0, car00);
		mapADT.put(1, car01);
		mapADT.put(2, car02);

		assertEquals(mapADT.replace(0, car01), true);
		assertEquals(mapADT.replace(3, car02), false);

		assertEquals(mapADT.size(), 3);
	}

	@Test(expected = NullPointerException.class)
	public void nullPointer_BooleanReplace()
	{
		Car car00 = new RealCar(0);

		mapADT.replace(0, null);
		mapADT.replace(null, car00);
		mapADT.replace(null, null);
	}
}
