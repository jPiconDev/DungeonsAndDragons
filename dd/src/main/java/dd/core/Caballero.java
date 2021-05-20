package dd.core;

public class Caballero extends Personaje{
    
    public Caballero(String nombre) {
        super(nombre);
        this.salud = 1500;
    }

    @Override
    public void ataca(Personaje enemigo) {
        for(int i=0; i<2; i++) this.ataca(enemigo);        
    }
}