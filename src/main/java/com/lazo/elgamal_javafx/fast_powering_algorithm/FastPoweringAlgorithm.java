package com.lazo.elgamal_javafx.fast_powering_algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.lazo.elgamal_javafx.utils.LazoUtils.convertStringToCharList;

/**
 * Created by Lazo on 2021-12-23
 */

public class FastPoweringAlgorithm {

    public static BigInteger fastPoweringAlgorithm(BigInteger g, BigInteger A, BigInteger mod) {
        List<Character> reversedA = convertStringToCharList(Long.toBinaryString(A.longValue()));
        List<BigInteger> aList = new ArrayList<>();
        aList.add(g);

        BigInteger ans = BigInteger.valueOf(1);
        var index = 1;
        for(int i = 0; i < reversedA.size(); i++) {

            if (i < reversedA.size()-1)
                aList.add((aList.get(i).multiply(aList.get(i))).mod(mod));

            index = reversedA.size() - (i +1);
            if (Integer.parseInt(String.valueOf(reversedA.get(index))) == 0)
                continue;

            ans = (ans.multiply(aList.get(i))).mod(mod);

        }

        return ans;
    }

}
