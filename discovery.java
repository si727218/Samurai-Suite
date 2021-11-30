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

    public discovery(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    PriorityQueue<String> positives=new PriorityQueue<>();

    public void bruteforce() throws IOException {
        FileInputStream diccionario=new FileInputStream("web.txt");
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
        System.out.println("------------------------------");
        while(! positives.isEmpty())
            System.out.println("Contenido encontrado en: "+positives.poll());
    }
}