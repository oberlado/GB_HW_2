package lesson5;

public class Main {
    private static void singleThread(float[] arr) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long singleTime = System.currentTimeMillis() - start;

        System.out.printf("Время выполнения при однопоточных вычислениях: %d%n", singleTime);
    }
    private static void multiThread(float[] arr,int quan) {
        float[][] c = new float [quan][size];
        long start = System.currentTimeMillis();
        for (int i = 0; i < quan; i++) {
            System.arraycopy(arr, i*h, c[i], 0, h);
            Thread temp = new MyThread("№"+i, c[i]);
            temp.start();
            System.out.println("Started Thread:" + temp.getName());
            c[i]= ((MyThread) temp).getArr();}
        for (int i = 0; i < quan; i++){
            System.arraycopy(c[i], h*i, arr, 0, h);
        }
            long multiTime = System.currentTimeMillis() - start;

            System.out.printf("Время выполнения при многопоточных вычислениях: %d%n", multiTime);
        }
    private static int quan =3;
    private static final int size = 100000;
    private static final int h = size / quan;
    private static float[] arr = new float[size];

    public static void main(String[] args) {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        singleThread(arr);
        multiThread(arr,quan);

    }

}

class MyThread extends Thread {
    private float[] arr;


    MyThread(String name, float[] arr) {
        super(name);
        this.arr = arr;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));}
    }

    float[] getArr() {
        return arr;
    }
}
