package dd.core;

/**
 * Implementa un tipo de ataque con espada
 * 
 * @method {@link #lanzaAtaque} <li>{@link #getArma}
 */
public class AtaqueEspada implements Ataque{
    private NumRand r =  new NumRand();
    private final int ataque = 100;

    @Override
    public int lanzaAtaque(Personaje enemigo) {
        int acierta = r.nextInt(2);
        double factor = r.nextDouble();
        double damage = acierta * factor * ataque;

        return enemigo.updateSalud((int) damage);
    }

    @Override
    public String toString() {
        return "espada";
    }
}