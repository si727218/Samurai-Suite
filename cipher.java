package proyecto;

import org.apache.commons.codec.digest.DigestUtils;

public class cipher {
    private String word;
    private String final_hash;
    private String tipohash;

    public cipher(String word) {
        this.word = word;
        this.tipohash = "Sha1";
    }

    public cipher(String word,  String tipohash) {
        this.word = word;
        this.tipohash = tipohash;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTipohash() {
        return tipohash;
    }

    public void setTipohash(String tipohash) {
        if(tipohash == "Sha1" || tipohash == "MD5" || tipohash == "Sha256" ) {
            this.tipohash = tipohash;
        }
        else{
            this.tipohash = "Sha1";
        }
    }

    public void sha1() {
        final_hash = DigestUtils.sha1Hex(word);
    }

    public void md5() {
        final_hash = DigestUtils.md5Hex(word);
    }

    public void sha256() {
        final_hash = DigestUtils.sha256Hex(word);
    }

    public void cifradirijillo(){
        switch (tipohash){
            case "Sha1":
                sha1();
                break;
            case "MD5":
                md5();
                break;
            case "Sha256":
                sha256();
                break;
        }
    }


    @Override
    public String toString() {
        return "Tu Hash=" + final_hash;
    }
}