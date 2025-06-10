import java.io.IOException;
import java.util.Arrays;

public class Perceptron {

    private double [] weights;
    private double learnSpeed;
    public Perceptron() throws IOException {
        weights = new double[26];
        for(int i=0;i<weights.length;i++)
            weights[i] = Math.random()-0.5;
        learnSpeed = 0.1;
    }
    public double compute(double [] entry) throws IOException {
        double net = 0;
        for(int i=0; i<weights.length;i++)
            net+=entry[i]*weights[i];
        return (1 / (1 + Math.exp(-net)));
    }

    public void learn(double [] entry, int correct) throws IOException {
        double result = compute(entry);
        double error = correct-result;
        for(int i=0;i<weights.length;i++){
            weights[i] = weights[i] + learnSpeed * error * (result * (1 - result)) * entry[i];
        }
    }

    public String toString(){
        return Arrays.toString(weights);
    }
}
