/*
     * 66661 MOHAMAD HAIDIL BIN IDRIS
     * 66783 MUHAMMAD AIMAN BIN MOHD AZMI
     * 67872 SYAZZWA NATASYA BINTI MOHD ZAIDI
     * 66477 LIM AI XIN
     * 64631 AMNAH NADIAH BINTI SUFIAN
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;
//both of these use for validation method

public class SecretCode {
    private String inString;
    private int stringLen;
    private String outString;

    SecretCode() {
        inString = null;
        stringLen = 0;
        outString = null;
    }

    public SecretCode(String inString) {
        this.inString = inString;
    }

    public void setInString(String inString) {
        this.inString = inString;
    }

    //use to calculate the number of character inside the string
    public int getStringLen(String inString) {
        stringLen = 0;

        for (int n = 0; n < inString.length(); n++) {
            if (inString.charAt(n) != ' ')
                stringLen++;
        }
        return stringLen;
    }

    //use to check if the string is valid or not (only lowercase letter and whitespace accepted)
    public boolean checkStringValidity(String inString) {
        String re = "[a-z ]+";

        Pattern pt = Pattern.compile(re);
        Matcher mt = pt.matcher(inString);

        return mt.matches();
    }

    //use to shifting character
    public String ShiftChar(String inString, int stringLen) {

        int spaceCount = 0;
        char[] inStringArray = inString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        final char[] chars = {
                'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', ' '
        };

        // used to count how many whitespace in string
        for (char c : inStringArray) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        for (int i = 0; i < stringLen + spaceCount; i++)
        {
            for (int j = 0; j < 27; j++)
            {
                if (inStringArray[i] == chars[j])
                {

                    // added to include whitespace in algorithm
                    int fixedchar = j + stringLen;

                    if (fixedchar >= 27) fixedchar -= 27;

                    stringBuilder.append(chars[fixedchar]);
                }
            }
        }

        outString = stringBuilder.toString();
        return outString;
    }
}