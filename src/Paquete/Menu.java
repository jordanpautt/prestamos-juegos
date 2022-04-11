
package Paquete;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    int op;
    ArrayList<User> user = new ArrayList<>();
    ArrayList<Game> games = new ArrayList<>();
  
    Scanner read = new Scanner(System.in);
 
    public Menu() {
    }

    public Menu(ArrayList<User> user, ArrayList<Game> games) {
        this.user = user;
        this.games = games;
    }

    public void opciones() {
        do {
            System.out.println("-------Menu---------");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Modificar usuarios");
            System.out.println("12. Salir");
            System.out.print("opcion: ");
            op = read.nextInt();
            switch (op) {
                case 1:
                    ingresar_usuario();
                    break;
                case 2:
                    list_user();
                    break;
                case 3:
                    update_user();
                    break;
                 case 4:
                    ingresar_game();
                    break;
                case 5:
                    list_game();
                    break;
                case 6:
                    update_game();
                    break;
            }
        } while (op != 12);

    }

    public User find_user(int dni) {
        User userFind = null;
        for (User userData : user) {
            if (userData.getDni() == dni) {
                userFind = userData;
            }
        }
        return userFind;
    }

    public void list_user() {
        System.out.println("--List Users----\n[");
        user.forEach((userData) -> {
            System.out.println(" Nombre: " + userData.getName());
            System.out.println(" Cédula: " + userData.getDni());
            System.out.println(" Correo electronico: " + userData.getEmail() + "\n ------ \n");
        });
        System.out.println("]\n---------------------");
    }

    public void ingresar_usuario() {
        System.out.print("\nCédula: ");
        int dni = read.nextInt();
        System.out.print("Nombre: ");
        String name = read.next();
        System.out.print("Correo electronico: ");
        String email = read.next();

        User userAdd = find_user(dni);
        if (userAdd == null) {
            user.add(new User(dni, name, email));
            System.out.println("Usuario creado con exito");
        } else {
            System.err.println("Cédula repetida");
        }
    }

    public void update_user() {
        System.out.println("--Modificar usuario--");
        System.out.print("Cedula del usuario a modificar: ");
        int dniUser = read.nextInt();

        User userUpdate = find_user(dniUser);
        if (userUpdate != null) {
            System.out.print("Nuevo nombre: ");
            String nameUser = read.next();
            System.out.print("Nuevo correo: ");
            String emailUser = read.next();
            userUpdate.setName(nameUser);
            userUpdate.setEmail(emailUser);
        } else {
            System.out.println("Usuario no encontrado ");
        }
    }

    public Game find_game(int codGame) {
        Game gameFind = null;
        for (Game gameData : games) {
            if (gameData.getCodGame() == codGame) {
                gameFind = gameData;
            }
        }
        return gameFind;
    }

    public void list_game() {
        System.out.println("--List Games----\n[");
        games.forEach((gameData) -> {
            System.out.println(" Codigo de juego: " + gameData.getCodGame());
            System.out.println(" Codigo de ejemplar: " + gameData.getCodEjem());
            System.out.println(" Nombre juego: " + gameData.getName() + "\n ------ \n");
        });
        System.out.println("]\n---------------------");
    }

    public void ingresar_game() {
        System.out.print("\nCodigo del juego: ");
        int codGame = read.nextInt();
        System.out.print("Codigo de ejemplar: ");
        int codEjem = read.nextInt();
        System.out.print("Nombre del juego: ");
        String name = read.next();

        Game gameAdd = find_game(codGame);
        if (gameAdd == null) {
            games.add(new Game(name, codGame, codEjem));
            System.out.println("Juego creado con exito");
        } else {
            System.err.println("Juego repetido");
        }
    }

    public void update_game() {
        System.out.println("--Modificar juego--");
        System.out.print("Codigo del juego a modificar: ");
        int codGame = read.nextInt();

        Game gameUpdate = find_game(codGame);
        if (gameUpdate != null) {
            System.out.print("Nuevo nombre: ");
            String nameUser = read.next();
           
            gameUpdate.setName(nameUser);
        } else {
            System.out.println("Juego no encontrado ");
        }
    }
    
    public void create_loan(){
        
    }
         
}
