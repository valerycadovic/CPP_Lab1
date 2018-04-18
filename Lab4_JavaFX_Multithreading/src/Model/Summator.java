package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Summator {
    /**
     * <h3>Calculates a sum of two integer vectors async</h3>
     * @param vector1
     *      first vector
     * @param vector2
     *      second vector
     * @return
     *      sum of vectors - a new integer vector
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static Integer[] sumVectors(Integer[] vector1, Integer[] vector2)
            throws ExecutionException, InterruptedException {

        int min = Integer.min(vector1.length, vector2.length);
        int max = Integer.max(vector1.length, vector2.length);

        Integer[] result = new Integer[max];

        ExecutorService threadPool = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() + 1);

        List<Future<Integer>> futures = new ArrayList<>();

        for(int i = 0; i < min; i++){
            final int j = i;
            futures.add(CompletableFuture.supplyAsync(
                    () -> vector1[j] + vector2[j],
                    threadPool));
        }

        int index = 0;
        for (Future<Integer> future : futures) {
            result[index++] = future.get();
        }

        threadPool.shutdown();

        for(int i = index; i < max; i++){
            if(vector1.length > vector2.length){
                result[i] = vector1[i];
            } else {
                result[i] = vector2[i];
            }
        }

        return result;
    }
}

