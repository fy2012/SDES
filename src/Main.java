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

        System.out.println("\n\nAnswers to number 1:");
        System.out.println("Raw Key\t\tPlain Text\tCipher Text");
        SDES peoblem_a = new SDES(new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 }, "Encrypt");
        SDES peoblem_b = new SDES(new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 }, "Encrypt");
        SDES peoblem_c = new SDES(new byte[]{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 }, "Encrypt");
        SDES peoblem_d = new SDES(new byte[]{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 }, "Encrypt");
        SDES peoblem_e = new SDES(new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 0, 0, 0, 1, 1, 1, 0, 0 }, "Decrypt");
        SDES peoblem_f = new SDES(new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[]{ 1, 1, 0, 0, 0, 0, 1, 0 }, "Decrypt");
        SDES peoblem_g = new SDES(new byte[]{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 }, new byte[]{ 1, 0, 0, 1, 1, 1, 0, 1 }, "Decrypt");
        SDES peoblem_h = new SDES(new byte[]{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 }, new byte[]{ 1, 0, 0, 1, 0, 0, 0, 0 }, "Decrypt");

        printResult(peoblem_a.getKey(), peoblem_a.getPlaintext(), peoblem_a.getCiphertext());
        printResult(peoblem_b.getKey(), peoblem_b.getPlaintext(), peoblem_b.getCiphertext());
        printResult(peoblem_c.getKey(), peoblem_c.getPlaintext(), peoblem_c.getCiphertext());
        printResult(peoblem_d.getKey(), peoblem_d.getPlaintext(), peoblem_d.getCiphertext());
        printResult(peoblem_e.getKey(), peoblem_e.getPlaintext(), peoblem_e.getCiphertext());
        printResult(peoblem_f.getKey(), peoblem_f.getPlaintext(), peoblem_f.getCiphertext());
        printResult(peoblem_g.getKey(), peoblem_g.getPlaintext(), peoblem_g.getCiphertext());
        printResult(peoblem_h.getKey(), peoblem_h.getPlaintext(), peoblem_h.getCiphertext());

        System.out.println("\n\nAnswers to number 2:");
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
