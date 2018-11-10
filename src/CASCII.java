public class CASCII {
    private static byte Space = 0;
    private static byte A = 1;
    private static byte B = 2;
    private static byte C = 3;
    private static byte D = 4;
    private static byte E = 5;
    private static byte F = 6;
    private static byte G = 7;
    private static byte H = 8;
    private static byte I = 9;
    private static byte J = 10;
    private static byte K = 11;
    private static byte L = 12;
    private static byte M = 13;
    private static byte N = 14;
    private static byte O = 15;
    private static byte P = 16;
    private static byte Q = 17;
    private static byte R = 18;
    private static byte S = 19;
    private static byte T = 20;
    private static byte U = 21;
    private static byte V = 22;
    private static byte W = 23;
    private static byte X = 24;
    private static byte Y = 25;
    private static byte Z = 26;
    private static byte Comma = 27;
    private static byte Question = 28;
    private static byte Colon = 29;
    private static byte Period = 30;
    private static byte Apostrophe = 31;

    public CASCII() {
    }

    public static byte Convert(char Char) {
        if (Char == 'A')
            return A;

        if (Char == 'B')
            return B;

        if (Char == 'C')
            return C;

        if (Char == 'D')
            return D;

        if (Char == 'E')
            return E;

        if (Char == 'F')
            return F;

        if (Char == 'G')
            return G;

        if (Char == 'H')
            return H;

        if (Char == 'I')
            return I;

        if (Char == 'J')
            return J;

        if (Char == 'K')
            return K;

        if (Char == 'L')
            return L;

        if (Char == 'M')
            return M;

        if (Char == 'N')
            return N;

        if (Char == 'O')
            return O;

        if (Char == 'P')
            return P;

        if (Char == 'Q')
            return Q;

        if (Char == 'R')
            return R;

        if (Char == 'S')
            return S;

        if (Char == 'T')
            return T;

        if (Char == 'U')
            return U;

        if (Char == 'V')
            return V;

        if (Char == 'W')
            return W;

        if (Char == 'X')
            return X;

        if (Char == 'Y')
            return Y;

        if (Char == 'Z')
            return Z;

        if (Char == '?')
            return Question;

        if (Char == '\'')
            return Apostrophe;

        if (Char == ':')
            return Colon;

        if (Char == ',')
            return Comma;

        if (Char == '.')
            return Period;

        if (Char == ' ')
            return Space;

        return '0';
    }



    public static char Convert( byte[] bits, int start, int end)
    {
        int val = 0;
        for ( int i = start; i <= end; i++){
            val += java.lang.Math.pow(2, i-start) * bits[i];
        }

        switch ( val )
        {
            case 0:
                return ' ';
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            case 9:
                return 'I';
            case 10:
                return 'J';
            case 11:
                return 'K';
            case 12:
                return 'L';
            case 13:
                return 'M';
            case 14:
                return 'N';
            case 15:
                return 'O';
            case 16:
                return 'P';
            case 17:
                return 'Q';
            case 18:
                return 'R';
            case 19:
                return 'S';
            case 20:
                return 'T';
            case 21:
                return 'U';
            case 22:
                return 'V';
            case 23:
                return 'W';
            case 24:
                return 'X';
            case 25:
                return 'Y';
            case 26:
                return 'Z';
            case 27:
                return ',';
            case 28:
                return '?';
            case 29:
                return ':';
            case 30:
                return '.';
            case 31:
                return '\'';

            default:
                throw new java.lang.IllegalArgumentException("Argument must be be on interval [0, 31]");
        }
    }

    public static byte[] Convert( char[] text )
    {
        byte out[] = new byte[text.length];

        for ( int i = 0; i < text.length; i ++ )
        {
            out[i] = Convert(text[i]);
        }

        return out;
    }

    public static byte[] Convert( String s )
    {
        byte cas[] = new byte[s.length()];

        for ( int i=0; i < s.length(); i++)
        {
            cas[i] = CASCII.Convert(s.charAt(i));
        }

        int size = 5 * s.length();
        size = size + ( 8 - (size % 8) );
        byte bits[] = new byte[size];
        for ( int i = 0; i < bits.length; i++)
        {
            bits[i] = 0;
        }

        byte b;
        for ( int j = 0; j < cas.length; j++)
        {
            b = cas[j];
            for (int i = 0; b != 0; i++) {
                if (b % 2 == 0) {
                    bits[j*5 + i] = 0;
                }
                else {
                    bits[j*5 + i] = 1;
                }

                b /= 2;
            }
        }

        return bits;
    }

    public static String toString( byte[] cas )
    {
        char output[] = new char[cas.length/5];

        for ( int block = 0; block < cas.length; block += 5 )
        {
            if ( block + 5 > cas.length ) break;

            output[block/5] = CASCII.Convert(cas, block, block+4);
        }

        return new String(output);
    }
}