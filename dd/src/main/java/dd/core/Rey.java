package dd.core;

import java.util.ArrayList;

public class Rey extends Personaje{
    // Constructor
    public Rey(String nombre){
        super(nombre);
        numAtq = 3;
        this.salud = 2000;
    }

    @Override
    public ArrayList<Integer> ataca(Personaje enemigo) {
        ArrayList<Integer> ataques = new ArrayList<>();
        // for(int i=0; i<numAtq; i++) {
        //     if(enemigo.getSalud() > 0)
        //         ataques.add(this.ataque.lanzaAtaque(enemigo));
        // }
        int n = numAtq;
        while (enemigo.getSalud() > 0 && n > 0) {
            ataques.add(this.ataque.lanzaAtaque(enemigo));
            n--;          
        }
        return ataques;
    }
}