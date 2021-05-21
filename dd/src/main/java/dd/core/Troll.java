package dd.core;

import java.util.ArrayList;

public class Troll extends Personaje{
   // Constructor
   public Troll(String nombre){
    super(nombre);
    this.salud = 1000;
}

@Override
public ArrayList<Integer> ataca(Personaje enemigo) {
    ArrayList<Integer> ataques = new ArrayList<>();
    if(enemigo.getSalud() > 0)
        ataques.add(this.ataque.lanzaAtaque(enemigo));
    return ataques;
}
}