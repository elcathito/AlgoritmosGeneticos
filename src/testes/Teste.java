package testes;

import java.util.HashMap;
import java.util.Map;


public class Teste {
    public static void main(String[] args) {
        System.out.println("A>B>C>D");
        Map<String,Integer> testMap = new HashMap<>();
        testMap.put("A",1);
        testMap.put("B",2);
        testMap.put("C",2);
        System.out.println(testMap);
        System.out.println("A>C>B>D");
        testMap.clear();
        testMap.put("A",2);
        testMap.put("C",2);
        testMap.put("B",2);
        System.out.println(testMap);
    }
}
