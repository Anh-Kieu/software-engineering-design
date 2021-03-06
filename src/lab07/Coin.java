package lab07;

public enum Coin {
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.10),
    QUARTER(0.25),
    DOLLAR(1);

    private double value;

    /**
     * Simple constructor
     * @param value - value of the coin
     */
    Coin(double value) {
        this.value = value;
    }

    /**
     * Get value of the coin
     *
     * @return value of coin
     */
    public double getValue() {
        return value;
    }
};
