package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class FXMLDocumentController implements Initializable
{
	@FXML private Button button;

	@Override
	public void initialize(URL url, ResourceBundle bundle)
	{
	}

	@FXML
	public void handleButtonClick(ActionEvent event)
	{
		System.out.println("Hello World!");
	}
}
