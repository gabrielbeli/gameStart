package BaseFuncoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Admin.AdminMenu.adminMenu;
import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;
import static Cliente.ClienteMenu.clienteMenu;

public class Login {

    public static void login() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("               ***** Bem vindo a melhor loja gamer! *****\n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                                1.Admin");
            System.out.println("                                2.Cliente");
            System.out.println("                                3.Sair\n");
            System.out.print("     \uD83D\uDD79\uFE0FOpção: ");

            int menu = input.nextInt();
            System.out.println();

            switch (menu) {
                case 1:
                    if (autenticadoAdmin(input)) {
                        adminMenu();
                    } else {
                        System.out.println("Login incorreto! \n");
                    }
                    break;
                case 2:
                    if (autenticadoCliente(input)){
                        System.out.println("                             \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E");
                        clienteMenu();
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("                            ✌\uFE0F GAMEOVER \uD83E\uDEE1 \n");
                    imprimirAquivo("Ficheiros/GameStart_Copyright.txt");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        input.close();
    }

    private static boolean autenticadoAdmin(Scanner input) throws FileNotFoundException {
        System.out.print("Usuário: ");
        String username = input.next();

        System.out.print("Senha numerica: ");
        String password = input.next();


        return autenticado(username, password);

    }

    private static boolean autenticado(String username, String password) throws FileNotFoundException {
        boolean autenticado = false;

        Scanner reader = new Scanner(new File("Ficheiros/GameStart_Admins.csv"));
        String line;

        while (reader.hasNext() && (line = reader.nextLine()) != null) {

            String[] parts = line.split(";");
            String fileUsername = parts[0];
            String filePassword = parts[1];

            if (parts.length == 2) {

                if (fileUsername.equals(username) && filePassword.equals(password)) {
                    autenticado = true;
                    break;
                }
            }
        }
        return autenticado;
    }

    private static boolean autenticadoCliente(Scanner input) {

        System.out.println("                         \uD83E\uDEAA Faça seu cadastro \uD83E\uDEAA \n");

        System.out.print("Usuário: ");
        String username = input.next();

        System.out.print("Senha numerica de 6 digitos: ");
        int password = input.nextInt();

        System.out.print("E-mail: ");
        String email = input.next();

        System.out.print("Telemóvel: ");
        int phone = input.nextInt();

        System.out.println();
        System.out.println("Cliente: " + username + " | " + phone + " | " + email + " | inserido com sucesso!\n");

        return true;
    }

}



