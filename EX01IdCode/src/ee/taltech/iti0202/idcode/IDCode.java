package ee.taltech.iti0202.idcode;

public class IDCode {
    private enum Gender {
        MALE, FEMALE
    }

    public static boolean isIDCodeCorrect(String idCode) {
        final int IDCODE_LENGTH = 11;
        return idCode.length() == IDCODE_LENGTH && isGenderNumberCorrect(idCode) && isYearNumberCorrect(idCode)
                && isMonthNumberCorrect(idCode) && isDayNumberCorrect(idCode) && isQueueNumberCorrect(idCode)
                && isControlNumberCorrect(idCode);
    }

    private static boolean isGenderNumberCorrect(String idCode) {
        int gendernumber = Integer.parseInt(idCode.substring(0, 1));
        final int MAX_GENDER = 6;
        return 0 < gendernumber && gendernumber <= MAX_GENDER;
    }

    private static boolean isYearNumberCorrect(String idCode) {
        int yearnumber = Integer.parseInt(idCode.substring(1, 3));
        final int NIL = 0;
        final int MAX_YEAR = 99;
        return NIL <= yearnumber && yearnumber <= MAX_YEAR;
    }

    private static boolean isMonthNumberCorrect(String idCode) {
        int monthnumber = Integer.parseInt(idCode.substring(3, 5));
        final int NIL = 0;
        final int MAX_MONTH = 12;
        return NIL < monthnumber && monthnumber <= MAX_MONTH;
    }

    private static boolean isDayNumberCorrect(String idCode) {
        final int JANUARY = 1;
        final int FEBRUARY = 2;
        final int MARCH = 3;
        final int APRIL = 4;
        final int MAY = 5;
        final int JUNE = 6;
        final int JULY = 7;
        final int AUGUST = 8;
        final int SEPTEMBER = 9;
        final int OCTOBER = 10;
        final int NOVEMBER = 11;
        final int DECEMBER = 12;
        final int NIL = 0;
        final int REGULAR_FEB = 28;
        final int LEAP_YEAR_FEB = 29;
        final int THIRTY = 30;
        final int THIRTY_ONE = 31;
        final int Seven = 7;
        int month = Integer.parseInt(idCode.substring(3, 5));
        int day = Integer.parseInt(idCode.substring(5, Seven));
        return ((month == JANUARY || month == MARCH || month == MAY || month == JULY || month == AUGUST
                || month == OCTOBER || month == DECEMBER) && NIL < day && day <= THIRTY_ONE)
                || ((month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
                && NIL < day && day <= THIRTY) || (month == FEBRUARY && NIL < day && day <= REGULAR_FEB)
                || (isLeapYear(getFullYear(idCode)) && (month == FEBRUARY) && (NIL < day) && (day <= LEAP_YEAR_FEB));
    }

    private static boolean isQueueNumberCorrect(String idCode) {
        final int magic_number_seven = 7;
        int queuenumber = Integer.parseInt(idCode.substring(magic_number_seven, 10));
        return 0 < queuenumber;
    }

    private static boolean isControlNumberCorrect(String idCode) {
        final int MODULA = 11;
        final int six = 6;
        final int seven = 7;
        final int eight = 8;
        final int nine = 9;
        int[] multipliers1 = {1, 2, 3, 4, 5, six, seven, eight, nine, 1};
        int[] multipliers2 = {3, 4, 5, six, seven, eight, nine, 1, 2, 3};
        int controlnr = Integer.parseInt(idCode.substring(10));
        String[] idcodenrs = idCode.split("");
        int sum = 0;
        for (int j = 0; j < 10; j++) {
            sum += Integer.parseInt(idcodenrs[j]) * multipliers1[j];
        }
        if (sum % MODULA == 10) {
            sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += Integer.parseInt(idcodenrs[j]) * multipliers2[j];
            }
            return sum % MODULA == controlnr;
        }
        return sum % MODULA == controlnr;
    }

    private static boolean isLeapYear(int fullYear) {
        final int FOUR_HUNDRED = 400;
        final int HUNDRED = 100;
        final int FOUR = 4;
        final int NIL = 0;
        return fullYear % FOUR_HUNDRED == NIL || fullYear % HUNDRED != NIL && fullYear % FOUR == NIL;
    }

    public static String getInformationFromIDCode(String idCode) {
        if (isIDCodeCorrect(idCode)) {
            String gender = "female";
            final int seven = 7;
            String day = idCode.substring(5, seven);
            String month = idCode.substring(3, 5);
            int year = getFullYear(idCode);
            if (getGender(idCode) == Gender.MALE) gender = "male";
            return "This is a " + gender + " born on " + day + "." + month + "." + year;
        }
        return "Given invalid ID code!";
    }

    public static Gender getGender(String idCode) {
        final int TWO = 2;
        int gendernumber = Integer.parseInt(idCode.substring(0, 1));
        if (isGenderNumberCorrect(idCode)) {
            if (gendernumber % TWO == 0) return Gender.FEMALE;
            else return Gender.MALE;
        }
        return null;
    }

    public static int getFullYear(String idCode) {
        final int TWO = 2;
        final int FIVE = 5;
        final int EIGHTEEN_HUNDRED = 1800;
        final int NINETEEN_HUNDRED = 1900;
        final int TWO_THOUSAND = 2000;
        int gendernumber = Integer.parseInt(idCode.substring(0, 1));
        int yearnumber = Integer.parseInt(idCode.substring(1, 3));
        if (isYearNumberCorrect(idCode) && isGenderNumberCorrect(idCode)) {
            if (gendernumber <= TWO) {
                return EIGHTEEN_HUNDRED + yearnumber;
            }
            if (gendernumber >= FIVE) {
                return TWO_THOUSAND + yearnumber;
            }
            return NINETEEN_HUNDRED + yearnumber;
        }
        return 0;
    }
    public static void main(String[] args) {
        // static method we can call directly from static method (main)
        System.out.println(getInformationFromIDCode("39708060036"));
        System.out.println(isControlNumberCorrect("39708060036"));
        System.out.println(isIDCodeCorrect("39708062020"));
    }
}
