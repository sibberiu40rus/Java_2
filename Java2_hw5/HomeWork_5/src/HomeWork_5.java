/**
 * Java_2_Lesson_5
 * @autor Alexey Martynyuk
 * @version 16.01.2019
 */
public class HomeWork_5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        method_1(arr);
        method_2(arr);
    }

    //метод изменения значений в массиве

    public static void calcOfNewValues (float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    /**
     * метод для расчета неразделенного массива
     * @param arr
     */

    public static void method_1 (float[] arr) {
        long a = System.currentTimeMillis();
        calcOfNewValues(arr);
        System.out.println("Время для подсчета неразделенного массива: " + (System.currentTimeMillis() - a));
    }

    /**
     * метод разделяющий массивы, расчитывающий и собирающий их обратно
     * @param arr
     */

    public static void method_2 (float[] arr) {
        long startTime = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        System.out.println("Время для разбивки: " + (System.currentTimeMillis() - startTime));
        long startCalcTime = System.currentTimeMillis();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calcOfNewValues(arr1);
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calcOfNewValues(arr2);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //не догадался как расчитать время каждого массива и решил, что т.к. они идут параллельно - время +\- должно быть приблизетельно равным

        System.out.println("Время для расчетов массивов: " + (System.currentTimeMillis() - startCalcTime));


        long finishCalcTime = System.currentTimeMillis();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println("Время для склейки: " + (System.currentTimeMillis() - finishCalcTime));
        System.out.println("Времени затрачено на разбивку+расчет+склейку: " + (System.currentTimeMillis() - startTime));
    }
}


