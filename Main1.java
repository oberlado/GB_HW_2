package lesson3;

import java.util.*;

    public class Main1 {
        public static void main(String[] args){
            List<String> words = Arrays.asList(
                    "1", "2", "3", "4", "5",
                    "1", "1", "6", "4", "5",
                    "3", "5", "5", "6", "2",
                    "7", "8", "9", "10", "10"
            );

            Set<String> unique = new HashSet<String>(words);
            System.out.println("Уникальные номера");
            System.out.println(unique.toString());
            System.out.println("Частота слов");
            for (String key : unique) {
                System.out.println(key + ": " + Collections.frequency(words, key));
            }
        }
    }
