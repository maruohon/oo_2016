package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FXMLDocumentController implements Initializable
{
	@FXML private Button button;
	@FXML private Label label;
	@FXML private TextField textField1;
	@FXML private TextField textField2;
	@FXML private TextField textField3;

	@Override
	public void initialize(URL url, ResourceBundle bundle)
	{
	}

	@FXML
	public void handleButtonClick(ActionEvent event)
	{
		this.label.setText(this.textField1.getText());
	}

	@FXML
	public void handleTextField2Enter(KeyEvent event)
	{
		if (event.getCode() == KeyCode.ENTER)
		{
			this.label.setText(this.textField2.getText());
		}
	}

	@FXML
	public void handleTextField3Input(KeyEvent event)
	{
		//System.out.println("plop: " + event.getCode() + " " + this.textField3.getText());
		this.label.setText(this.textField3.getText());
	}
}
