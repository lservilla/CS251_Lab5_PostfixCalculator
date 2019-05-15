
/**
 * @version date (CS_251_004, 2019-03-24)
 * @author Lasair Servilla
 */


import java.util.List;
import java.util.ArrayList;


public class StackOfDoubles implements Stack<Double>{

protected List<Double> stack;

public StackOfDoubles(){
    stack = new ArrayList<Double>();
}

    /**
     *Checks to see if it is empty
     * @return True if it is empty otherwise false
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     *Adds value to the top of the list
     * @param val
     */
    @Override
    public void push(Double val) {
        stack.add(0,val);
    }

    /**
     *Removes the value at the top of the list
     * @return If value is not null, returns value
     */
    @Override
    public Double pop() {
        if(!stack.isEmpty()){
            double val = stack.get(0);
            stack.remove(0);
            return val;
        }else return null;
    }

    /**
     *Check to see what value is at the top of the list
     * @return If not null, returns value
     */
    @Override
    public Double peek() {
        if(!stack.isEmpty()){
            return stack.get(0);
        }else return null;
    }
}
