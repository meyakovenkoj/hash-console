package com.meyakovenkoj;

import com.meyakovenkoj.process.Interactive;
import com.meyakovenkoj.process.Manual;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class Check {
    public static Process session;
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        if(args.length > 0) {
            if(args[0].equals("-i"))
                session = new Interactive();
            else
                session = new Manual();
            session.start(args);
        }

    }

}
