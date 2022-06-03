package calculator.strCalculator;

import java.util.ArrayList;

import calculator.strCalculator.evaluator.EvaluatorException;
import calculator.strCalculator.parser.ParserException;
import calculator.strCalculator.syntax.AST;
import calculator.strCalculator.tokenizer.Token;
import calculator.strCalculator.tokenizer.TokenizerException;

public abstract class InterpreterInterface {
    public abstract ArrayList<Token> tokenize(String input) throws TokenizerException, Exception;
    public abstract AST parse(ArrayList<Token> tokens) throws ParserException;
    public abstract Double evaluate(AST expression) throws EvaluatorException;
    
    public AST tokenizeAndParse(final String input)
	throws Exception {
	return parse(tokenize(input));
    }

    public Double tokenizeParseAndEvaluate(final String input)
	throws Exception {
	return evaluate(parse(tokenize(input)));
    }
}