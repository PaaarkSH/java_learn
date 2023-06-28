package thejava8.section8;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numbers);  // 쓰레드를 하나만 씀
        System.out.println("serial sorting took " + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());  // 진짜 효율적인지 몰라서 다시 랜덤하게 만듬
        start = System.nanoTime();
        Arrays.parallelSort(numbers);
        System.out.println("parallel sorting took " + (System.nanoTime() - start));
    }
}
