package ee.taltech.iti0202.cpu;

import java.util.HashMap;
import java.util.Map;

public class Cpu {
    final int COMPARENUMBER = 6;
    public static Map<String, Integer> compute(String instructions) {
        String[] allData = instructions.split("\n");
        Map<String, Integer> registers = new HashMap<>();
        for (String data: allData) {
            String[] data1 = data.split(" ");
            String registerToDoStuffWith = data1[0];
            int numberToDoStuffWith = Integer.parseInt(data1[2]);
            String registerToCompare = data1[4];
            String compareAction = data1[5];
            int compareNumber = Integer.parseInt(data1[COMPARENUMBER]);
            String incOrDec = data1[1];
            registers.putIfAbsent(registerToDoStuffWith, 0);
            registers.putIfAbsent(registerToCompare, 0);
            if (isTrue(registers, registerToCompare, compareAction, compareNumber)) {
                if (incOrDec.equals("dec")) numberToDoStuffWith = -numberToDoStuffWith;
                registers.put(registerToDoStuffWith, registers.get(registerToDoStuffWith) + numberToDoStuffWith);
            }
        }
        return registers;
    }

    private static boolean isTrue(Map<String, Integer> registers, String register, String action, int number) {
        switch (action) {
            case "==":
                return registers.get(register) == (number);
            case ">":
                return registers.get(register) > number;
            case "<":
                return registers.get(register) < number;
            case "<=":
                return registers.get(register) <= number;
            case ">=":
                return registers.get(register) >= number;
            case "!=":
                return registers.get(register) != number;
            default:
                return true;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> res = compute(
                "b inc 5 if a > 1\n"
                        + "a inc 1 if b < 5\n"
                        + "c dec -10 if a >= 1\n"
                        + "c inc -20 if c == 10"
        );
        System.out.println(res); // {a=1, b=0, c=-10}

        res = compute(
                "b inc 7 if a > 4\n"
                        + "a inc 1 if c < 13\n"
                        + "c dec -10 if a >= 1\n"
                        + "c inc -20 if c == 10\n"
                        + "abc inc 100 if a != -23\n"
                        + "a inc 2 if a <= 0"
        );
        System.out.println(res); // {a=1, b=0, c=-10, abc=100}
    }

}
