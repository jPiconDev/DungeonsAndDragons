package dd.App;

import java.util.ArrayList;
import java.util.Iterator;

import dd.core.*;

/**
 * Clase que simula el enfrentamiento entre un 
 * ejército de hombres y otro de trolls.
 *
 */
public class DDApp {  
    public static void main( String[] args ) {
        
        //Random para los ejércitos
        NumRand r =  new NumRand();
    
        //Constantes de textos
        final String ARMY_KING = "\033[1m" + "Rey Arturo, Lancelot y Percival" + "\033[0m";
        final String ARMY_TROLLS = "\033[1m" + "3" + "\033[0m";
        final String TITLE = "\n========================== DUNGEON & DRAGONS ==========================";
        final String INTRO = "\nTal día como hoy, en una húmeda y fría mañana de finales de primavera, la partida formada por: ​" + ARMY_KING + ", hallándose en los frondosos bosques del sitio de Deorham, se topó con una patrulla de ​" + ARMY_TROLLS + " de esas sanguinarias e inhumanas criaturas popularmente conocidas como trolls. \n\nDe la batalla que aconteció, dejo aquí testimonio: \n";

        //Creamos dos listas con los personajes
        ArrayList<Personaje> hombres = new ArrayList<>();
        ArrayList<Personaje> trolls = new ArrayList<>();

        //Creamos los 3 tipos de ataques y los guardamos en una lista
        AtaqueEspada espada = new AtaqueEspada();
        AtaqueArco arco = new AtaqueArco();
        AtaqueCuchillo cuchillo = new AtaqueCuchillo();
        ArrayList<Ataque> listaAtaques = new ArrayList<Ataque>(){{add(espada); add(arco); add(cuchillo);}}; 
        
        //Creamos los personajes de los hombres con sus tipos de ataque y los añadimos a la lista
        Rey arturo = new Rey("Rey Arturo");
        arturo.setAtaque(espada);
        hombres.add(arturo);
        Caballero lancelot = new Caballero("Lancelot");
        lancelot.setAtaque(espada);
        hombres.add(lancelot);
        Caballero percival = new Caballero("Percival");
        percival.setAtaque(arco);
        hombres.add(percival);

        //Creamos los personajes de los trolls con sus tipos de ataque y los añadimos a la lista
        int numTrolls = r.nextInt(10 + 1 - 2) + 2; //Numero aleatorio de trolls
        for (int i = 1; i <= numTrolls; i++) {
            trolls.add(new Troll("Troll " + i)); //añadimos los trolls al arraylist
        }
        for (Personaje troll : trolls) {
            troll.setAtaque(listaAtaques.get(r.nextInt(3))); //para cada troll asignamos un tipo de ataque aleatorio
        }

        //Iniciamos los turnos de la partida:
        System.out.println(TITLE);
        System.out.println(INTRO);

        while(hombres.size() > 0 && trolls.size() > 0) {
            //Iniciamos el turno de los hombres
            clash(hombres, trolls);
            //si la lista de enemigos queda vacía generamos el resultado
            if(trolls.size() == 0) {
                System.out.println("Finalmente, el ejército del Rey Arturo venció!!!");
                System.out.println("Los supervivientes de la batalla fueron:");
                System.out.println(hombres);
                break;
            }
            clash(trolls, hombres);
            if(hombres.size() == 0) {
                System.out.println("Finalmente, el ejército de los trolls venció!!!");
                System.out.println("Los supervivientes de la batalla fueron:");
                System.out.println(trolls);
                break;
            }
            System.out.println(". . .");
        }
    }

    private static void clash(ArrayList<Personaje> army_att, ArrayList<Personaje> army_def) {
        NumRand r = new NumRand();
        for (Personaje p_att : army_att) {
            if(army_def.size() > 0){
                Personaje p_def = army_def.get(r.nextInt(army_def.size()));
                System.out.println(p_att + " lucha contra " + p_def);
                ArrayList<Integer> listaSalud = p_att.ataca(p_def);
                for (int i = 0; i < listaSalud.size(); i++) {
                    String salud = listaSalud.get(i) == 0 ? "falla" : "-" + listaSalud.get(i).toString();
                    System.out.println("Ataque con " + p_att.getAtaque() + "(" + salud + ")");
                }
                if(p_def.getSalud() <= 0) {
                    army_def.remove(p_def);
                    System.out.println(p_def + " muere!");
                }
            }
        }
    }
}
