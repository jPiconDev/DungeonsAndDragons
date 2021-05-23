package dd.App;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import dd.core.*;

/**
 * Clase que simula el enfrentamiento entre un 
 * ejército de hombres y otro de trolls.
 *
 */
public class DDApp {
    public static void main( String[] args ) {
        final String ARMY_KING = "\033[1m" + "Rey Arturo, Lancelot y Percival" + "\033[0m";
        final String ARMY_TROLLS = "\033[1m" + "3" + "\033[0m";
        final String TITLE = "\n========================== DUNGEON & DRAGONS ==========================";
        final String INTRO = "\nTal día como hoy, en una húmeda y fría mañana de finales de primavera, la partida formada por: ​" + ARMY_KING + ", hallándose en los frondosos bosques del sitio de Deorham, se topó con una patrulla de ​" + ARMY_TROLLS + " de esas sanguinarias e inhumanas criaturas popularmente conocidas como trolls. \n\nDe la batalla que aconteció, dejo aquí testimonio: \n";

        //Creamos dos listas con los personajes
        ArrayList<Personaje> hombres = new ArrayList<>();
        ArrayList<Personaje> trolls = new ArrayList<>();

        //Random para los ejércitos
        //long seed = 12345678L;
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
        Rey arturo = new Rey("Rey Arturo");
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
        int numTrolls = rand.nextInt(10 + 1 - 2) + 2; //Numero aleatorio de trolls

        for (int i = 1; i <= numTrolls; i++) {
            trolls.add(new Troll("Troll " + i)); //añadimos los trolls al arraylist
        }
        for (Personaje troll : trolls) {
            troll.setAtaque(listaAtaques.get(rand.nextInt(3))); //para cada troll asignamos un tipo de ataque aleatorio
        }

        //Iniciamos los turnos de la partida:
        System.out.println(TITLE);
        System.out.println(INTRO);

        while(hombres.size() > 0 && trolls.size() > 0) {
            //Iniciamos el turno de los hombres
            for (Personaje hombre : hombres) {
                if(trolls.size() > 0){
                    Personaje troll = trolls.get(rand.nextInt(trolls.size())); //seleccionamos un troll aleatorio
                    System.out.println(hombre + " lucha contra " + troll);
                    ArrayList<Integer> listaSalud = hombre.ataca(troll); //creamos una lista con los resultados de cada ataque
                    for (int i = 0; i < listaSalud.size(); i++) {
                        String salud = listaSalud.get(i) == 0 ? "falla" : "-" + listaSalud.get(i).toString();
                        System.out.println("Ataque con " + hombre.getArma() + "(" + salud + ")");
                    }
                    if(troll.getSalud() <= 0) {
                        trolls.remove(troll); //si el enemigo se queda sin salud se elimina de la lista
                        System.out.println(troll + " muere!");
                    }
                }
            }
            //si la lista de enemigos queda vacía generamos el resultado
            if(trolls.size() == 0) {
                System.out.println("Finalmente, el ejército del Rey Arturo venció!!!");
                System.out.println("Los supervivientes de la batalla fueron:");
                String vencedores = "{";
                //Creamos un iterador para controlar las impresiones del ArrayList:                
                Iterator<Personaje> itHombres = hombres.iterator(); // creamos un iterador pra controlar la impresion de la lista
                while(itHombres.hasNext()) { //recorremos la lista y agregamos a un string todos los personajes resultantes
                    Personaje hombre = itHombres.next();
                    vencedores += hombre;
                    if(itHombres.hasNext()) vencedores += ", ";
                }
                vencedores += "}";
                System.out.println(vencedores);
                break;
            }
            for (Personaje troll : trolls) {
                if(hombres.size() > 0){
                    Personaje hombre = hombres.get(rand.nextInt(hombres.size()));
                    System.out.println(troll + " lucha contra " + hombre);
                    ArrayList<Integer> listaSalud = troll.ataca(hombre);
                    for (int i = 0; i < listaSalud.size(); i++) {
                        String salud = listaSalud.get(i) == 0 ? "falla" : "-" + listaSalud.get(i).toString();
                        System.out.println("Ataque con " + hombre.getArma() + "(" + salud + ")");
                    }
                    if(hombre.getSalud() <= 0) {
                        hombres.remove(hombre);
                        System.out.println(hombre + " muere!");
                    }
                }
            }
            if(hombres.size() == 0) {
                System.out.println("Finalmente, el ejército de los trolls venció!!!");
                System.out.println("Los supervivientes de la batalla fueron:");
                String vencedores = "{";
                //Creamos un iterador para controlar las impresiones del ArrayList:
                Iterator<Personaje> itTrolls = trolls.iterator();
                for (Personaje troll : trolls) {
                    vencedores += troll;
                    if(itTrolls.hasNext()) vencedores += ", ";
                }
                while(itTrolls.hasNext()) {
                    Personaje troll = itTrolls.next();
                    vencedores += troll;
                    if(itTrolls.hasNext()) vencedores += ", ";
                }
                vencedores += "}";
                System.out.println(vencedores);
                break;
            }
            System.out.println(". . .");
        }
    }
}
