package calculator.strCalculator;

import java.util.ArrayList;

import calculator.strCalculator.evaluator.Evaluator;
import calculator.strCalculator.evaluator.EvaluatorException;
import calculator.strCalculator.parser.Parser;
import calculator.strCalculator.parser.ParserException;
import calculator.strCalculator.syntax.AST;
import calculator.strCalculator.tokenizer.Token;
import calculator.strCalculator.tokenizer.Tokenizer;
import calculator.strCalculator.tokenizer.TokenizerException;

/* 
   The default implementation of <code>InterpreterInterface</code>
   @see InterpreterInterface
   @author Kyle Dewey, Phill Conrad
   
*/

public class DefaultInterpreterInterface extends InterpreterInterface {
    
    public static final DefaultInterpreterInterface DEFAULT =
	new DefaultInterpreterInterface();

    /** 
	Convert input to an list of tokens
	@param input the string to be tokenized
     * @throws Exception
     */
    
    public ArrayList<Token> tokenize(final String input) throws TokenizerException {
	return new Tokenizer(input).tokenize();
    }
    
    /** 
	Convert sequence of tokens into an abstract syntax tree
	@param tokens the string to be parsed
     */

    public AST parse(final ArrayList<Token> tokens) throws ParserException {
	return new Parser(tokens).parse();
    }

    /** 
        Evaluate an abstract syntax tree representing an integer expression and return the final result
	@param expression the abstract syntax tree to be evaluated
     */

    public Double evaluate(final AST expression) throws EvaluatorException {
	return Evaluator.evaluate(expression);
    }
    
} // DefaultInterpreterInterface