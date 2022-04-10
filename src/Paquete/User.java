package Paquete;

import java.util.ArrayList;

public class User {

    private int dni;
    private String name;
    private String email;

    public User() {
    }

    public User(int dni, String name, String email) {
        this.dni = dni;
        this.name = name;
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void listarTiendas() {
    }
}
