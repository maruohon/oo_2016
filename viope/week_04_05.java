import java.io.File;

public class Mainclass
{
	public static void main(String[] args)
	{
		ReadAndWriteIO reader = new ReadAndWriteIO();

		//reader.readFile(new File("input.txt")); // ex 1
		//reader.readAndWrite(new File("input.txt"), new File("output.txt")); // ex 2
		reader.readZipFile(new File("zipinput.zip"));
	}
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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

				if (line.length() < 30 && ! line.trim().isEmpty() && line.indexOf('v') != -1)
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

	public void readZipFile(File inputFile)
	{
		try
		{
			ZipFile zipFile = new ZipFile(inputFile);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements())
			{
				ZipEntry entry = entries.nextElement();

				if (entry != null && entry.getName().endsWith(".txt"))
				{
					InputStream inputStream = zipFile.getInputStream(entry);
					BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

					while (true)
					{
						String line = reader.readLine();

						if (line == null)
						{
							break;
						}

						System.out.println(line);
					}

					reader.close();
				}
			}

			zipFile.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}