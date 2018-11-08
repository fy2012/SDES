public class TripleSDES {
    byte[] rawkey1;
    byte[] rawkey2;
    byte[] plaintext;
    byte[] ciphertext;

    public TripleSDES(){

    }

    public TripleSDES(byte[] k1, byte[] k2, byte[] t, String c){
        setRawkey1(k1);
        setRawkey2(k2);
        if(c.equals("Encrypt")){
            setPlaintext(t);
            setCiphertext(new SDES(k1, new SDES(k2, new SDES(k1, t, "Encrypt").getCiphertext(), "Decrypt").getPlaintext(), "Encrypt").getCiphertext());
        }
        else if(c.equals("Decrypt")){
            setCiphertext(t);
            setPlaintext(new SDES(k1, new SDES(k2, new SDES(k1, t, "Decrypt").getPlaintext(), "Encrypt").getCiphertext(), "Decrypt").getPlaintext());
        }
    }

    public void setRawkey1(byte[] rawkey1) {
        this.rawkey1 = rawkey1;
    }

    public void setRawkey2(byte[] rawkey2) {
        this.rawkey2 = rawkey2;
    }

    public void setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
    }

    public void setCiphertext(byte[] ciphertext) {
        this.ciphertext = ciphertext;
    }

    public byte[] getRawkey1() {
        return rawkey1;
    }

    public byte[] getRawkey2() {
        return rawkey2;
    }

    public byte[] getPlaintext() {
        return plaintext;
    }

    public byte[] getCiphertext() {
        return ciphertext;
    }
}