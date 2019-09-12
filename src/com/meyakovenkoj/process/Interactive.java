package com.meyakovenkoj.process;

import com.meyakovenkoj.Process;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import java.util.Scanner;

public class Interactive implements Process {



    public void start(String [] args) throws NoSuchAlgorithmException, FileNotFoundException {
        int a = menu();
        while (a > 0){
            Scanner in = new Scanner(System.in);
            String filename = in.nextLine();
            String text = new Scanner(new File(filename)).useDelimiter("\\Z").next();
            byte [] result = new byte[0];
            if (a == 1){
                result = processInputData(text.getBytes( StandardCharsets.UTF_8 ), "MD5");
            } else if (a == 2) {
                result = processInputData(text.getBytes( StandardCharsets.UTF_8 ), "SHA-256");
            }
            print(result);
            a = menu();
        }
    }

    public int menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose algorithm:");
        System.out.println("1. MD5");
        System.out.println("2. SHA256");
        System.out.println("Print 0 to exit");
        return in.nextInt();
    }
}
