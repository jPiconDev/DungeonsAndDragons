package dd.core;

public class Rey extends Personaje{

    public Rey(String nombre){
        super(nombre);
        this.salud = 2000;
    }

    @Override
    public void ataca(Personaje enemigo) {
        for(int i=0; i<3; i++) this.ataca(enemigo);    
    }
}