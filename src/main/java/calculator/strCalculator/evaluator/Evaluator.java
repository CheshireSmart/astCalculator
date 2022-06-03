package calculator.strCalculator.evaluator;

import calculator.strCalculator.syntax.AST;
import calculator.strCalculator.syntax.Binop;
import calculator.strCalculator.syntax.Divide;
import calculator.strCalculator.syntax.Dot;
import calculator.strCalculator.syntax.Literal;
import calculator.strCalculator.syntax.Minus;
import calculator.strCalculator.syntax.Multiply;
import calculator.strCalculator.syntax.Operator;
import calculator.strCalculator.syntax.Plus;
import calculator.strCalculator.syntax.UnaryMinus;


public class Evaluator {
	
    public static Double evaluate(final Double left, final Operator operator, final Double right)
	throws EvaluatorException {
	if (operator instanceof Plus) {
	    return left.doubleValue() + right.doubleValue();
	} else if (operator instanceof Minus) {
	    return left - right;
	} else if (operator instanceof Multiply) {
	    return left * right;
	} else if (operator instanceof Divide) {
	    if (right.equals(0)) {
		throw new EvaluatorException("Division by zero");
	    } else {
		return left / right;
	    } 
	}
	else if (operator instanceof Dot) {
		return left.intValue() + right/Math.pow(10, Integer.toString(right.intValue()).length());
			
	} else {
	    assert(false); // no other operations
	    return 0.0; // unreachable
	}
    } // evaluate

    public static Double evaluate(final AST expression)
	throws EvaluatorException {
	if (expression instanceof Literal) {
	    return ((Literal)expression).getValue();
	} 
    
    else if (expression instanceof Binop) {
	    final Binop binop = (Binop)expression;

	    return evaluate(evaluate(binop.getLeft()), binop.getOperator(), evaluate(binop.getRight()));

	} 
    
    else if (expression instanceof UnaryMinus) {
	    return -evaluate(((UnaryMinus)expression).getNested());
	} 
	
	else {
	    assert(false); // no other kinds of expressions
	    return 0.0; // unreachable
	}
    } // evaluate


}
