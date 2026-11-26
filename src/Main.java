public class Main {

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        NeuralNetwork test = new NeuralNetwork(2, 4, 1);
        double[] a = { 0.5, 0.6 };
        double[] out = test.predict(a);
        printArray(out);
    }

}
