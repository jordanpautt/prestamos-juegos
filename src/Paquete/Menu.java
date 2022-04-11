package Paquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    int op;
    ArrayList<User> user = new ArrayList<>();
    ArrayList<Game> games = new ArrayList<>();
    ArrayList<Loan> loans = new ArrayList<>();

    Scanner read = new Scanner(System.in);

    public Menu() {
    }

    public Menu(ArrayList<User> user, ArrayList<Game> games, ArrayList<Loan> loans) {
        this.user = user;
        this.games = games;
        this.loans = loans;
    }

    public void opciones() {
        do {
            System.out.println("-------Menu---------");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Modificar usuarios");
            System.out.println("4. Registrar juegos");
            System.out.println("5. Listar juegos");
            System.out.println("6. Modificar juegos");
            System.out.println("7. prestar juego");
            System.out.println("8. Listar prestamos");
            System.out.println("9. Devolver juego");
            System.out.println("12. Salir");
            System.out.print("--!!opcion: ");
            this.op = read.nextInt();
            switch (op) {
                case 1:
                    this.ingresar_usuario();
                    break;
                case 2:
                    this.list_user();
                    break;
                case 3:
                    this.update_user();
                    break;
                case 4:
                    this.ingresar_game();
                    break;
                case 5:
                    this.list_game();
                    break;
                case 6:
                    this.update_game();
                    break;
                case 7:
                    this.create_loan();
                    break;
                case 8:
                    this.list_loan();
                    break;
                case 9:
                    this.remove_game_loan();
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
        this.user.forEach((userData) -> {
            System.out.println(" Nombre: " + userData.getName());
            System.out.println(" Cédula: " + userData.getDni());
            System.out.println(" Correo electronico: " + userData.getEmail() + "\n,");
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
            this.user.add(new User(dni, name, email));
            System.out.println("Usuario creado con exito");
        } else {
            System.err.println("\nERROR!! Cédula repetida\n");
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
            System.out.println("\nERROR!! Usuario no encontrado ");
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
        System.out.println("--Listar juegos----\n[");
        games.forEach((gameData) -> {
            System.out.println(" Codigo de juego: " + gameData.getCodGame());
            System.out.println(" Codigo de ejemplar: " + gameData.getCodEjem());
            System.out.println(" Nombre juego: " + gameData.getName() + "\n,");
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
            System.err.println("\nERROR!! Juego repetido\n");
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
            System.out.println("\nERROR!! Juego no encontrado ");
        }
    }

    public Loan find_game_loan(int codGame) {
        Loan loanFind = null;
        for (Loan loanData : this.loans) {
            if (loanData.getCodeGame() == codGame) {
                loanFind = loanData;
            }
        }
        return loanFind;
    }

    public void create_loan() {
        System.out.println("--Prestar juego--");
        System.out.print("Cedula del usuario: ");
        int dni = read.nextInt();
        if (this.find_user(dni) == null) {
            System.out.println("\nERROR!! El usuario no existe en el sistema\n");
            return;
        }
        System.out.print("Codigo del juego: ");
        int codGame = read.nextInt();
        if (this.find_game(codGame) == null) {
            System.out.println("\nERROR!! El juego no existe en el sistema\n");
            return;
        } else {
            if (this.find_game_loan(codGame) != null) {
                System.out.println("\nERROR!! El juego ya esta prestado\n");
                return;
            }
        }
        System.out.print("Fecha del prestamo: ");
        String date = read.next();

        this.loans.add(new Loan(this.loans.size() + 1, codGame, dni, date));
        System.out.println("Prestamo creado con exito");
    }

    public void list_loan() {
        System.out.println("--Lista de prestamos----\n[");
        this.loans.forEach((loanData) -> {
            System.out.println(" Codigo de prestamo: " + loanData.getCodeLoan());
            System.out.println(" Codigo de usuario: " + loanData.getCodeuser());
            System.out.println(" Codigo de juego: " + loanData.getCodeGame());
            System.out.println(" Fecha de prestamo: " + loanData.getDate() + "\n,");
        });
        System.out.println("]\n---------------------");
    }

    public void remove_game_loan() {
        System.out.println("---Devolver juego prestado--");
        System.out.print("Codigo del juego: ");
        int codGame = read.nextInt();
        Loan loanGame = this.find_game_loan(codGame);
        if (loanGame == null) {
            System.out.println("\nERROR!! El juego no esta prestado\n");
            return;
        } else {
            this.loans.remove(loanGame);
            System.out.println("Juego entregado con exito");
        }
    }

}
