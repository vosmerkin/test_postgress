package com.example.postgres.curlBuider;

import java.io.IOException;

public class Process {
    public void processBuilder(String curl) {
        try {
            java.lang.Process process = Runtime.getRuntime().exec(curl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
