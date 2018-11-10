public class Crack {

    public Crack(){
    }

    public static byte[] getKey(byte[] message){
        byte[] key = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        byte[] plaintext;

        for(int bit_9 = 0; bit_9 < 2; bit_9++) {
            key[0] = (byte)bit_9;
            for (int bit_8 = 0; bit_8 < 2; bit_8++) {
                key[1] = (byte)bit_8;
                for (int bit_7 = 0; bit_7 < 2; bit_7++) {
                    key[2] = (byte)bit_7;
                    for (int bit_6 = 0; bit_6 < 2; bit_6++) {
                        key[3] = (byte)bit_6;
                        for (int bit_5 = 0; bit_5 < 2; bit_5++) {
                            key[4] = (byte)bit_5;
                            for (int bit_4 = 0; bit_4 < 2; bit_4++) {
                                key[5] = (byte)bit_4;
                                for (int bit_3 = 0; bit_3 < 2; bit_3++) {
                                    key[6] = (byte)bit_3;
                                    for (int bit_2 = 0; bit_2 < 2; bit_2++) {
                                        key[7] = (byte)bit_2;
                                        for (int bit_1 = 0; bit_1 < 2; bit_1++) {
                                            key[8] = (byte)bit_1;
                                            for (int bit_0 = 0; bit_0 < 2; bit_0++) {
                                                key[9] = (byte)bit_0;
                                                plaintext = new SDES(key, message, "Decrypt").getPlaintext();
                                                String str = CASCII.toString(plaintext);
                                                if (str.contains(" THE ")||str.contains(" AND ")){
                                                    return key;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return key;
    }

    public static byte[] getKey1_and_2(byte[] message) {
        byte[] key = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        byte[] k1 = new byte[10];
        byte[] k2 = new byte[10];
        byte[] plaintext;

        for (int bit_0 = 0; bit_0 < 2; bit_0++) {
            key[0] = (byte) bit_0;
            for (int bit_1 = 0; bit_1 < 2; bit_1++) {
                key[1] = (byte) bit_1;
                for (int bit_2 = 0; bit_2 < 2; bit_2++) {
                    key[2] = (byte) bit_2;
                    for (int bit_3 = 0; bit_3 < 2; bit_3++) {
                        key[3] = (byte) bit_3;
                        for (int bit_4 = 0; bit_4 < 2; bit_4++) {
                            key[4] = (byte) bit_4;
                            for (int bit_5 = 0; bit_5 < 2; bit_5++) {
                                key[5] = (byte) bit_5;
                                for (int bit_6 = 0; bit_6 < 2; bit_6++) {
                                    key[6] = (byte) bit_6;
                                    for (int bit_7 = 0; bit_7 < 2; bit_7++) {
                                        key[7] = (byte) bit_7;
                                        for (int bit_8 = 0; bit_8 < 2; bit_8++) {
                                            key[8] = (byte) bit_8;
                                            for (int bit_9 = 0; bit_9 < 2; bit_9++) {
                                                key[9] = (byte) bit_9;
                                                for (int bit_10 = 0; bit_10 < 2; bit_10++) {
                                                    key[10] = (byte) bit_10;
                                                    for (int bit_11 = 0; bit_11 < 2; bit_11++) {
                                                        key[11] = (byte) bit_11;
                                                        for (int bit_12 = 0; bit_12 < 2; bit_12++) {
                                                            key[12] = (byte) bit_12;
                                                            for (int bit_13 = 0; bit_13 < 2; bit_13++) {
                                                                key[13] = (byte) bit_13;
                                                                for (int bit_14 = 0; bit_14 < 2; bit_14++) {
                                                                    key[14] = (byte) bit_14;
                                                                    for (int bit_15 = 0; bit_15 < 2; bit_15++) {
                                                                        key[15] = (byte) bit_15;
                                                                        for (int bit_16 = 0; bit_16 < 2; bit_16++) {
                                                                            key[16] = (byte) bit_16;
                                                                            for (int bit_17 = 0; bit_17 < 2; bit_17++) {
                                                                                key[17] = (byte) bit_17;
                                                                                for (int bit_18 = 0; bit_18 < 2; bit_18++) {
                                                                                    key[18] = (byte) bit_18;
                                                                                    for (int bit_19 = 0; bit_19 < 2; bit_19++) {
                                                                                        key[19] = (byte) bit_19;
                                                                                        k1 = getSubArray(key, 0, 10);
                                                                                        k2 = getSubArray(key, 10, 20);

                                                                                        plaintext = new TripleSDES(k1, k2, message, "Decrypt").getPlaintext();
                                                                                        String str = CASCII.toString(plaintext);
                                                                                        if (str.contains(" ARE ") && str.contains(" THE ")){
                                                                                           //System.out.println('\n' + str + '\n');
                                                                                            //for(int i = 0; i < key.length; i++) {
                                                                                            //    System.out.print(key[i]);
                                                                                            //}
                                                                                            return key;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return key;
    }

    private static byte[] getSubArray(byte[] a, int x, int y) {
        byte[] subArray = new byte[y - x];
        int index = 0;
        for (int i = x; i < y; i++) {
            subArray[index] = a[i];
            index++;
        }
        return subArray;
    }
}