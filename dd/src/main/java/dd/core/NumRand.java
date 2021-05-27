package dd.core;

import java.util.Random;

/**
 * Clase que genera un mismo Random para toda la aplicación
 */
public class NumRand extends Random{
    private long seed;
    private Random rand;
    
    public NumRand(){
        this.seed = 12345678L;
        this.rand = new Random(seed); //Para usar sin semilla eliminar el parámetro
    }

    public Random getRand(){
        return this.rand;
    }
}
