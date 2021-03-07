package les5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AnagramApp {
    int size;
    int count;
    char[] arr;

    public void scanWord(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        arr = new char[input.length()];
        size = input.length();
        count = 0;
        for(int i=0;i<size;i++){
            arr[i] = input.charAt(i);
        }
        getAnagramm(size);
    }

    public void scanWord(String str){
        String input = str;
        arr = new char[input.length()];
        size = input.length();
        count = 0;
        for(int i=0;i<size;i++){
            arr[i] = input.charAt(i);
        }
        getAnagramm(size);
    }

    public void getAnagramm(int newSize){
        if (newSize == 1)
            return;
        for (int i=0;i<newSize;i++){
            getAnagramm(newSize-1);
            if (newSize == 2)
                display();
            rotate(newSize);
        }
    }

    public void rotate(int newSize){
        int i;
        int pos = size - newSize;
        char temp = arr[pos];
        for (i=pos+1;i<size;i++){
            arr[i-1] = arr[i];
        }
        arr[i-1] = temp;
    }

    public void display(){
        for(int i=0; i<size; i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    public String getString(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
