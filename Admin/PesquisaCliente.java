package Admin;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class PesquisaCliente {

    public static void pesquisaCliente(String caminho, int idCliente) throws FileNotFoundException {
        String[][] matriz = gerarMatriz(caminho);

        boolean encontrouCliente = false;

        for (int X = 1; X < matriz.length; X++) {
            int id = Integer.parseInt(matriz[X][0]);
            String nome = matriz[X][1];
            String telemovel = matriz[X][2];
            String email = matriz[X][3];

            if (id == idCliente) {
                System.out.println("\nNome: " + nome);
                System.out.println("Telemóvel: " + telemovel);
                System.out.println("Email: " + email + "\n");
                encontrouCliente = true;
                break;
            }
        }

        if (!encontrouCliente) {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static int obterIdCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        return idCliente;
    }
}
