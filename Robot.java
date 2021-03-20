package geekbrains;

public class Robot implements Actions {
    int Height;
    int Length;
    String name;

    public Robot(int Height, int Length, String name) {
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
