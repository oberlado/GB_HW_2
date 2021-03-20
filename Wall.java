package geekbrains;

public class Wall implements Obstacles {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Стена высотой " + height + " м";
    }

    @Override
    public boolean doRun(int maxLength) {
        return false;
    }

    @Override
    public boolean doJump(int maxHeight) {
            return (maxHeight >= height);
        }
    }

