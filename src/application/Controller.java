package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable {
	@FXML
	Button btn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void test()
	{
		System.out.println("saa");
	}
	

}
