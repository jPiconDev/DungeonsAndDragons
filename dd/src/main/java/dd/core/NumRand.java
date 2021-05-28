package dd.core;

import java.util.Random;

/**
 * Clase que genera un mismo Random para toda la aplicación
 */
public class NumRand {
    private static long seed = 12345678L;   
    private static Random rand = new Random(seed); //Para usar sin semilla eliminar el parámetro
    
    public static Random getRand(){
        return rand;
    }
}
