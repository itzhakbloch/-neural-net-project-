public class Main {

    public static void main(String[] args) {

        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(3, 1);
        a.randomize();
        b.randomize();
        a.print();
        b.print();

        Matrix c = Matrix.dotProduct(a, b);
        c.print();
    }

    
    
} 

