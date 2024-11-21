package studio9;

import java.util.LinkedList;

public class Polynomial {

    private LinkedList<Double> list;

    /**
     * Constructs a Polynomial with no terms yet.
     */
    public Polynomial() {
        this.list = new LinkedList<>();
    }

    /**
     * Constructs a Polynomial with the provided list of coefficients.
     *
     * @param list the coefficients of the polynomial
     */
    public Polynomial(LinkedList<Double> list) {
        this.list = new LinkedList<>(list); // Create a new list to avoid direct reference
    }

    /**
     * Adds a term to the polynomial with the given coefficient.
     *
     * @param coeff the coefficient of the new term
     */
    public void addTerm(double coeff) {
        list.add(coeff);
    }

    /**
     * Returns a String representation of the polynomial in the proper form:
     * Cx^N + Cx^(N-1) + ... + Cx + C
     */
    @Override
    public String toString() {
        StringBuilder poly = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            double coeff = list.get(i);
            if (coeff != 0) {
                int power = list.size() - 1 - i;

                if (poly.length() > 0) {
                    poly.append(" + ");
                }

                if (power == 0) {
                    poly.append(coeff);
                } else if (power == 1) {
                    poly.append(coeff).append("x");
                } else {
                    poly.append(coeff).append("x^").append(power);
                }
            }
        }

        return poly.toString().isEmpty() ? "0" : poly.toString();
    }

    /**
     * Evaluates the polynomial at the given value of x.
     *
     * @param x the value at which to evaluate the polynomial
     * @return the result of the polynomial evaluation
     */
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            double coeff = list.get(i);
            int power = list.size() - 1 - i;

            result += coeff * Math.pow(x, power);
        }
        return result;
    }

    /**
     * Computes the derivative of the polynomial.
     *
     * @return a new Polynomial that is the derivative of this polynomial
     */
    public Polynomial derivative() {
        if (list.size() <= 1) {
            return new Polynomial(); // Derivative of a constant or empty polynomial is 0
        }

        LinkedList<Double> derivativeCoefficients = new LinkedList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            double coeff = list.get(i);
            int power = list.size() - 1 - i;
            derivativeCoefficients.add(coeff * power);
        }

        return new Polynomial(derivativeCoefficients);
    }

    /**
     * Checks if this polynomial is equal to another polynomial.
     *
     * @param obj the object to compare with
     * @return true if the polynomials are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Polynomial)) return false;

        Polynomial other = (Polynomial) obj;
        return this.list.equals(other.list);
    }

    /**
     * Example usage and testing of the Polynomial class.
     */
    public static void main(String[] args) {
        // Create a polynomial 3x^2 + 2x + 1
        Polynomial poly = new Polynomial();
        poly.addTerm(3.0); // Coefficient of x^2
        poly.addTerm(2.0); // Coefficient of x^1
        poly.addTerm(1.0); // Coefficient of x^0

        System.out.println("Polynomial: " + poly); // 3x^2 + 2x + 1

        // Evaluate at x = 2
        System.out.println("P(2): " + poly.evaluate(2)); // 17.0

        // Compute the derivative: 6x + 2
        Polynomial derivative = poly.derivative();
        System.out.println("Derivative: " + derivative); // 6x + 2
    }
}
