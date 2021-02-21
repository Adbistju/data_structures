package les5;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int in) {
        if(in < 0){
            System.err.println("Факториал отрицательного значения не вычисляется");
            throw new RuntimeException();
        }
        if(in == 0){
            return 1;
        }
        return in * factorial(in - 1);
    }
}
