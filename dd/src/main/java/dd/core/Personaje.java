package dd.core;

public abstract class Personaje {
    private String nombre;
    protected int salud;
    protected Ataque ataque;

    public Personaje(String nombre){
        this.nombre = nombre;
    }

    public void setAtaque(Ataque ataque){
        this.ataque = ataque;
    }

    public abstract void ataca(Personaje enemigo);

    @Override
    public String toString() {
        return "[ " + this.nombre + " ]";
    }

}