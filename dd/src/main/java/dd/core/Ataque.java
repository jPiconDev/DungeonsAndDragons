package dd.core;

/**
 * Interfaz para implementar los distintos tipos de ataques.
 * @method {@link #lanzaAtaque()} <li>{@link #getArma()}
 */
public interface Ataque{
    /**
     * Disminuye la salud del enemigo en un ​ número
     * entero​ de unidades determinado por la expresión: ​
     * <pre>acierta x factor x ataque​</pre>
     * donde,<p>
     * acierta​ es un número entero aleatorio en el rango [0, 1]<p>
     * factor​ es un número real aleatorio en el rango [0, 1)<p>
     * ataque​ es el valor entero 100 para AtaqueEspada, 50 para AtaqueArco, 25
     * para AtaqueCuchillo<p>
     * El método devolverá un valor entero indicando el resultado del ataque. Este valor
     * será un número positivo indicando el número de unidades de salud descontadas del
     * enemigo en caso de ataque existoso o cero en caso de un ataque fallido (acierta=0)
     * 
     * @param enemigo Personaje
     * @return int Valor entero del resultado del ataque
     */
    public int lanzaAtaque(Personaje enemigo);
}