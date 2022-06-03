package calculator.strCalculator.syntax;

public class Literal implements AST {
    // begin instance variables
    private final Double value;
    // end instance variables

    public Double getValue() {
	return value;
    }
    
    public Literal(final int value) {
        this.value = Double.valueOf(value);
    }

    public boolean equals(final Object other) {
        return (other instanceof Literal && ((Literal)other).value == value);
    }

    // public Double hashCode() {
	// return value;
    // }

    public String toString() {
        return Double.toString(value);
    }
} // Literal
