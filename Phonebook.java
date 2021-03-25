package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Phonebook {

    private HashMap<String, List<String>> book;

    public Phonebook() {
        this.book = new HashMap<>();
    }

    public void add(String name, String number) {
        if (book.containsKey(name)) {
            List<String> numbers = book.get(name);
            if (!numbers.contains(number)) {
                numbers.add(number);
                System.out.println(String.format(" %s добавлен для %s", number, name));
            } else {
                System.out.println(String.format(" %s уже существует для  %s", number, name));
            }
        } else {
            book.put(name, new ArrayList<>(Arrays.asList(number)));
            System.out.println(String.format("%s добавлен для %s", number, name));
        }
    }

    public List<String> get(String surname) {
        if (book.containsKey(surname)) {
            return book.get(surname);
        } else {
            System.out.println(String.format("В справочнике нет записи для фамилии %s", surname));
            return new ArrayList<>();
        }
    }
}
