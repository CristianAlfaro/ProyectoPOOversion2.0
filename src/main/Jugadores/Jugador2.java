package main.Jugadores;


public class Jugador2 implements Jugadores{

    private String nombre;

    private static Jugador2 jugador2;

    public Jugador2(){}

    public static Jugador2 getInstance(){
        if(jugador2 == null){
            jugador2 = new Jugador2();
        }
        return jugador2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
