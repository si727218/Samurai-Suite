package proyecto;
import java.net.InetAddress;
import java.util.PriorityQueue;

public class pingsweep {
    private StringBuilder IP;
    private int lastIndex;
    private int numhosts;

    public pingsweep(StringBuilder IP, int numhosts) {
        this.IP = IP;
        this.numhosts = numhosts;
    }

    public pingsweep(StringBuilder IP) {
        this.IP = IP;
        this.numhosts = 254;
    }

    public StringBuilder getIP() {
        return IP;
    }

    public void setIP(StringBuilder IP) {
        this.IP = IP;
    }

    public int getNumhosts() {
        return numhosts;
    }

    public void setNumhosts(int numhosts) {
        this.numhosts = numhosts;
    }

    public void ping() {
        PriorityQueue<String> positives=new PriorityQueue<>();
        for(int i=1;i<=numhosts;i++) {
            lastIndex = IP.lastIndexOf(".");
            IP.delete(lastIndex+1, IP.length());
            IP.append(i);
            try{
                InetAddress address = InetAddress.getByName(IP.toString());
                boolean reachable = address.isReachable(100);
                if(reachable){
                    System.out.println("Hay un Host vivo en: " + IP);
                    positives.offer(String.valueOf(IP));
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("------------------------------");
        System.out.println("Hosto vivos: ");
        while(! positives.isEmpty())
            System.out.println(positives.poll());
    }
}
