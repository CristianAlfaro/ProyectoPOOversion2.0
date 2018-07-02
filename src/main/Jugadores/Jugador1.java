package main.Jugadores;


public class Jugador1 implements Jugadores{

    private String nombre;

    private static Jugador1 jugador1;

    public Jugador1(){}

    public static Jugador1 getInstance(){
        if(jugador1 == null){
            jugador1 = new Jugador1();
        }
        return jugador1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
