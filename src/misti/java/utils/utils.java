package misti.java.utils;

import java.util.Scanner;

public class utils {

    public static final Character[] alfabeto = {
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'x', 'y', 'z'
    };

    public static int leerModuloCesar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la llave de cifrado: ");
        return scanner.nextInt();
    }
}
