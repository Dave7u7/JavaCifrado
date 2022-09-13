import misti.java.cifrado.Cesar;
import misti.java.descifrado.DescifradoEstadistico;
import misti.java.files.FileAdaptor;

import static misti.java.utils.utils.leerModuloCesar;

public class Main {

    public static void main(String[] args) {
        String archivoOrigen =
                "C:\\Users\\DAVID\\Documents\\MISTI\\TEXTO\\texto_plano.txt";
        String archivoCifrado =
                "C:\\Users\\DAVID\\Documents\\MISTI\\TEXTO\\texto_cifrado.txt";
        String archivoDesCifrado =
                "C:\\Users\\DAVID\\Documents\\MISTI\\TEXTO\\texto_decifrado.txt";

        FileAdaptor fileAdaptor = new FileAdaptor();
        Cesar cesar = new Cesar(leerModuloCesar());
        String textPlano = fileAdaptor.FileToString(archivoOrigen);
        String textCifrado = cesar.cifrar(textPlano);
        System.out.println(textCifrado);
        fileAdaptor.StringToFile(textCifrado, archivoCifrado);
        DescifradoEstadistico descifradoEstadistico = new DescifradoEstadistico(textPlano, textCifrado);
        String textDeCifrado = cesar.deCifrar(textCifrado, descifradoEstadistico.getModuloDeCifrado());
        fileAdaptor.StringToFile(textDeCifrado, archivoDesCifrado);
        System.out.println(textDeCifrado);
    }
}
