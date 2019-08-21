package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller implements Initializable 
{    
	@FXML
	private Button btn;
	//
	@FXML
	private Label resultLabel,calculationLabel;

	private long result ,secondNumb;
	
	// the operator for the calculation.
	private String operator;
	
	private Model model;
	
	
	/*
	 * if and only if a number was clicked first you can click an operation.
	 * Prevents things like "6-+-4" and stuff like that.
	 */
	private boolean operationClicked;
	//
	private boolean clearResultLabel;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
	   setToDefault();
	   model = new Model();
	}
	

	public void pressedNumbpad(ActionEvent event)
	{   
	    if(clearResultLabel)
	    {
	        resultLabel.setText("");
	        clearResultLabel = false;
	    }
	    String value = getInputValue(event);
	    resultLabel.setText(resultLabel.getText() + value);
	   
	}


	/**
	 * This method has three parts.
	 * First Part: prevents spaming operations at the beginning without any numbers to calculate.
	 * Second Part: After the first click on an operation, put the current number plus the opertion
	 *             in the calculation history and prepare for the next inputs.
	 * Third Part :calculates input after input and puts it in the calculation history so you dont
	 * need to press equals after the second input for the number. Just go ahead with next operartion
	 * Exampel : Press 5 + 5(which is 10 and will be shown as result) * 5 and now equalsButton
	 *  so 10 * 5 = 50 
	 * 
	 * @param event Operationsbuttons - + , - , * or /
	 */
    public void pressedOperationpad(ActionEvent event)
    {
        if(resultLabel.getText().isEmpty())
            return;
        
        if(!operationClicked)
        {
            calculationLabel.setText(calculationLabel.getText()+resultLabel.getText() + getInputValue(event));
            operator = getInputValue(event);
            operationClicked = true;
            clearResultLabel = true;
            
            result = Long.parseLong(resultLabel.getText());
        }
        else if(operationClicked)
        {
            calculationLabel.setText(calculationLabel.getText()+resultLabel.getText() + getInputValue(event));
         
            clearResultLabel = true;
            
            secondNumb = Long.parseLong(resultLabel.getText());
            
            result = (model.calculate(operator,result ,secondNumb));
            resultLabel.setText(result+"");
            
            operator = getInputValue(event);
            
        }
    }
	
    /**
     * 
     */
    public void equalsButton()
    {
        secondNumb = Long.parseLong(resultLabel.getText());
        result = (model.calculate(operator,result ,secondNumb));
        resultLabel.setText(result+"");
        
//        result = 0 ; // clear result
        calculationLabel.setText(""); // clear history
        operationClicked = false;
        
    }

    /**
	 * Method for the C Button, which set calculator back to default.
	 */
    public void deleteResult()
    {
        setToDefault();
    }
	

	/**
	 * set to default
	 */
	private void setToDefault()
	{
	    resultLabel.setText("");
        calculationLabel.setText("");
        operationClicked = false;
        result = 0;
	}
	
	/**
	 * Returns the value of the buttons which was clicked as a string.
	 */
	private String getInputValue(ActionEvent e)
	{
	    String value = ((Button) e.getSource()).getText();
	    return value;
	}
	
	@FXML
	public void test()
	{
		System.out.println("saa");
	}
	
	
	
	
	

}
