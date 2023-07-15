package com.edwinmarrugo.userstohexagonal.application.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class Util {
    private Util() {
    }

    public static String convertToBase64(MultipartFile image) {
        try {
            byte[] bytes = image.getBytes();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            // Manejo de errores
            e.printStackTrace();
            return null;
        }
    }
}
