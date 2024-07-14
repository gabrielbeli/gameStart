package BaseFuncoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Admin.AdminMenu.adminMenu;
import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;
import static Cliente.ClienteMenu.clienteMenu;

public class Login {

    /**
     * Método: Menu principal usado para identificar se é um usuario admin ou cliente e para encerrar
     * @return 1-admin, 2-cliente, 3-sair
     */
    public static void login() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("               ***** Bem vindo a melhor loja gamer! *****\n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                                1.Admin");
            System.out.println("                                2.Cliente");
            System.out.println("                                3.Sair\n");
            System.out.print("     \uD83D\uDD79\uFE0F Opção: ");

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

    /**
     * Método: Usado para receber e armazenar os dados do usuario
     * @param input inserido pelo usuário de indetifcação e senha
     * @return o username e o password captados para seguir para validação
     */
    private static boolean autenticadoAdmin(Scanner input) throws FileNotFoundException {
        System.out.print("     \uD83D\uDC64Usuário: ");
        String username = input.next();

        System.out.print("     \uD83D\uDD12Senha: ");
        String password = input.next();

        return autenticado(username, password);

    }

    /**
     * Método: Usado para comparar as informações inseridas pelo usuário com o arquivo e permitir acesso
     * @param username inserido pelo usuário
     * @param password inserido pelo usuário
     * @return autenticado, permitindo o acesso
     */
    private static boolean autenticado(String username, String password) throws FileNotFoundException {

        boolean autenticado = false;

        Scanner scanner = new Scanner(new File("Ficheiros/GameStart_Admins.csv"));
        String linha;

        while (scanner.hasNext() && (linha = scanner.nextLine()) != null) {

            String[] componente = linha.split(";");
            String fileUsername = componente[0];
            String filePassword = componente[1];

            if (componente.length == 2) {

                if (fileUsername.equals(username) && filePassword.equals(password)) {
                    autenticado = true;
                }
            }
        }
        return autenticado;
    }

    /**
     * Método: Usado para simular um acesso de cliente
     * @param input de dados inserido pelo usuário
     * @return true se os dados foram inseridos
     */
    private static boolean autenticadoCliente(Scanner input) {

        System.out.println("                         \uD83E\uDEAA Faça seu cadastro \uD83E\uDEAA \n");

        System.out.print("     \uD83D\uDC64 Usuário: ");
        input.nextLine();
        String username = input.next();

        input.nextLine();
        System.out.print("     \uD83D\uDD12 Senha: ");
        String password = input.next();

        System.out.print("     \uD83D\uDCE7 E-mail: ");
        String email = input.next();

        System.out.print("     ☎\uFE0F Telemóvel: ");
        int phone = input.nextInt();

        System.out.println("\n                      Cadastro criado com sucesso! \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB \n ");
        System.out.println("                    "+ username + " | " + phone + " | " + email + "\n");

        return true;
    }

}



