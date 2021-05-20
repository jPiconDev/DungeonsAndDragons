package dd.core;

public class AtaqueArco implements Ataque{
    @Override
    public void lanzaAtaque(Personaje enemigo) {
        enemigo.salud -= 50;
        System.out.println("Ataque con Arco");    
    }
}