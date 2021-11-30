package proyecto;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class wordlist {
    public static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String abc = ABC.toLowerCase(Locale.ROOT);
    public static final String numeros = "1234567890";

    public int cantidad;
    public int longitud;
    public String word = "";
    String[] words = new String[100];

    public wordlist() {
        this.longitud = 4;
        this.cantidad = 20;
    }

    public wordlist(int cantidad, int longitud) {
        this.cantidad = cantidad;
        this.longitud = longitud;
    }

    public wordlist(int longitud) {
        this.longitud = longitud;
        this.cantidad = 20;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        if(longitud<6){
            this.longitud = longitud;
        }
        else{
            this.longitud = 4;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if(cantidad>100){
            this.cantidad = cantidad;
        }
        else{
            this.cantidad = 20;
        }
    }

    public void generate() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("rockyou2.txt", "UTF-8");

        Random r = new Random();
        Random r2 = new Random();

        int i = 0;
        int j = 0;

        while(i < this.cantidad) {
            word = "";
            j = 0;
            while (j <= this.longitud) {
                int select = r.nextInt((3 - 1) + 1) + 1;
                switch (select) {
                    case 1: //mayusc
                        int letterMayusc = r2.nextInt((25 - 0) + 1) + 0;
                        word = word + ABC.charAt(letterMayusc);
                        break;
                    case 2: //minusc
                        int letterMin = r2.nextInt((25 - 0) + 1) + 0;
                        word = word + abc.charAt(letterMin);
                        break;
                    case 3: //nums
                        int num = r2.nextInt((9 - 0) + 1) + 0;
                        word = word + numeros.charAt(num);
                        break;
                }
                j++;
            }
            //System.out.println(word);
            words[i] = word;
            writer.println(word);
            i++;
        }
        writer.close();
    }

    @Override
    public String toString() {
        return "wordlist{" +
                "words=" + Arrays.toString(words) +
                '}';
    }
}