package dd.core;

import java.util.ArrayList;

public class Caballero extends Personaje{
    // Constructor
    public Caballero(String nombre){
        super(nombre);
        numAtq = 2;
        this.salud = 1500;
    }

    @Override
    public ArrayList<Integer> ataca(Personaje enemigo) {
        ArrayList<Integer> ataques = new ArrayList<>();
        for(int i=0; i<numAtq; i++) {
            if(enemigo.getSalud() > 0)
                ataques.add(this.ataque.lanzaAtaque(enemigo));
        }
        return ataques;
    }

    // @Override
    // public String toString(){
    //     return "[" + super.nombre + ": " + salud + "]";
    // }
}