package com.lazo.elgamal_javafx.elgamal;

import java.math.BigInteger;

import static com.lazo.elgamal_javafx.fast_powering_algorithm.FastPoweringAlgorithm.fastPoweringAlgorithm;

/**
 * Created by Lazo on 2021-12-23
 * Created for <strong>Ministry of Internal Affairs</strong>
 */

public class Elgamal {

    public static BigInteger[] elgamalEncryption(BigInteger p, BigInteger g, BigInteger A, BigInteger m, BigInteger k) {
        BigInteger c1, c2;
        BigInteger[] ans;

        c1 = fastPoweringAlgorithm(g, k, p);

        c2 = (m.multiply(fastPoweringAlgorithm(A, k, p))).mod(p);
        ans = new BigInteger[]{c1, c2};
        return ans;
    }

    public static BigInteger elgamalDecryption(BigInteger[] cc, BigInteger p, BigInteger a) {
        BigInteger x, xMinus1, ans;

        x = fastPoweringAlgorithm(cc[0], a, p);

        xMinus1 = fastPoweringAlgorithm(x, p.subtract(BigInteger.valueOf(2)), p);

        ans = (cc[1].multiply(xMinus1)).mod(p);

        return ans;
    }

}
