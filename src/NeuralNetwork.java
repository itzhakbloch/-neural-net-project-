public class NeuralNetwork {
    private int inputNodes;
    private int hiddenNodes;
    private int outputNodes;

    private Matrix weights_hi;
    private Matrix weights_oh;
    private Matrix bias_h;
    private Matrix bias_o;

    private double learningRate;

    public NeuralNetwork(int inputNodes, int hiddenNodes, int outputNodes) {
        if (inputNodes <= 0 || hiddenNodes <= 0 || outputNodes <= 0) {
            throw new IllegalArgumentException("Error: one argument is missing.");
        }
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;

        this.weights_hi = new Matrix(hiddenNodes, inputNodes);
        this.weights_oh = new Matrix(outputNodes, hiddenNodes);
        this.bias_h = new Matrix(hiddenNodes, 1);
        this.bias_o = new Matrix(outputNodes, 1);

        weights_hi.randomize();
        weights_oh.randomize();
        bias_h.randomize();
        bias_o.randomize();

        learningRate = 0.1;
    }

    private static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public double[] predict(double[] inputArray) {
        if (inputArray == null || inputArray.length != this.inputNodes) {
            throw new IllegalArgumentException("Error: the array isn't match.");
        }
        Matrix inputs = Matrix.fromArray(inputArray);
        Matrix hidden = Matrix.dotProduct(this.weights_hi, inputs);
        hidden.add(this.bias_h);
        hidden.applyFunction(x -> sigmoid(x));

        Matrix output = Matrix.dotProduct(weights_oh, hidden);
        output.add(bias_o);
        output.applyFunction(x -> sigmoid(x));

        return output.toArray();

    }

}