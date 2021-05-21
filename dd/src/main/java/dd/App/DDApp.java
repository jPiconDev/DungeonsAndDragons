package dd.App;

import java.util.ArrayList;
import java.util.Random;

import dd.core.Ataque;
import dd.core.AtaqueArco;
import dd.core.AtaqueCuchillo;
import dd.core.AtaqueEspada;
import dd.core.Caballero;
import dd.core.Personaje;
import dd.core.Rey;
import dd.core.Troll;

/**
 * Clase que simula el enfrentamiento entre un 
 * ejército de hombres y otro de trolls.
 *
 */
public class DDApp 
{
    public static void main( String[] args ) {

        final String INTRO = "Tal día como hoy, en una húmeda y fría mañana de finales de primavera, la partida formada por: ​ Rey Arturo, Lancelot y Percival, hallándose en los frondosos bosques del sitio de Deorham, se topó con una patrulla de ​ 3 de esas sanguinarias e inhumanas criaturas popularmente conocidas como trolls.\n De la batalla que aconteció, dejo aquí testimonio: \n";

        //Creamos dos listas con los personajes
        ArrayList<Personaje> hombres = new ArrayList<>();
        ArrayList<Personaje> trolls = new ArrayList<>();

        //Random para los ejércitos
        Random rand = new Random();

        //Creamos los 3 tipos de ataques y los guardamos en una lista
        AtaqueEspada espada = new AtaqueEspada();
        AtaqueArco arco = new AtaqueArco();
        AtaqueCuchillo cuchillo = new AtaqueCuchillo();
        ArrayList<Ataque> listaAtaques = new ArrayList<>(); 
        listaAtaques.add(espada);
        listaAtaques.add(arco);
        listaAtaques.add(cuchillo);
        
        //Creamos los personajes de los hombres con sus tipos de ataque
        Rey arturo = new Rey("Arturo");
        arturo.setAtaque(espada);
        Caballero lancelot = new Caballero("Lancelot");
        lancelot.setAtaque(espada);
        Caballero percival = new Caballero("Percival");
        percival.setAtaque(arco);

        //Añadimos los personajes a la lista
        hombres.add(arturo);
        hombres.add(lancelot);
        hombres.add(percival);

        //Añadimos los trolls a su ejército
        int numTrolls = rand.nextInt(10 + 1 - 2) + 2;
        int ataqueTrolls = rand.nextInt(3);

        for (int i = 1; i <= numTrolls; i++) {
            trolls.add(new Troll("Troll " + i));
        }
        for (Personaje troll : trolls) {
            troll.setAtaque(listaAtaques.get(ataqueTrolls));
        }

        //Iniciamos los turnos de la partida:
        while(hombres.size() != 0 || trolls.size() != 0) {
            System.out.println(INTRO);
            
            for (Personaje hombre : hombres) {
                Personaje troll = trolls.get(rand.nextInt(trolls.size()));
                System.out.println(hombre.toString() + " lucha contra " + troll.toString());
                hombre.ataca(troll);
            }
            for (Personaje troll : trolls) {
                troll.ataca(hombres.get(rand.nextInt(hombres.size())));
            }
        }
    }
}
