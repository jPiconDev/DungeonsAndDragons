package dd.core;

import java.util.Random;

/**
 * Implementa un tipo de ataque con cuchillo
 * 
 * @method {@link #lanzaAtaque} <li>{@link #getArma}
 */
public class AtaqueCuchillo implements Ataque{
    private Random r = NumRand.getRand();
    private final int ataque = 25;

    @Override
    public int lanzaAtaque(Personaje enemigo) {
        int acierta = r.nextInt(2);
        double factor = r.nextDouble();
        double damage = acierta * factor * ataque;

        return enemigo.updateSalud((int) damage);
    }

    @Override
    public String toString() {
        return "cuchillo";
    }
}