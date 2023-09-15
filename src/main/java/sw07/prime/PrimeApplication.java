package sw07.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.*;

public class PrimeApplication {

    private static final Logger LOG = LogManager.getLogger();



    public static void main(String[] args) {
        int foundPrimes = 0;
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        while(foundPrimes < 100) {
            try {
                BigInteger bi = new BigInteger(1024, new Random());
                Future<Boolean> result = executorService.submit(new Prime(bi));
                if(result.get()) {
                    foundPrimes++;
                    LOG.info(foundPrimes + ": " + bi);
                }
            } catch(ExecutionException | InterruptedException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        long endTime = System.currentTimeMillis();
        LOG.debug("Applikation beenden...");
        executorService.shutdown();
        LOG.info("Zeit in Sekunden: " + (endTime - startTime) / 1000);
    }


}
