package misti.java.cifrado;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;

import static misti.java.utils.utils.alfabeto;

public class Cesar {

    private final HashMap<Character, Character> alfCifr;

    public Cesar(int modCif) {
        alfCifr = getAlfCifr(modCif);
    }

    public String cifrar(String textoPlano) {
        return sustituyeDict(textoPlano, alfCifr);
    }

    public String deCifrar(final String textoCifrado, final int mod) {
        return sustituyeDict(textoCifrado, getAlfDesCifr(mod));
    }

    private HashMap<Character, Character> getAlfCifr(int modCif) {
        HashMap<Character, Character> dict = new HashMap<>();
        int longAlf = alfabeto.length;
        int indiceOriginalCaracter = 0;
        int indiceCifradoCaracter;
        System.out.println("""
                ===================================\s
                \tDiccionario de Cifrado Cesar
                ===================================""");
        for (Character caracter : alfabeto) {
            indiceCifradoCaracter = (indiceOriginalCaracter + modCif) % longAlf;
            dict.put(caracter, alfabeto[indiceCifradoCaracter]);
            System.out.println(caracter + " --> " + dict.get(caracter));
            indiceOriginalCaracter++;
        }
        return dict;
    }

    private HashMap<Character, Character> getAlfDesCifr(int mod) {
        HashMap<Character, Character> dict = new HashMap<>();
        int longAlf = alfabeto.length;
        int indiceOriginalCaracter = 0;
        int indiceCifradoCaracter;
        System.out.println("""
                ===================================\s
                \tDiccionario de Descifrado Cesar
                ===================================""");
        for (Character caracter : alfabeto) {
            indiceCifradoCaracter = (indiceOriginalCaracter - mod) % longAlf;
            indiceCifradoCaracter = indiceCifradoCaracter < 0 ? longAlf + indiceCifradoCaracter : indiceCifradoCaracter;
            dict.put(caracter, alfabeto[indiceCifradoCaracter]);
            System.out.println(caracter + " --> " + dict.get(caracter));
            indiceOriginalCaracter++;
        }
        return dict;
    }

    private String sustituyeDict(final String texto, final HashMap<Character, Character> dict) {
        CharacterIterator characterIterator = new StringCharacterIterator(texto);
        StringBuilder stringBuilder = new StringBuilder();
        Character tempCharacter;
        while (characterIterator.current() != CharacterIterator.DONE) {
            tempCharacter = dict.get(characterIterator.current());
            stringBuilder.append(
                    tempCharacter != null ? tempCharacter : characterIterator.current()
            );
            characterIterator.next();
        }
        return stringBuilder.toString();
    }
}
