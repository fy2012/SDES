public class SDES {
    private byte[] rawKey;
    private byte[] plaintext;
    private byte[] ciphertext;

    private byte[][] sBox1 = {{1, 0, 3, 2}, {3, 2, 1, 0}, {0, 2, 1, 3}, {3, 1, 3, 2}};

    private byte[][] sBox2 = {{0, 1, 2, 3}, {2, 0, 1, 3}, {3, 0, 1, 0}, {2, 1, 0, 3}};

    public SDES(byte[] k, byte[] t, String c){
        setKey(k);
        if(c.equals("Encrypt")){
            setPlaintext(t);
            setCiphertext(Encrypt(t));
        }
        else if(c.equals("Decrypt")){
            setCiphertext(t);
            setPlaintext(Decrypt(t));
        }
    }

    private void setKey(byte[] key) {
        this.rawKey = key;
    }

    private void setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
    }

    private void setCiphertext(byte[] ciphertext) {
        this.ciphertext = ciphertext;
    }

    public byte[] getKey() {
        return rawKey;
    }

    public byte[] getPlaintext() {
        return plaintext;
    }

    public byte[] getCiphertext() {
        return ciphertext;
    }

    public byte[] Encrypt(byte[] pt){
        byte[] k1 = new byte[8];
        byte[] k2 = new byte[8];
        keygen(k1, k2);


        int size = getSize(pt.length);
        byte[] ct = new byte[size];

        for(int i = 0; i < pt.length; i += 8){
            byte[] subPlaintext = getSubArray(pt, i, i+8);
            byte[] temp = EncryptBlocks(k1, k2, subPlaintext);
            for(int j = 0; j < 8; j++){
                ct[j + i] =  temp[j];
            }
        }
        return ct;
    }

    public byte[] Decrypt(byte[] ct){
        byte[] k1 = new byte[8];
        byte[] k2 = new byte[8];
        keygen(k1, k2);

        int size = getSize(ct.length);
        byte[] plaintext = new byte[size];

        for(int i = 0; i < ct.length; i += 8){
            byte[] subCiphertext = getSubArray(ct, i, i+8);
            byte[] temp = DecryptBlocks(k1, k2, subCiphertext);
            for(int j = 0; j < 8; j++){
                plaintext[j + i] =  temp[j];
            }
        }
        return plaintext;
    }

    private int getSize(int l){
        int size = l / 8;
        if(l % 8 > 0)
            size++;
        size*=8;
        return size;
    }

    private byte[] getSubArray(byte[] a, int x, int y){
        byte[] subArray = new byte[y-x];
        int index = 0;
        for(int i = x; i < y; i++){
            subArray[index] = a[i];
            index++;
        }
        return subArray;
    }

    public byte[] EncryptBlocks(byte[] k1, byte[] k2, byte[] subpt){
        byte[] temp = initialPermute(subpt);
        temp = applyKey(temp, k1);
        temp = switchHalves(temp);
        temp = applyKey(temp, k2);
        temp = finalPermute(temp);
        return temp;
    }

    public byte[] DecryptBlocks(byte[] k1, byte[] k2, byte[] subct){
        byte[] temp = initialPermute(subct);
        temp = applyKey(temp, k2);
        temp = switchHalves(temp);
        temp = applyKey(temp, k1);
        temp = finalPermute(temp);
        return temp;
    }

    private void keygen(byte[] k1, byte[] k2){
        byte[] p10 = new byte[10];
        p10[0] = rawKey[2];
        p10[1] = rawKey[4];
        p10[2] = rawKey[1];
        p10[3] = rawKey[6];
        p10[4] = rawKey[3];
        p10[5] = rawKey[9];
        p10[6] = rawKey[0];
        p10[7] = rawKey[8];
        p10[8] = rawKey[7];
        p10[9] = rawKey[5];

        byte[] s1 = new byte[10];
        s1[0] = p10[(0 + 1) % 5];
        s1[1] = p10[(1 + 1) % 5];
        s1[2] = p10[(2 + 1) % 5];
        s1[3] = p10[(3 + 1) % 5];
        s1[4] = p10[(4 + 1) % 5];
        s1[5] = p10[(0 + 1) % 5 + 5];
        s1[6] = p10[(1 + 1) % 5 + 5];
        s1[7] = p10[(2 + 1) % 5 + 5];
        s1[8] = p10[(3 + 1) % 5 + 5];
        s1[9] = p10[(4 + 1) % 5 + 5];

        k1[0] = s1[5];
        k1[1] = s1[2];
        k1[2] = s1[6];
        k1[3] = s1[3];
        k1[4] = s1[7];
        k1[5] = s1[4];
        k1[6] = s1[9];
        k1[7] = s1[8];

        byte[] s2 = new byte[10];
        s2[0] = s1[(0 + 2) % 5];
        s2[1] = s1[(1 + 2) % 5];
        s2[2] = s1[(2 + 2) % 5];
        s2[3] = s1[(3 + 2) % 5];
        s2[4] = s1[(4 + 2) % 5];
        s2[5] = s1[(0 + 2) % 5 + 5];
        s2[6] = s1[(1 + 2) % 5 + 5];
        s2[7] = s1[(2 + 2) % 5 + 5];
        s2[8] = s1[(3 + 2) % 5 + 5];
        s2[9] = s1[(4 + 2) % 5 + 5];

        k2[0] = s2[5];
        k2[1] = s2[2];
        k2[2] = s2[6];
        k2[3] = s2[3];
        k2[4] = s2[7];
        k2[5] = s2[4];
        k2[6] = s2[9];
        k2[7] = s2[8];
    }

    private byte[] initialPermute(byte[] set){
        byte[] newSet = new byte[8];
        newSet[0] = set[1];
        newSet[1] = set[5];
        newSet[2] = set[2];
        newSet[3] = set[0];
        newSet[4] = set[3];
        newSet[5] = set[7];
        newSet[6] = set[4];
        newSet[7] = set[6];

        return newSet;
    }

    private byte[] finalPermute(byte[] set){
        byte[] newSet = new byte[8];
        newSet[0] = set[3];
        newSet[1] = set[0];
        newSet[2] = set[2];
        newSet[3] = set[4];
        newSet[4] = set[6];
        newSet[5] = set[1];
        newSet[6] = set[7];
        newSet[7] = set[5];

        return newSet;
    }

    private byte[] switchHalves(byte[] set){
        byte[] newSet = new byte[8];
        newSet[0] = set[4];
        newSet[1] = set[5];
        newSet[2] = set[6];
        newSet[3] = set[7];
        newSet[4] = set[0];
        newSet[5] = set[1];
        newSet[6] = set[2];
        newSet[7] = set[3];

        return newSet;
    }

    private byte[] applyKey(byte[] set, byte[] key){
        byte[] newSet = new byte[8];
        for(int i = 0; i < 8; i++)
            newSet[i] = set[i];

        byte[] temp = new byte[8];
        temp[0] = set[7];
        temp[1] = set[4];
        temp[2] = set[5];
        temp[3] = set[6];
        temp[4] = set[5];
        temp[5] = set[6];
        temp[6] = set[7];
        temp[7] = set[4];

        for(int i = 0; i < 8; i++)
            temp[i] = (byte)(temp[i] ^ key[i]);

        byte row = (byte)(temp[0] * 2 + temp[3]);
        byte col = (byte)(temp[1] * 2 + temp[2]);

        byte value = sBox1[row][col];

        temp[0] = (byte)(value / 2);
        temp[1] = (byte)(value % 2);

        row = (byte)(temp[4] * 2 + temp[7]);
        col = (byte)(temp[5] * 2 + temp[6]);

        value = sBox2[row][col];

        temp[2] = (byte)(value / 2);
        temp[3] = (byte)(value % 2);

        byte[] temp2 = new byte[4];
        temp2[0] = temp[1];
        temp2[1] = temp[3];
        temp2[2] = temp[2];
        temp2[3] = temp[0];

        for(int i = 0; i < 4; i++)
            newSet[i] = (byte)(set[i] ^ temp2[i]);

        return newSet;
    }
}