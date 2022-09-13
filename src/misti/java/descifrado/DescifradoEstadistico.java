package misti.java.descifrado;

import java.util.*;

import static misti.java.utils.utils.alfabeto;

public class DescifradoEstadistico {

    private final int moduloDeCifrado;

    public DescifradoEstadistico(String archivoFuente, String archivoCifrado){
        moduloDeCifrado = obtenerModulo(
                obtenerFrecuencias(archivoFuente),
                obtenerFrecuencias(archivoCifrado)
        );
    }

    public int getModuloDeCifrado() {
        return moduloDeCifrado;
    }

    private List<Double> obtenerFrecuencias(String texto){
        List<Double> frecuencias = new ArrayList<>();
        long count;
        double frecuencia;
        double textSize = texto.length();
        for (Character caracter : alfabeto){
            count = texto.chars().filter(ch -> ch == caracter).count();
            frecuencia = count / textSize;
            frecuencias.add(frecuencia);
        }
        return frecuencias;
    }

    private int obtenerModulo(List<Double> frecuenciasOrigen, List<Double> frecuenciasCifrado){
        int modulo = 0;
        for(Double frecuenciaOrigen: frecuenciasOrigen) {
            for(Double frecuenciaCifrado: frecuenciasCifrado){
                if(Objects.equals(frecuenciaOrigen, frecuenciaCifrado)) {
                    System.out.println("Se ha obtenido el modulo " + modulo + " como llave de descifrado.");
                    return modulo;
                }
                modulo++;
            }
        }
        System.out.println("No se ha obtenido una llave de descifrado");
        return 0;
    }
}
