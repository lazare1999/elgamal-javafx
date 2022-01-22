package com.lazo.elgamal_javafx;

import com.lazo.elgamal_javafx.elgamal.Elgamal;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.util.Arrays;

import static com.lazo.elgamal_javafx.elgamal.Elgamal.elgamalEncryption;
import static com.lazo.elgamal_javafx.fast_powering_algorithm.FastPoweringAlgorithm.fastPoweringAlgorithm;

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

        if (gText ==null || gText.getText() ==null ||
                aText ==null || aText.getText() ==null ||
                pText==null || pText.getText() ==null ||
                mText==null || mText.getText() ==null ||
                kText==null || kText.getText() ==null
        )
            return;

        BigInteger A, g, a, p, m, k;

        try {
            g  = new BigInteger(gText.getText());
            p  = new BigInteger(pText.getText());
            a  = new BigInteger(aText.getText());
            k  = new BigInteger(kText.getText());
            m  = new BigInteger(mText.getText());

            A = fastPoweringAlgorithm(g, a, p);

            BigInteger[] cc = elgamalEncryption(p, g, A, m, k);

            ccGlobal =cc;

            encryptedText.setText(Arrays.toString(cc));
        } catch (Exception e) {
            encryptedText.setText("ERROR");
        }

    }

    @FXML
    public void decryptionButton() {

        if (aText ==null || pText==null)
            return;

        BigInteger a, p;

        try {
            p  = new BigInteger(pText.getText());
            a  = new BigInteger(aText.getText());

            if (ccGlobal ==null)
                return;

            var ans = Elgamal.elgamalDecryption(ccGlobal, p, a);

            decryptedText.setText(String.valueOf(ans));
        } catch (Exception e) {
            decryptedText.setText("ERROR");
        }

    }
}
