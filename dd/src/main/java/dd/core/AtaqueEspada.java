package dd.core;

import java.util.Random;

public class AtaqueEspada implements Ataque{
    private Random rand = new Random();
    private final int ataque = 100;

    @Override
    public int lanzaAtaque(Personaje enemigo) {
        int acierta = rand.nextInt(2);
        double factor = rand.nextDouble();
        double damage = acierta * factor * ataque;

        return enemigo.updateSalud((int) damage);
    }

    @Override
    public String getArma() {
        return "espada";
    }
}