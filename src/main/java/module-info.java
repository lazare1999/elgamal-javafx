module com.lazo.elgamal_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lazo.elgamal_javafx to javafx.fxml;
    exports com.lazo.elgamal_javafx;
}
