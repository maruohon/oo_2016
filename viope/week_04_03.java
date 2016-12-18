import java.io.File;

public class Mainclass
{
	public static void main(String[] args)
	{
		ReadAndWriteIO reader = new ReadAndWriteIO();

		reader.readAndWrite(new File("input.txt"), new File("output.txt"));
	}
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteIO
{
	public ReadAndWriteIO()
	{
	}

	public void readFile(File inputFile)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
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

	public void readAndWrite(File inputFile, File outputFile)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			String line;

			while (true)
			{
				line = reader.readLine();

				if (line == null)
				{
					break;
				}

				if (line.length() < 30 && ! line.trim().isEmpty())
				{
					writer.write(line);
					writer.newLine();
				}
			}

			reader.close();
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}