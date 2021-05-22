package dd.core;

import java.util.ArrayList;
/**
 * Clase abstracta que define los distintos tipos de personajes y sus métodos
 * 
 * @method {@link #setAtaque(Ataque ataque)}
 * <li> {@link #getNombre()}
 * <li> {@link #getSalud()}
 * <li> {@link #updateSalud(int value)}
 * <li> {@link #getArma()}
 * <li> {@link #ataca(Personaje enemigo)}
 * <li> {@link #toString()}
 */
public abstract class Personaje {
    protected String nombre;
    protected int salud;
    protected Ataque ataque;
    protected int numAtq;
    protected String arma;

    /**
     * Constructor de la clase Personaje que implementan los distintos tipos de personajes
     * @param nombre
     */
    public Personaje(String nombre){
        this.nombre = nombre;
    }

    /**
     * Establece el tipo de ataque del personaje
     * 
     * @param ataque
     */
    public void setAtaque(Ataque ataque){
        this.ataque = ataque;
        this.arma = ataque.getArma();
    }
    
    /**
     * Devuelve el nombre del personaje
     * @return nombre del personaje
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la salud del personaje
     * @return salud del personaje
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Actualiza la salud del personaje
     * @return salud del personaje
     */
    public int updateSalud(int value) {
        salud -= value;
        return value;
    }

    /**
     * Método que devuelve el tipo de arma usada por el personaje
     * @return String El tipo de arma
     */
    public String getArma() {
        return arma;
    }

    /**
     * Método abstracto que almacena en un ArrayList el resultado de cada ataque.
     * @param enemigo 
     * @return ataque ArrayList
     */
    public abstract ArrayList<Integer> ataca(Personaje enemigo);

    @Override
    public String toString() {
        String tipo = "";
        if(this instanceof Rey) tipo = "KING";
        if(this instanceof Caballero) tipo = "KNIGHT";
        if(this instanceof Troll) tipo = "TROLL";
        return "[" + tipo + " " + this.nombre + ": " + this.salud + "]";
    }
}