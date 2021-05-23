package dd.core;

import java.util.Random;
/**
 * Implementa un tipo de ataque con arco
 * 
 * @method {@link #lanzaAtaque} <li>{@link #getArma}
 */
public class AtaqueArco implements Ataque{
    //private long seed = 12345678L;
    private Random rand = new Random();
    private final int ataque = 50;

    @Override
    public int lanzaAtaque(Personaje enemigo) {
        int acierta = rand.nextInt(2);
        double factor = rand.nextDouble();
        double damage = acierta * factor * ataque;

        return enemigo.updateSalud((int) damage);
    }

    @Override
    public String getArma() {
        return "arco";
    }
}