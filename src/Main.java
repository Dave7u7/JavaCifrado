import misti.java.cifrado.Cesar;
import misti.java.descifrado.DescifradoEstadistico;
import misti.java.files.FileAdaptor;

import static misti.java.utils.utils.leerModuloCesar;

public class Main {

    public static void main(String[] args) {
        String archivoOrigen =
                "C:\\Users\\Pavilion\\Documents\\MISTI\\B22\\ProgramacionJava\\Cifrados\\CESAR_PLANO.txt";
        String archivoCifrado =
                "C:\\Users\\Pavilion\\Documents\\MISTI\\B22\\ProgramacionJava\\Cifrados\\CESAR_CIFRADO.txt";
        String archivoDesCifrado =
                "C:\\Users\\Pavilion\\Documents\\MISTI\\B22\\ProgramacionJava\\Cifrados\\CESAR_DECIFRADO.txt";

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
