package com.meyakovenkoj.process;

import com.meyakovenkoj.Process;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Manual implements Process {

    @Override
    public void start(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        if (args[0].equals("-sha256"))
            for (int i = 2; i < args.length; i++) {
                String text = new Scanner(new File(args[i])).useDelimiter("\\Z").next();
                byte[] result = processInputData(text.getBytes( StandardCharsets.UTF_8 ), "SHA-256");
                print(result);
            }
        else if (args[0].equals("-md5"))
            for (int i = 2; i < args.length; i++) {
                String text = new Scanner(new File(args[i])).useDelimiter("\\Z").next();
                byte[] result = processInputData(text.getBytes( StandardCharsets.UTF_8 ), "MD5");
                print(result);
            }
    }
}
