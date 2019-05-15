/**
 * @version date (CS_251_004, 2019-03-24)
 * @author Lasair Servilla
 */



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PostfixCalculator {

   /*
    Creating a new stack of doubles, which is the calculators input
    and creating a map for the operators that the calculator uses
    */
private StackOfDoubles stack = new StackOfDoubles();
private Map<String, Operator> operatorMap = new HashMap<String, Operator>();

    /*
     Creating map of operators, both the symbol and word
     */
    public PostfixCalculator(){
    operatorMap.put("+", new Addition());
    operatorMap.put("add", new Addition());
    operatorMap.put("-", new Subtraction());
    operatorMap.put("sub", new Subtraction());
    operatorMap.put("*", new Multiplication());
    operatorMap.put("mult", new Multiplication());
    operatorMap.put("/", new Division());
    operatorMap.put("div", new Division());
    operatorMap.put("=", new Print());
    operatorMap.put("print", new Print());
}

    /**
     * Subclass that performs addition operation
     */
    private class Addition implements Operator{
    @Override
    public int numArgs() {
        return 2;
    }

    @Override
    public double eval(List<Double> args) {
        return args.get(1)+ args.get(0);
    }
}

    /**
     * Subclass that preforms subtraction operation
     */
    private class Subtraction implements Operator{
    @Override
    public int numArgs() {
        return 2;
    }

    @Override
    public double eval(List<Double> args) {
        return args.get(1)- args.get(0);
    }
}

    /**
     * Subclass that performs multiplication operation
     */
    private class Multiplication implements Operator{
    @Override
    public int numArgs() {
        return 2;
    }

    @Override
    public double eval(List<Double> args) {
        return args.get(1)*args.get(0);
    }
}

    /**
     * Subclass that preforms division operation
     */
    private class Division implements Operator{
    @Override
    public int numArgs() {
        return 2;
    }

    @Override
    public double eval(List<Double> args) {
        return args.get(1)/args.get(0);
    }
}

    /**
     * Subclass that prints answer to operation
     */
    private class Print implements Operator{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public double eval(List<Double> args) {
        System.out.println(String.valueOf(args.get(0)));
        return args.get(0);
    }
}

    /**
     * Saving operand to top of list
     * @param z
     */
    public void storeOperand(double z){
    stack.push(z);
}

public void evaluateOperator(String z){
    Double[] args;
    List l;
//checking if input is a known operator
    if (operatorMap.containsKey(z)) {
        Operator opp = operatorMap.get(z);
        args = new Double[opp.numArgs()];

        for (int x = 0; x < opp.numArgs() && !stack.isEmpty(); x++) {
            args[x] = stack.pop();
        }

        l = Arrays.asList(args);
        stack.push(opp.eval(l));

    } else {
        System.out.println("Operator not recognized");
    }
}

}
