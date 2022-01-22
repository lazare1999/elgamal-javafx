module com.lazo.elgamal_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    requires java.xml;
    requires java.desktop;
    requires java.security.jgss;
    requires javafx.base;
    requires jdk.unsupported;
    requires java.xml.crypto;
    requires java.management;
    requires java.naming;
    requires jdk.javadoc;


    opens com.lazo.elgamal_javafx to javafx.fxml;
    exports com.lazo.elgamal_javafx;
    opens com.lazo.elgamal_javafx.elgamal;
    exports com.lazo.elgamal_javafx.elgamal;
    opens com.lazo.elgamal_javafx.fast_powering_algorithm;
    exports com.lazo.elgamal_javafx.fast_powering_algorithm;
    opens com.lazo.elgamal_javafx.utils;
    exports com.lazo.elgamal_javafx.utils;
}
