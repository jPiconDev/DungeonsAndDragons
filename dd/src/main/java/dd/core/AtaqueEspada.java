package dd.core;

public class AtaqueEspada implements Ataque{
    @Override
    public void lanzaAtaque(Personaje enemigo) {
        enemigo.salud -= 100;
        System.out.println("Ataque con Espada");
    }
}