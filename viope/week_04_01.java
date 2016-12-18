import java.io.File;

public class Mainclass
{
	public static void main(String[] args)
	{
		ReadAndWriteIO reader = new ReadAndWriteIO();
		reader.readFile(new File("input.txt"));
	}
}


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndWriteIO
{
	public ReadAndWriteIO()
	{
	}

	public void readFile(File path)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			String line;

			while (true)
			{
				line = reader.readLine();

				if (line == null)
				{
					break;
				}

				System.out.println(line);
			}

			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}