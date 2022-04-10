
package Paquete;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    int op;
    ArrayList<User> user = new ArrayList<>();
    ArrayList<Game> games = new ArrayList<>();
    boolean can;
    Scanner read = new Scanner(System.in);
    User auxClient;

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
            op = sc.nextInt();
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

    /*  public void list_client_store() {
        System.out.println("Código de tienda: ");
        int cod = read.nextInt();
        ArrayList<User> clientes2;
        can = false;
        tiendas.forEach((store) -> {
            if (store.getCodTienda() == cod) {
                can = true;
                store.clientes.forEach((userData) -> {
                    System.out.println("----------------------------");
                    System.out.println("Nombre: " + userData.getName());
                    System.out.println("Cédula: " + userData.getDni());
                    System.out.println("Correo electronico: " + userData.getEmail());
                    System.out.println("----------------------------");
                });
            }
        });
        if (!can) {
            System.err.println("Tienda no encontrada");
        }
    }*/

 /*public void client_by_cc() {
        System.out.println("Cédula: ");
        int dni = read.nextInt();
        can = false;
        user.forEach((userData) -> {
            if (userData.getDni() == dni) {
                can = true;
                System.out.println("----------------------------");
                System.out.println("Nombre: " + t.getNombre());
                System.out.println("Cédula: " + t.getCedula());

                System.out.println("----------------------------");
            }
        });
        if (!can) {
            System.err.println("Cliente no encontrado");
        }
    }*/

 /*  public void create_a_videoGame() {
        can = true;
        System.out.print("\nCódigo: ");
        int cod = read.nextInt();
        System.out.print("Nombre: ");
        String name = read.next();
        System.out.print("Numero de ejemplares: ");
        int ejemN = read.nextInt();
        System.out.print("Código de tienda: ");
        int codTienda = read.nextInt();

        juegos.forEach((Juego t) -> {
            if (t.getCodJuego() == cod) {
                can = false;
            }
        });
        if (can) {
            can = false;
            Tienda tien = new Tienda();
            tiendas.forEach((t) -> {
                if (t.getCodTienda() == codTienda) {
                    can = true;
                    juegos.add(new Juego(codTienda, name, ejemN, t));
                    System.out.println("Juego creado con exito");
                }
            });
            if (!can) {
                System.err.println("Tienda no encontrada");

            }
        } else {
            System.err.println("Cédula repetida");
        }
    }

    public void list_videogame_by_store() {
        System.out.println("Código de la tienda: ");
        int cod = read.nextInt();
        can = false;

        tiendas.forEach((t) -> {
            if (t.getCodTienda() == cod) {
                can = true;
                t.juegos.forEach((j) -> {
                    System.out.println("----------------------------");
                    System.out.println("Código: " + j.getCodJuego());
                    System.out.println("Nómbre: " + j.getNomJuego());
                    System.out.println("Numero de ejemplares: " + j.getNumEjemplar());
                    System.out.println("----------------------------");
                });
            }
        });
        if (!can) {
            System.err.println("Tienda no encontrada.");
        }
    }

    public void videogame_by_cod() {
        System.out.println("Código: ");
        int cod = read.nextInt();
        can = false;
        juegos.forEach((j) -> {
            if (j.getCodJuego() == cod) {
                can = true;
                System.out.println("----------------------------");
                System.out.println("Código: " + j.getCodJuego());
                System.out.println("Nómbre: " + j.getNomJuego());
                System.out.println("Numero de ejemplares: " + j.getNumEjemplar());
                System.out.println("Tienda: " + j.getTienda().getCodTienda());
                System.out.println("----------------------------");
            }
        });
        if (!can) {
            System.err.println("Juego no encontrado");
        }
    }

    public void rent_a_game() {
        System.out.print("Cédula: ");
        int cc = read.nextInt();
        can = false;
        clientes.forEach((Cliente t) -> {
            if (t.getCedula() == cc) {
                can = true;
                auxClient = t;
            }
        });
        if (can) {
            System.out.print("Código del juego: ");
            int cod = read.nextInt();
            can = false;
            juegos.forEach((j) -> {
                if (j.getCodJuego() == cod) {
                    j.prestamos.add(auxClient);
                    System.out.println("Prestamo realizado");
                }
            });
            if (!can) {
                System.out.println("Juego no encontrado");
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public void list_rent_by_videogame() {
        System.out.print("Código: ");
        int cod = read.nextInt();
        can = false;
        juegos.forEach((Juego t) -> {
            if (t.getCodJuego() == cod) {
                can = true;
                t.prestamos.forEach((p) -> {
                    System.out.println("----------------------------");
                    System.out.println("Nombre: " + p.getNombre());
                    System.out.println("Cédula: " + p.getCedula());
                    System.out.println("Dirección: " + p.getDireccion());
                    System.out.println("Teléfono: " + p.getTelefono());
                    System.out.println("Fecha de nacimiento: " + p.getFechaNac());
                    System.out.println("----------------------------");
                });
            }
        });
        if (!can) {
            System.err.println("Juego no encontrado");
        }
    }

    public void list_rent_by_client() {
        System.out.print("Cédula: ");
        int cc = read.nextInt();
        can = false;
        clientes.forEach((Cliente t) -> {
            if (t.getCedula() == cc) {
                can = true;
                auxClient = t;
            }
        });
        if (can) {

            juegos.forEach((t) -> {
                t.prestamos.forEach((p) -> {
                    if (p.getCedula() == cc) {
                        System.out.println("----------------------------");
                        System.out.println("Nombre: " + p.getNombre());
                        System.out.println("Cédula: " + p.getCedula());
                        System.out.println("Dirección: " + p.getDireccion());
                        System.out.println("Teléfono: " + p.getTelefono());
                        System.out.println("Fecha de nacimiento: " + p.getFechaNac());
                        System.out.println("----------------------------");
                    }
                });
            });
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public void create_store() {
        System.out.print("Código: ");
        int cod = read.nextInt();
        System.out.print("Nombre: ");
        String name = read.next();
        can = true;
        tiendas.forEach((t) -> {
            if (t.getCodTienda() == cod) {
                can = false;
            }
        });
        if (can) {
            System.out.println("Tienda registrada con exito");
            tiendas.add(new Tienda(cod, name));
        } else {
            System.err.println("Código repetido");
        }
    }

    public void client_to_store() {
        System.out.print("Cédula: ");
        int cc = read.nextInt();
        System.out.print("Código de tienda: ");
        int cod = read.nextInt();
        can = false;
        clientes.forEach((t) -> {
            if (t.getCedula() == cc) {
                auxClient = t;
                can = true;
            }
        });
        if (can) {
            can = false;
            tiendas.forEach((t) -> {
                if (t.getCodTienda() == cod) {
                    t.clientes.add(auxClient);
                    can = true;
                }
            });
            if (can) {
                System.out.print("Cliente agregado");
            } else {
                System.out.print("Tienda no encontrada");
            }
        } else {
            System.out.print("Cliente no encontrado");
        }
    } */
}
