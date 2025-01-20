package com.aston.javabase.input_output;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IoBufferedExample {

    public static void main(String[] args) throws IOException {

        try (InputStream fileInputStream = new FileInputStream("C:\\Users\\Username\\Desktop\\test.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200)
        ) {
            int i;

            while ((i = bufferedInputStream.read()) != -1) {

                System.out.print((char) i);
            }
        }
    }
}
