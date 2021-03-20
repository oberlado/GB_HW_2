package geekbrains;

public class Track implements Obstacles {
    int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Беговая дорожка длиной " + length + " м";
    }

    @Override
    public boolean doRun(int maxLength) {
        {
            return (maxLength >= length);
        }
    }

    @Override
    public boolean doJump(int maxHeight) {
        return false;
    }
}
