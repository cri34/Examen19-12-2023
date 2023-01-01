public class NumerosRomanos {
    final int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};
    final char[] romanNumbers = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    private int returnRNValue(int ind) {
        return romanValues[ind];
    }

    private int retIndRN(char letra) {
        int i = 0;
        for (i = 0; i < romanNumbers.length; i++)
            if (letra == romanNumbers[i])
                break;
        return i;
    }

    private boolean checkValidIndNumToSubs(String rn, int ind) {
        int maxInterval = 2;
        for (int i = 1; i <= maxInterval; i++) {
            if (romanNumbers[retIndRN(rn.charAt(ind - 1)) + i] == rn.charAt(ind)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkValidToSubs(String rn, int index) {
        final int fPos = 0;
        char[] possibleNumToSubs = {'I', 'X', 'C', 'M'};
        if (index <= fPos)
            return false;
        if (returnRNValue( retIndRN( rn.charAt(index) ) ) > returnRNValue( retIndRN( rn.charAt(index - 1) ) ) ) {
            for (int i = 0; i < possibleNumToSubs.length; i++) {
                if (rn.charAt(index - 1) == possibleNumToSubs[i]) {
                    return checkValidIndNumToSubs(rn, index);
                }
            }
        }
        return false;
    }

    private boolean checkRNB5(char rn) {
        char[] rnB5 = {'V', 'L', 'D'};
        for (int i = 0; i < rnB5.length; i++) {
            if (rn == rnB5[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIsRNValid(char rn) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (rn == romanNumbers[i]) {
                return true;
            }
        }
        return false;
    }
    private boolean checkValidOrderRomNum(String rn) {
        final int lastPos = rn.length() - 1;
        final int penulPos = rn.length() - 2;
        final int twoChars=2;
        final int lastNumAftSubst = rn.length() - 3;
        final int resta = returnRNValue( retIndRN( rn.charAt(lastPos) ) ) - returnRNValue( retIndRN( rn.charAt(penulPos) ) );
        for (int k = 0; k < lastPos; k++) {
            if (returnRNValue( retIndRN ( rn.charAt(k) ) ) < returnRNValue( retIndRN( rn.charAt(k + 1) ) ) && !(k + 1 == lastPos && checkValidToSubs(rn, lastPos) ) ) {
                return false;
            }
        }
        if (rn.length() > twoChars)
            if (checkValidToSubs(rn, lastPos))
                if (returnRNValue( retIndRN( rn.charAt(lastNumAftSubst) ) ) < resta)
                    return false;

        return true;
    }

    private boolean checkIsRNTextValid(String rn) {
        for (int i = 0; i < rn.length(); i++) {
            if (!checkIsRNValid(rn.charAt(i))) {
                return false;

            }
        }
        return true;
    }
//
    public boolean validToConvert(String rn) {
        final int rnCharsLenght=7;
        boolean [] rnViewed = new boolean [rnCharsLenght];
        final int maxSeqRomNum = 3, maxSeqB5RomNum = 1;
        final int lastPos= rn.length() - 1;
        int maxSeq;
        int count = 0;
        if (rn.length() < 1 || !checkIsRNTextValid(rn) || !checkValidOrderRomNum(rn))
            return false;
        for (int i = 0; i < rn.length(); i++) {
            if ( rnViewed[ retIndRN( rn.charAt(i) ) ])
                continue;
            maxSeq = (checkRNB5(rn.charAt(i))) ? maxSeqB5RomNum : maxSeqRomNum;
            for (int e = lastPos; e >= 0; e--) {
                if (rn.charAt(e) == rn.charAt(i)) {
                    if (e == lastPos)
                        if (checkValidToSubs(rn, e))
                            continue;
                    count++;
                    if (count > maxSeq)
                        return false;
                }
            }
            rnViewed[ retIndRN( rn.charAt(i) ) ]=true;
            count = 0;
        }
        return true;
    }

    public int convertRomanNumberToDecimalNumber(String rn) {
        int conversion = 0;
        final int firPos = 0;
        if (rn.length() == 1)
            if (checkIsRNValid(rn.charAt(firPos)))
                return returnRNValue( retIndRN( rn.charAt(firPos) ) );

        if (!validToConvert(rn)) {
            System.out.println("RomanNumberInvalid");
            return conversion;
        }
        for (int i = rn.length() - 1; i >= firPos; i--) {
            if (checkValidToSubs(rn, i)) {
                conversion += returnRNValue( retIndRN( rn.charAt(i) ) ) - returnRNValue( retIndRN( rn.charAt(i - 1) ) );
                i--;
                continue;
            }
            conversion += returnRNValue(retIndRN(rn.charAt(i)));
        }
        return conversion;
    }
}
