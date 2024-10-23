package com.wlee.util;

import org.mindrot.jbcrypt.BCrypt;;

public class PasswordUtils {
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        if (plainTextPassword == null || hashedPassword == null) {
            return false;
        }

        try {
            return BCrypt.checkpw(plainTextPassword, hashedPassword);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }
}
