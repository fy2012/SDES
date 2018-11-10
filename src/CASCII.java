public class CASCII {

    public CASCII() {
    }

    public static String toString( byte[] pt ) {
        char output[] = new char[pt.length/5];

        for ( int block = 0; block < pt.length; block += 5 )
            if ( block + 5 <= pt.length )
                output[block/5] = CASCII.Convert(pt, block, block+4);

        return new String(output);
    }

    public static char Convert( byte[] bits, int x, int y)
    {
        int CharCode = 0;
        for ( int i = x; i <= y; i++)
            CharCode += java.lang.Math.pow(2, i-x) * bits[i];

        if(CharCode > 0 && CharCode < 27)
            return (char)(CharCode + 64);

        if(CharCode == 0)
            return ' ';
        if(CharCode == 27)
            return ',';
        if(CharCode == 28)
            return '?';
        if(CharCode == 29)
            return ':';
        if(CharCode == 30)
            return '.';
        if(CharCode == 31)
            return '\'';

        return 0;
    }

    public static byte[] Convert(String str ) {
        byte pt[] = new byte[str.length()];
        byte character;
        for ( int i=0; i < str.length(); i++) {
            character = (byte)str.charAt(i);
            if(character > 64 && character < 91)
                character -= 64;
            if(character == 32)
                character = 0;
            if(character == 44)
                character = 27;
            if(character == 63)
                character = 28;
            if(character == 58)
                character = 29;
            if(character == 46)
                character = 30;
            if(character == 39)
                character = 31;
            pt[i] = character;
        }

        int size = 5 * str.length();
        size = size + ( 8 - (size % 8) );
        byte bits[] = new byte[size];
        for ( int i = 0; i < bits.length; i++) {
            bits[i] = 0;
        }

        byte bit;
        for ( int j = 0; j < pt.length; j++) {
            bit = pt[j];
            for (int i = 0; bit != 0; i++) {
                if (bit % 2 == 0)
                    bits[j*5 + i] = 0;
                else
                    bits[j*5 + i] = 1;
                bit /= 2;
            }
        }
        return bits;
    }
}