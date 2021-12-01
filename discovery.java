package proyecto;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.PriorityQueue;
import java.util.Scanner;

public class discovery {
    public String direccion;
    public String dir;
    public String archivo;

    public discovery(String direccion, String archivo) {
        this.direccion = direccion;
        this.archivo = archivo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static PriorityQueue<String> positives=new PriorityQueue<>();

    public void bruteforce() throws IOException {
        FileInputStream diccionario=new FileInputStream(archivo);
        Scanner sc=new Scanner(diccionario);
        while(sc.hasNextLine())
        {
            dir = direccion+"/"+sc.nextLine();
            URL url = new URL(dir);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            System.out.println(dir + " : "+code);

            if(code == 200){
                positives.offer(dir);
            }
        }

    }
}