package ee.taltech.iti0202.sum100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sum100 {

    public static List<String> generateAll(int subs) {
        List<String> newList = new ArrayList<>();
        if (subs == 9) {
            newList.add("123456789");
            return newList;
        } else {
            newList = generateAll(subs + 1);
            List<String> anotherList = new ArrayList<>(newList);
            for (String el : newList) {
                anotherList.add(el.substring(0, subs) + "+" + el.substring(subs));
                anotherList.add(el.substring(0, subs) + "+-" + el.substring(subs));
            }
            return anotherList;
        }
    }

    public static List<String> doMaths(List<String> operations) {
        if (operations.size() == 1) {
            String operation = operations.get(0);
            List<String> numbers = Arrays.asList(operation.split("\\+"));
            List<Integer> numbers2 = numbers.stream().mapToInt(Integer::parseInt).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public static List<String> calcSums() {
        List<String> possibilities = generateAll(1);
        System.out.println(possibilities);
        return doMaths(possibilities);
    }

    public static void main(String[] args) {
        System.out.println(calcSums());
    }
}