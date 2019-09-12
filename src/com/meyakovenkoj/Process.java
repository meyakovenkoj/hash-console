package com.meyakovenkoj;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Process {
    public void start(String [] args) throws FileNotFoundException, NoSuchAlgorithmException;
    public default byte[] processInputData(byte [] data, String type) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance( type );
        md.update(data);
        return md.digest();
    }
    public default void print(byte[] digest){
        String hex = String.format( "%064x", new BigInteger( 1, digest ) );
        System.out.println( hex );
    }
}
