package dd.core;

public class Troll extends Personaje{
    
    public Troll(String nombre) {
        super(nombre);
        this.salud = 1000;
    }

    @Override
    public void ataca(Personaje enemigo) {
        this.ataca(enemigo);
    }
}