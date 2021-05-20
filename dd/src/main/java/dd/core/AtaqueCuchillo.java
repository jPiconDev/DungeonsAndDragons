package dd.core;

public class AtaqueCuchillo implements Ataque{
    @Override
    public void lanzaAtaque(Personaje enemigo) {
        enemigo.salud -= 25;
        System.out.println("Ataque con cuchillo");        
    }
}