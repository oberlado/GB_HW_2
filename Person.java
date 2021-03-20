package geekbrains;

public class Person implements Actions {
    int Height;
    int Length;
    String name;

    public Person(int Height, int Length, String name) {
        this.Height = Height;
        this.Length = Length;
        this.name = name;
    }

    @Override
    public int getMaxHeight() {
        return Height;
    }

    @Override
    public void jump() {
        System.out.println("Побежал");
    }

    @Override
    public int getMaxLength() {
        return Length;
    }

    @Override
    public void run() {
        System.out.println("Прыгнул");
    }

    @Override
    public String toString() {
        return name;
    }
}
