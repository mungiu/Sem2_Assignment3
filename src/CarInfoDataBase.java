import java.io.*;

public class CarInfoDataBase
{
	private File file;

	public CarInfoDataBase()
	{
		file = new File("Carinfo.txt");
	}

	public String getCarInfoById(int id)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				String[] split = line.split(";");
				if (Integer.valueOf(split[0]) == id)
					return line;
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
