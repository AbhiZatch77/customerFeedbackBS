package org.example;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> map = new LinkedHashMap<>();
        for(int i = 0 ; i < 3 ; i++) {
            map.put(sc.nextInt(), sc.next());
        }
        int x = sc.nextInt();
        map.remove(x);
        map.entrySet().forEach(entry -> System.out.println(entry.getValue()));
    }
}
