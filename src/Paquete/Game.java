package Paquete;

import java.util.ArrayList;

public class Game {

    private String name;
    private int codGame;
    private int codEjem;
    public ArrayList<User> prestamos = new ArrayList<>();
    
    public Game(){
        
    }

    public Game(String name, int codGame, int codEjem) {
        this.codEjem = codEjem;
        this.codGame = codGame;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCodGame() {
        return codGame;
    }

    public void setCodGame(int codGame) {
        this.codGame = codGame;
    }

    public int getCodEjem() {
        return codEjem;
    }

    public void setCodEjem(int codEjem) {
        this.codEjem = codEjem;
    }

    public void listarTiendas() {
    }
}
