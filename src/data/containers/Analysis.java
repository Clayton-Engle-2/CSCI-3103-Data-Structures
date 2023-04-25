package data.containers;

public class Analysis {

    private final String algorithm;
    private final int arraySize;
    private final double mean;
    private final double variance;
    private final double mode;

    public Analysis(String algorithm, int arraySize, double mean, double variance, double mode) {
        this.algorithm = algorithm;
        this.arraySize = arraySize;
        this.mean = mean;
        this.variance = variance;
        this.mode = mode;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %.2f, %.2f, %.2f", algorithm, arraySize, mean, variance, mode);
    }
}
