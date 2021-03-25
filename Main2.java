package lesson3;


public class Main2 {
    public static void main(String[] args){
        Phonebook phonebook = new Phonebook();
        phonebook.add("Первый", "11111");
        phonebook.add("Второй", "22222");
        phonebook.add("Третий", "33333");
        phonebook.add("Первый", "44444");
        phonebook.add("Третий", "55555");
        System.out.println("Первый"+ " "+ phonebook.get("Первый"));
        System.out.println("Второй"+ " "+ phonebook.get("Второй"));
        System.out.println("Третий"+ " "+ phonebook.get("Третий"));
        System.out.println("Alien"+ " "+ phonebook.get("Alien"));

        phonebook.add("Третий", "33333");
    }
}