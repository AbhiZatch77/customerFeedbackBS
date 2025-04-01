package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Coding {

    public String reverseString(String str) {
        char[] charArr = str.toCharArray();

        int left = 0;
        int right = charArr.length - 1;

        while(left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }

       return new String(charArr);
    }

    public List<Integer> swapNumbers(int a, int b) {
        a = a+b;
        b = a-b;
        a = a-b;
        return List.of(a,b);
    }

    public Map<String, Integer> countNumberInStringWithHashMap(String str) {

        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(str.split(" ")).forEach(word -> map.put(word, word.length()));
        return map;

    }

    public void iterateMapWhileAndFor(Map<String, Integer> map) {

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));

    }

    public boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num <= 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num ; i+=6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    public boolean isPali(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if(chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public int fibo(int num) {
        if(num <= 1) return num;
        return fibo(num - 1) + fibo(num - 2);
    }

    public void fibo2(int num) {
        int a = 0;
        int b = 1;
        for(int i = 0 ; i < num ; i++) {
            System.out.print(a+" ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }

    public void findDupChar(String str) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);
            charMap.put(ch , charMap.getOrDefault(ch,0) + 1);
        }
        charMap.entrySet().stream().filter((entry) -> (entry.getValue() > 1))
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    public int findSecondHighest(int[] arr) {
//        Arrays.sort(arr);
//        return arr[arr.length - 2];

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest && num != highest) {
                secondHighest = num;
            }

        }
        return secondHighest;
    }

    public boolean isArms(int num) {
        double original = num;
        double sum = 0;
        int pow = String.valueOf(num).length();
        for(int i = 0 ; i < pow ; i++) {
            sum = sum + Math.pow(num%10, pow);
            num = num/10;
        }
        return sum==original;
    }

    public String removeWhite(String str) {
        String[] strArr = str.split(" ");
        StringBuilder result= new StringBuilder();
        for (String st : strArr) {
            result.append(st);
        }
        return result.toString();
    }

    public int[] findIndices(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++) {
            int diff = target - arr[i];
            if(map.containsKey(diff)) {
                return new int[]{i , map.get(diff)};
            }
            map.put(arr[i], i);
        }
        return null;

//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0 ; i < arr.length ; i++) {
//            for(int j = i + 1 ; j < arr.length ; j++) {
//                if(arr[i] + arr[j] == target) {
//                    map.put(arr[i], i);
//                    map.put(arr[j], j);
//                }
//            }
//        }
//        return map;
    }

    public boolean isGoodString(String str) {
//        char[] chars = str.toCharArray();
//        boolean isGood = true;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0 ; i < chars.length ; i++) {
//            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
//        }
//        int val = map.get(chars[0]);
//        for(Map.Entry entry: map.entrySet()) {
//            if(!entry.getValue().equals(val)) {
//                isGood = false;
//            }
//        }
//        return isGood;
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        return map.entrySet().stream().map(entry -> entry.getValue()).distinct().count() == 1;
    }

    public int giveNewLen(int[] arr, int val) {
//        int count = 0;
//        for(int i = 0 ; i < arr.length; i++) {
//            if(arr[i] == val)
//                count++;
//        }
//        return arr.length - count;
        return Arrays.stream(arr).filter(num -> num != val).toArray().length;
    }

    public boolean isAnagram(String s, String p) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = p.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }

    public List<Integer> giveIndexArrOfAnagram(String s, String p) {
        List<Integer> ls = new LinkedList<>();

        for(int i = 0 ; i < s.length() - p.length(); i++) {
            if(isAnagram(s.substring(i, i + p.length()), p))
                ls.add(i);
        }

        return ls;

    }

    public List<Integer> findMissingNumbers(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        int[] num = new int[arr.length];
        for(int i = 1; i <= arr.length ; i++) {
            num[arr[i-1]-1] = -1;
        }
        for(int i = 0; i < arr.length ; i++) {
            if(num[i] != -1)
                ls.add(i+1);
        }
        return ls;
    }

    public void streamsQuestions(List<Integer> ls) {
        ls.stream().filter(num -> num%2 == 0).forEach(num -> System.out.print(num+" "));
        int max = ls.stream().max(Integer::compareTo).orElse(0);
        System.out.println("\n" + max);
        System.out.println(ls.stream().mapToInt(Integer::intValue).sum());
        ls.stream().sorted().forEach(System.out::print);
        System.out.println("\n"+ls.stream().filter(num -> num > 5).count());
        ls.stream().distinct().forEach(System.out::print);
        System.out.println();
        System.out.println(ls.stream().reduce(0, Integer::sum));
        System.out.println(ls.stream().findAny().orElse(0));
        System.out.println(ls.stream().anyMatch(n-> n == -2));
    }

    public void streamsStringQuestions(List<String> ls) {
//        ls.stream().map(String::toUpperCase).forEach(System.out::println);
        ls.stream().map(str -> {
            if(!(str.isEmpty() || str.isBlank()))
                return str.split(" ")[0];
            return null;
        }).forEach(System.out::println);
    }

    public void streamsObject(List<Employee> ls) {
        Map<Integer, List<Employee>> map = ls.stream().collect(Collectors.groupingBy(Employee::getId));
    }

    public void removeDuplicates(List<Integer> ls) {
//        Set<Integer> set = ls.stream().collect(Collectors.toSet());
//        set.forEach(System.out::println);

        ls.stream().sorted().distinct().forEach(System.out::println);

    }

    public static String longestSubString(String str) {
        Set<String> subSet = new HashSet<>();

    }


}
