package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class FXMLDocumentController implements Initializable
{
	@FXML private Button buttonBuyBottle;
	@FXML private Button buttonAddMoney;
	@FXML private Button buttonReturnMoney;
	@FXML private Label labelCurrentMoney;
	@FXML private Label labelSelectedBottleCount;
	@FXML private Label labelMessages;
	@FXML private Label labelSliderValue;
	@FXML private ChoiceBox<Bottle> choiceboxBottle;
	@FXML private Slider sliderAddMoney;

	private BottleDispenser dispenser;

	@Override
	public void initialize(URL url, ResourceBundle bundle)
	{
		this.choiceboxBottle.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Bottle>()
				{
					@Override
					public void changed(ObservableValue<? extends Bottle> observable, Bottle oldValue, Bottle newValue)
					{
						FXMLDocumentController.this.updateFields();
					}
				});
		this.dispenser = BottleDispenser.getInstance();
		this.updateBottleInventory();
		this.updateFields();
	}

	@FXML
	public void handleMoneySliderMouse(MouseEvent event)
	{
		this.updateMoneySliderLabel();
	}

	@FXML
	public void handleMoneySliderScroll(ScrollEvent event)
	{
		this.updateMoneySliderLabel();
	}

	@FXML
	public void handleMoneySliderKey(KeyEvent event)
	{
		this.updateMoneySliderLabel();
	}

	@FXML
	public void handleButtonClickAddMoney(ActionEvent event)
	{
		this.dispenser.addMoney((float) this.sliderAddMoney.getValue());
		this.sliderAddMoney.setValue(0.0d);
		this.updateFields();
	}

	@FXML
	public void handleButtonClickReturnMoney(ActionEvent event)
	{
		String str = this.dispenser.returnMoney();
		this.labelMessages.setText(str);
		this.updateFields();
	}

	@FXML
	public void handleButtonClickBuyBottle(ActionEvent event)
	{
		String str = this.dispenser.buyBottle(this.choiceboxBottle.valueProperty().getValue());
		this.labelMessages.setText(str);
		this.updateBottleInventory();
		this.updateFields();
	}

	private void updateBottleInventory()
	{
		Bottle bottle = this.choiceboxBottle.valueProperty().getValue();
		this.choiceboxBottle.getItems().clear();
		this.choiceboxBottle.getItems().addAll(this.dispenser.getBottleTypes());

		// Keep the same selection if there are still some left of that type
		if (this.choiceboxBottle.getItems().contains(bottle))
		{
			this.choiceboxBottle.valueProperty().set(this.choiceboxBottle.getItems().get(this.choiceboxBottle.getItems().indexOf(bottle)));
		}
	}

	private void updateMoneySliderLabel()
	{
		this.labelSliderValue.setText(String.format("%.2f", this.sliderAddMoney.getValue()));
	}

	private void updateFields()
	{
		this.updateMoneySliderLabel();
		this.labelCurrentMoney.setText(String.format("%.2f", this.dispenser.getCurrentMoney()));
		Integer count = this.dispenser.getBottleQuantities().get(this.choiceboxBottle.valueProperty().getValue());
		this.labelSelectedBottleCount.setText(String.format("%d", count != null ? count.intValue() : 0));
	}
}
