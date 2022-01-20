package com.lazo.elgamal_javafx;

import com.lazo.elgamal_javafx.elgamal.Elgamal;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static com.lazo.elgamal_javafx.elgamal.Elgamal.elgamalEncryption;
import static com.lazo.elgamal_javafx.fast_powering_algorithm.FastPoweringAlgorithm.fastPoweringAlgorithm;
import static com.lazo.elgamal_javafx.utils.LazoUtils.*;

public class ElgamalController {

    public TextField pText;
    public TextField gText;
    public TextField aText;
    public TextField mText;
    public TextField kText;
    public Label encryptedText;

    private BigInteger[] ccGlobal;

    @FXML
    private Label decryptedText;

    @FXML
    protected void encryptionButton() {

        if (gText ==null || aText ==null || pText==null || mText==null || kText==null)
            return;

        BigInteger A, g, a, p, m, k;

        g  = new BigInteger(gText.getText());
        p  = new BigInteger(pText.getText());
        a  = new BigInteger(aText.getText());
        k  = new BigInteger(kText.getText());
        m  = new BigInteger(mText.getText());

        A = fastPoweringAlgorithm(g, a, p);

        BigInteger[] cc = elgamalEncryption(p, g, A, m, k);

        ccGlobal =cc;

        encryptedText.setText(Arrays.toString(cc));
    }

    @FXML
    public void decryptionButton() {

        if (aText ==null || pText==null)
            return;

        BigInteger a, p;

        p  = new BigInteger(pText.getText());
        a  = new BigInteger(aText.getText());

        if (ccGlobal ==null)
            return;

        var ans = Elgamal.elgamalDecryption(ccGlobal, p, a);

        decryptedText.setText(String.valueOf(ans));
    }
}
