package testcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final StringBuilder stringBuilder = new StringBuilder();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {

            @Override
            public String call() throws InterruptedException {

                Thread.sleep(10);
                System.out.println("inside of call");
                stringBuilder.append("something");

                return "hello";

            }

        });

        executorService.execute(futureTask);
        executorService.shutdown();
        System.out.println("continue");

    }

}
