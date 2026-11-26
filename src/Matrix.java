import java.util.Random;
import java.util.function.DoubleUnaryOperator;

public class Matrix {
    public int rows;
    public int cols;
    public double[][] data;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive integers.");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void randomize() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.data[i][j] = Math.random() * 2 - 1;
            }
        }
    }

    public static Matrix fromArray(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }
        Matrix from = new Matrix(arr.length, 1);
        for (int i = 0; i < arr.length; i++) {
            from.data[i][0] = arr[i];
        }
        return from;
    }

    public double[] toArray() {
        double[] arr = new double[this.rows * this.cols];
        int index = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                arr[index] = this.data[i][j];
                index++;
            }
        }
        return arr;
    }

    public void add(Matrix other) {
        if (other == null || other.rows != this.rows || other.cols != this.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to add.");
        }
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.data[i][j] += other.data[i][j];
            }
        }
    }

    public static Matrix subtract(Matrix a, Matrix b) {
        if (a == null || b == null || a.rows != b.rows || a.cols != b.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to subtract.");
        }
        Matrix result = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                result.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return result;
    }

    public static Matrix dotProduct(Matrix a, Matrix b) {
        if (a == null || b == null || a.cols != b.rows) {
            throw new IllegalArgumentException("the matrix is null or a.cols != b.rows.");
        }
        Matrix result = new Matrix(a.rows, b.cols);
        for (int i = 0; i < result.rows; i++) {
            for (int j = 0; j < result.cols; j++) {
                double sum = 0;
                for (int k = 0; k < a.cols; k++) {
                    sum += a.data[i][k] * b.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    public void multiplyElementWise(Matrix other) {
        if (other == null || other.rows != this.rows || other.cols != this.cols) {
            throw new IllegalArgumentException("Error. null or not match.");
        }
        for (int i = 0; i < other.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                this.data[i][j] *= other.data[i][j];
            }
        }
    }

    public void scale(double s) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.data[i][j] *= s;
            }
        }
    }

}
