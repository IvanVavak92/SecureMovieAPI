package com.ivan.securemovieapi;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class KeyGenerator {
    public static void main(String[] args) {
        // Generate a secure key
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // Convert the key to a Base64-encoded string
        String encodedKey = Encoders.BASE64.encode(key.getEncoded());

        // Print the encoded key
        System.out.println("Encoded Key: " + encodedKey);
        //yC5EdV7XtCkes8VV9A+UZP+7w4uMdCnHHzo7zKeKGB8=
    }
}
