package sw07.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class Prime implements Callable<Boolean> {

    BigInteger bi;

    public Prime(BigInteger bi) {
        this.bi = bi;
    }

    public boolean checkPrime() {
        if (bi.isProbablePrime(Integer.MAX_VALUE)) {
            return true;
        }
        return false;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Boolean call() throws Exception {
        return this.checkPrime();
    }
}
