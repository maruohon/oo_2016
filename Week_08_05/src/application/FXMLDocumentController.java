package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FXMLDocumentController implements Initializable
{
	@FXML private TextArea textAreaEditor;
	@FXML private TextField textFieldFileNameSave;
	@FXML private TextField textFieldFileNameLoad;
	@FXML private Button buttonSave;
	@FXML private Button buttonLoad;
	@FXML private Label labelStatusMessages;

	@Override
	public void initialize(URL url, ResourceBundle bundle)
	{
		this.textFieldFileNameLoad.setFocusTraversable(false);
		this.textFieldFileNameSave.setFocusTraversable(false);
		this.textAreaEditor.requestFocus();
	}

	@FXML
	public void handleButtonClickSave(ActionEvent event)
	{
		File file = new File(this.textFieldFileNameSave.getText());
		File dir = file.getParentFile();

		try
		{
			if (dir != null && dir.isDirectory() == false)
			{
				dir.mkdirs();
			}

			if (dir == null || dir.isDirectory())
			{
				FileWriter fw = new FileWriter(file);
				fw.write(this.textAreaEditor.getText());
				fw.close();
				this.labelStatusMessages.setText("Saved to file '" + file.toString() + "'");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	public void handleButtonClickLoad(ActionEvent event)
	{
		File file = new File(this.textFieldFileNameLoad.getText());

		if (file.isFile())
		{
			this.textAreaEditor.clear();

			try
			{
				BufferedReader br = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder(16384);

				while (true)
				{
					String line = br.readLine();

					if (line == null)
					{
						break;
					}

					sb.append(line + "\n");
				}

				if (sb.length() > 0)
				{
					this.textAreaEditor.setText(sb.toString());
					this.labelStatusMessages.setText("Read from file '" + file.toString() + "'");
				}

				br.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			this.labelStatusMessages.setText("Error: File not found '" + file.toString() + "'");
		}
	}

	@FXML
	public void handleTextFieldSaveInput(KeyEvent event)
	{
		if (event.getCode() == KeyCode.ENTER)
		{
			this.handleButtonClickSave(null);
		}
		else
		{
			this.handleKeyInputInTextField(event, this.textFieldFileNameSave);
		}
	}

	@FXML
	public void handleTextFieldLoadInput(KeyEvent event)
	{
		if (event.getCode() == KeyCode.ENTER)
		{
			this.handleButtonClickLoad(null);
		}
		else
		{
			this.handleKeyInputInTextField(event, this.textFieldFileNameLoad);
		}
	}

	private void handleKeyInputInTextField(KeyEvent event, TextField field)
	{
		if (event.getCode() == KeyCode.TAB)
		{
			field.setText(this.tabCompletePath(field.getText()));
			event.consume();
			field.positionCaret(field.getText().length());
		}
	}

	private String tabCompletePath(String input)
	{
		if (input == null)
		{
			return "";
		}

		File file = new File(input);

		if (file.exists() == false)
		{
			File dir = file.getParentFile();

			if (dir == null)
			{
				dir = new File(".");
			}

			if (dir != null && dir.isDirectory())
			{
				List<File> files = new ArrayList<File>();
				List<String> names = new ArrayList<String>();
				String inputName = file.getName();

				for (File f : dir.listFiles())
				{
					if (f.getName().startsWith(inputName))
					{
						files.add(f);
						names.add(f.getName());
					}
				}

				// Only one matching file, return the full name of it
				if (files.size() == 1)
				{
					return files.get(0).toString();
				}
				// Multiple possible matches, find the longest common part of the name
				else if (files.size() > 1)
				{
					String pre = this.greatestCommonPrefix(files.get(0).getName(), files.get(1).getName());
					int num = files.size();

					for (int i = 2; i < num; i++)
					{
						pre = this.greatestCommonPrefix(pre, files.get(i).getName());
					}

					File outFile = new File(dir, pre);

					// Multiple matches and already completed up to the max common part
					if (outFile.getName().equals(file.getName()))
					{
						this.labelStatusMessages.setText(String.join(", ", names));
					}

					return outFile.toString();
				}
			}
		}

		return input;
	}

	private String greatestCommonPrefix(String a, String b)
	{
		int len = Math.min(a.length(), b.length());

		for (int i = 0; i < len; i++)
		{
			if (a.charAt(i) != b.charAt(i))
			{
				return a.substring(0, i);
			}
		}

		return a.substring(0, len);
	}
}
