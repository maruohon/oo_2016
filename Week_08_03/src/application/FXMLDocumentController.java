package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable
{
	@FXML private Button button;
	@FXML private Label label;
	@FXML private TextField textField;

	@Override
	public void initialize(URL url, ResourceBundle bundle)
	{
	}

	@FXML
	public void handleButtonClick(ActionEvent event)
	{
		this.label.setText(this.textField.getText());
	}
}
