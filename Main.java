package geekbrains;

public class Main {
    public static void main(String[] args) {
        Actions[] members = {
                new Person(2, 10, "Прыгун"),
                new Cat(3, 30, "Терминатор"),
                new Robot(1, 20, "Бегун"),
        };

        Obstacles[] obstacles = {
                new Track(20),
                new Wall(2)
        };

        for (Actions member : members) {
            System.out.println( member + " начинает");
            boolean winner = true;
            for (Obstacles obstacle : obstacles) {
                System.out.println(member + " проходит " + obstacle);
                if (obstacle.doJump(member.getMaxHeight()) ||
                        obstacle.doRun(member.getMaxLength())) {
                    System.out.println("Успех");
                } else {
                    winner = false;
                    System.out.println("Неудача");
                    break;
                }
            }

            if(winner) {
                System.out.println(member + " - победа");
            } else {
                System.out.println(member + " - проигрыш");
            }
            System.out.println();
        }
    }
}
