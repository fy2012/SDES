public class Main {
    public static void main(String[] args){
        System.out.println("Test cases:");
        System.out.println("Raw Key\t\tPlain Text\tCipher Text");

        SDES test1 = new SDES(new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new byte[]{ 1, 0, 1, 0, 1, 0, 1, 0 }, "Encrypt");
        printResult(test1.getKey(), test1.getPlaintext(), test1.getCiphertext());
        SDES test2 = new SDES(new byte[]{ 1, 1, 1, 0, 0, 0, 1, 1, 1, 0 }, new byte[]{ 1, 0, 1, 0, 1, 0, 1, 0 }, "Encrypt");
        printResult(test2.getKey(), test2.getPlaintext(), test2.getCiphertext());
        SDES test3 = new SDES(new byte[]{ 1, 1, 1, 0, 0, 0, 1, 1, 1, 0 }, new byte[]{ 0, 1, 1, 1, 0, 0, 0, 0 }, "Decrypt");
        printResult(test3.getKey(), test3.getPlaintext(), test3.getCiphertext());
        SDES test4 = new SDES(new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, new byte[]{ 0, 0, 0, 0, 0, 1, 0, 0 }, "Decrypt");
        printResult(test4.getKey(), test4.getPlaintext(), test4.getCiphertext());

        System.out.println("\n\nAnswers to part 1:");
        System.out.println("Raw Key\t\tPlain Text\tCipher Text");
        SDES problem_a = new SDES(new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 }, "Encrypt");
        SDES problem_b = new SDES(new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 }, "Encrypt");
        SDES problem_c = new SDES(new byte[]{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 }, "Encrypt");
        SDES problem_d = new SDES(new byte[]{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 }, "Encrypt");
        SDES problem_e = new SDES(new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 0, 0, 0, 1, 1, 1, 0, 0 }, "Decrypt");
        SDES problem_f = new SDES(new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 1, 1, 0, 0, 0, 0, 1, 0 }, "Decrypt");
        SDES problem_g = new SDES(new byte[]{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 }, new byte[]{ 1, 0, 0, 1, 1, 1, 0, 1 }, "Decrypt");
        SDES problem_h = new SDES(new byte[]{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 }, new byte[]{ 1, 0, 0, 1, 0, 0, 0, 0 }, "Decrypt");

        printResult(problem_a.getKey(), problem_a.getPlaintext(), problem_a.getCiphertext());
        printResult(problem_b.getKey(), problem_b.getPlaintext(), problem_b.getCiphertext());
        printResult(problem_c.getKey(), problem_c.getPlaintext(), problem_c.getCiphertext());
        printResult(problem_d.getKey(), problem_d.getPlaintext(), problem_d.getCiphertext());
        printResult(problem_e.getKey(), problem_e.getPlaintext(), problem_e.getCiphertext());
        printResult(problem_f.getKey(), problem_f.getPlaintext(), problem_f.getCiphertext());
        printResult(problem_g.getKey(), problem_g.getPlaintext(), problem_g.getCiphertext());
        printResult(problem_h.getKey(), problem_h.getPlaintext(), problem_h.getCiphertext());

        System.out.println("\n\nAnswers to part 2:");
        System.out.println("RawKey1\t\tRawKey2\t\tPlaintext\tCiphertext");
        TripleSDES problem_i = new TripleSDES(new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 }, "Encrypt");
        TripleSDES problem_j = new TripleSDES(new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 1, 1, 0, 1, 0, 1, 1, 1 }, "Encrypt");
        TripleSDES problem_k = new TripleSDES(new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 1, 0, 1, 0, 1, 0, 1, 0 }, "Encrypt");
        TripleSDES problem_l = new TripleSDES(new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, new byte[]{ 1, 0, 1, 0, 1, 0, 1, 0 }, "Encrypt");
        TripleSDES problem_m = new TripleSDES(new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 1, 1, 1, 0, 0, 1, 1, 0 }, "Decrypt");
        TripleSDES problem_n = new TripleSDES(new byte[]{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, new byte[]{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 0, 1, 0, 1, 0, 0, 0, 0 }, "Decrypt");
        TripleSDES problem_o = new TripleSDES(new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new byte[]{ 1, 0, 0, 0, 0, 0, 0, 0 }, "Decrypt");
        TripleSDES problem_p = new TripleSDES(new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, new byte[]{ 1, 0, 0, 1, 0, 0, 1, 0 }, "Decrypt");

        printx3Result(problem_i.getRawkey1(), problem_i.getRawkey2(), problem_i.getPlaintext(), problem_i.getCiphertext());
        printx3Result(problem_j.getRawkey1(), problem_j.getRawkey2(), problem_j.getPlaintext(), problem_j.getCiphertext());
        printx3Result(problem_k.getRawkey1(), problem_k.getRawkey2(), problem_k.getPlaintext(), problem_k.getCiphertext());
        printx3Result(problem_l.getRawkey1(), problem_l.getRawkey2(), problem_l.getPlaintext(), problem_l.getCiphertext());
        printx3Result(problem_m.getRawkey1(), problem_m.getRawkey2(), problem_m.getPlaintext(), problem_m.getCiphertext());
        printx3Result(problem_n.getRawkey1(), problem_n.getRawkey2(), problem_n.getPlaintext(), problem_n.getCiphertext());
        printx3Result(problem_o.getRawkey1(), problem_o.getRawkey2(), problem_o.getPlaintext(), problem_o.getCiphertext());
        printx3Result(problem_p.getRawkey1(), problem_p.getRawkey2(), problem_p.getPlaintext(), problem_p.getCiphertext());

        System.out.println("\n\nAnswers to part 3:\n#1.");
        SDES problem_q = new SDES(new byte[]{ 0, 1, 1, 1, 0, 0, 1, 1, 0, 1 }, CASCII.Convert("CRYPTOGRAPHY"), "Encrypt");
        for(int i : problem_q.getCiphertext())
            System.out.print(problem_q.getCiphertext()[i]);

        byte[] message1 = { 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1,
                0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1,
                1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1,
                0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1,
                1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0,
                1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1,
                0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0,
                1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1,
                0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0,
                0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0,
                1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1,
                0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1,
                0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0,
                1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0,
                0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0,
                1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0,
                1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0,
                1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0,
                0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1,
                0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1,
                1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,
                0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1,
                0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1,
                0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1,
                1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1,
                1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1};

        byte[] key = Crack.getKey(message1);
        SDES problem_r = new SDES(key, message1, "Decrypt");
        System.out.println("\n\n#2.");
        System.out.print("Key: ");
        for(int i = 0; i < key.length; i++)
            System.out.print(key[i]);
        System.out.println('\n' + CASCII.toString(problem_r.getPlaintext()));

        byte[] message2 = { 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0,
                0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0,
                0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1,
                1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1,
                1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0,
                1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0,
                0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,
                0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0,
                0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0,
                1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0};

        System.out.println("\n\n#3.");
        System.out.print("Key1: ");
        byte[] k1 = new byte[10];
        byte[] k2 = new byte[10];
        byte[] key1_and_2 = Crack.getKey1_and_2(message2);
        for(int i = 0; i < key1_and_2.length; i++) {
            System.out.print(key1_and_2[i]);
            if(i < 10)
                k1[i] = key1_and_2[i];
            if(i == 9)
                System.out.print("\nKey2: ");
            if(i > 9)
                k2[i-10] = key1_and_2[i];
        }
        TripleSDES problem_s = new TripleSDES(k1, k2, message2, "Decrypt");
        System.out.println('\n' + CASCII.toString(problem_s.getPlaintext()));
    }

    public static void  printResult(byte[] k, byte[] p, byte[] c){
        for(int i = 0; i < k.length; i++) {
            System.out.print(k[i]);
        }
        System.out.print('\t');
        for(int i = 0; i < p.length; i++) {
            System.out.print(p[i]);
        }
        System.out.print('\t');
        for(int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println();
    }

    public static void  printx3Result(byte[] k, byte[] k2, byte[] p, byte[] c){
        for(int i = 0; i < k.length; i++) {
            System.out.print(k[i]);
        }
        System.out.print('\t');
        for(int i = 0; i < k2.length; i++) {
            System.out.print(k2[i]);
        }
        System.out.print('\t');
        for(int i = 0; i < p.length; i++) {
            System.out.print(p[i]);
        }
        System.out.print('\t');
        for(int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println();
    }
}
