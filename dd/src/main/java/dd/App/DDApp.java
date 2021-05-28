package dd.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dd.core.*;

/**
 * Clase que simula el enfrentamiento entre un 
 * ejército de hombres y otro de trolls.
 *
 */
public class DDApp {
    //Random para los ejércitos
    private static  Random r = NumRand.getRand();
    private  List<Personaje> menArmy;
    private  List<Personaje> trollsArmy;

    public DDApp() {
        menArmy = initMenArmy();
        trollsArmy = initTrollsArmy();
    }

    private void showIntro(){
         //Constantes de textos
         final String ARMY_KING = "\033[1m" + "Rey Arturo, Lancelot y Percival" + "\033[0m";
         final String ARMY_TROLLS = "\033[1m" + "3" + "\033[0m";
         final String TITLE = "\n========================== DUNGEON & DRAGONS ==========================";
         final String INTRO = "\nTal día como hoy, en una húmeda y fría mañana de finales de primavera, la partida formada por: ​" + ARMY_KING + ", hallándose en los frondosos bosques del sitio de Deorham, se topó con una patrulla de ​" + ARMY_TROLLS + " de esas sanguinarias e inhumanas criaturas popularmente conocidas como trolls. \n\nDe la batalla que aconteció, dejo aquí testimonio: \n";
         
         //Iniciamos los turnos de la partida:
         System.out.println(TITLE);
         System.out.println(INTRO);
    }

    private void showWinner() {
        if(trollsArmy.size() == 0) {
            System.out.println("Finalmente, el ejército del Rey Arturo venció!!!");
            System.out.println("Los supervivientes de la batalla fueron:");
            System.out.println(menArmy);
        }else if(menArmy.size() == 0) {
            System.out.println("Finalmente, el ejército de los trolls venció!!!");
            System.out.println("Los supervivientes de la batalla fueron:");
            System.out.println(trollsArmy);
        }
    }

    private static List<Personaje> initMenArmy() { 
        //Creamos una lista con los personajes
        List<Personaje> hombres = new ArrayList<>();
        //Creamos los personajes de los hombres con sus tipos de ataque y los añadimos a la lista
        Rey arturo = new Rey("Rey Arturo");
        arturo.setAtaque(new AtaqueEspada());
        hombres.add(arturo);
        Caballero lancelot = new Caballero("Lancelot");
        lancelot.setAtaque(new AtaqueEspada());
        hombres.add(lancelot);
        Caballero percival = new Caballero("Percival");
        percival.setAtaque(new AtaqueArco());
        hombres.add(percival);
        return hombres;
    }

    private static List<Personaje> initTrollsArmy(){
        //Creamos una lista con los personajes
        List<Personaje> trolls = new ArrayList<>();
        //Creamos los personajes de los trolls con sus tipos de ataque y los añadimos a la lista
        int numTrolls = r.nextInt(10 + 1 - 2) + 2; //Numero aleatorio de trolls
        //Creamos los 3 tipos de ataques y los guardamos en una lista
        List<Ataque> listaAtaques = new ArrayList<Ataque>(){{
        add(new AtaqueEspada()); 
        add(new AtaqueArco()); 
        add(new AtaqueCuchillo());}}; 
        for (int i = 1; i <= numTrolls; i++) {
            Troll troll = new Troll("Troll " + i); 
            troll.setAtaque(listaAtaques.get(r.nextInt(3))); //para cada troll asignamos un tipo de ataque aleatorio
            trolls.add(troll); //añadimos los trolls al arraylist
        }
        return trolls;
    }

    private static void clash(List<Personaje> army_att, List<Personaje> army_def) {
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
                    System.out.println(p_def + " muere!");
                    army_def.remove(p_def);
                }
            }
        }
    }

    private void gameRun() {
        while(menArmy.size() > 0 && trollsArmy.size() > 0) {
            //Iniciamos el turno de los hombres
            clash(menArmy, trollsArmy);
            if(trollsArmy.size() > 0)
                clash(trollsArmy, menArmy);
            //Imprimimos un separador entre cada enfrentamiento
            System.out.println(". . .");
        }
    }

    public static void main( String[] args ) {
    
        DDApp game = new DDApp();
        
        game.showIntro();

        game.gameRun();

        game.showWinner();
        
    }
}
