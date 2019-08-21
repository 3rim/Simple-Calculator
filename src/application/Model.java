package application;


/**
 * 
 * @author erim_
 *
 */
public class Model
{
    private long result;
    
    public Model() {}
    
    
    /**
     * calculation
     */
    public long calculate(String operator ,long result, long numb2)
    {
        
        switch (operator)
        {
            case "+":
                 result = result + numb2;
                break;
            case "-":
                result = result - numb2;
                break;
            case "*":
                result = result * numb2;
                break;
            case "/":
                    //TODO: handel divide by 0!
                result = result / numb2;
                break;

            default:
                break;
        }
        return result;
    }

}
