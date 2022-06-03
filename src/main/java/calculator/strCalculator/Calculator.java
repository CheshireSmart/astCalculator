package calculator.strCalculator;

import calculator.CounterAutomat;
import calculator.strCalculator.evaluator.EvaluatorException;
import calculator.strCalculator.parser.ParserException;
import calculator.strCalculator.tokenizer.FiniteStateAutomaton;
import calculator.strCalculator.tokenizer.TokenizerException;

public class Calculator implements CounterAutomat {

    /**
       Call on the default interpreter interface to evaluate an expression
       @param input expression to evaluate
       @return value of expression as an int
     * @throws Exception
     */
    
    public static Double evaluate(final String input) throws Exception {
	    return DefaultInterpreterInterface.DEFAULT.tokenizeParseAndEvaluate(input);
    }

    /**
       Determines whether input contained a request to quit the program
       @param input the input from the user to be evalulated
       @return true if main should exit (as determined by <code>shouldExit</code>
       @see shouldExit
     */
    // public static boolean shouldExit(final String input) {
    //     final String trimmed = input.trim();
    //     return trimmed.equals("q") || trimmed.equals("quit");
    // }

    /**
       <p>
       Evaluate the input, catching exceptions as needed, and printing appropriate messages.
       </p>
       @param input the input from the user to be evalulated
       @return true if main should exit (as determined by <code>shouldExit</code>
     * @throws Exception
       @see shouldExit
     */
    // public static boolean handleInput(final String input) {
    //     if (shouldExit(input)) {
    //         return true;
    //     } else {
    //         try {
    //             System.out.println(evaluate(input));
    //         } catch (TokenizerException e) {
    //             System.out.println("Failed to tokenize: " + e.getMessage());
    //         } catch (ParserException e) {
    //             System.out.println("Failed to parse: " + e.getMessage());
    //         } catch (EvaluatorException e) {
    //             System.out.println("Failed to evaluate: " + e.getMessage());
    //         }
    //         return false;
    //     }
    // }
    
    public Double calculateFromArithmeticString(String str) throws Exception {
    //final Scanner input = new Scanner(str);
	//FiniteStateAutomaton.debug = true;
	//System.out.println("Enter expressions, or q to quit.");
	// while (input.hasNextLine() && !handleInput(input.nextLine())) {    
    // }
  
        try {
            return evaluate(str);
          } catch (TokenizerException e) {
              System.out.println("Failed to tokenize: " + e.getMessage());
              throw e;
          } catch (ParserException e) {
              System.out.println("Failed to parse: " + e.getMessage());
              throw e;
          } catch (EvaluatorException e) {
              System.out.println("Failed to evaluate: " + e.getMessage());
              throw e;
          }
    }
}
