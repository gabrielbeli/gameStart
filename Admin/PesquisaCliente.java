package Admin;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class PesquisaCliente {

    /**
     * Método: Usado para pesquisar um cliente através do id de identificação dele
     * @return imprime em tela o melhor cliente e suas informações
     * @param caminho arquivo com os dados dos clientes
     * @param idCliente input do usuario captado na função auxiliar
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void pesquisaCliente(String caminho, int idCliente) throws FileNotFoundException {
        String[][] matriz = gerarMatriz(caminho);

        boolean encontrouCliente = false;

        //Aqui eu percorro da lista e se encontrado o id imprimo em tela as informações
        for (int X = 1; X < matriz.length; X++) {
            int id = Integer.parseInt(matriz[X][0]);
            String nome = matriz[X][1];
            String telemovel = matriz[X][2];
            String email = matriz[X][3];

            if (id == idCliente) {
                System.out.println("\n     \uD83E\uDEAA Nome: " + nome);
                System.out.println("     ☎\uFE0F Telemóvel: " + telemovel);
                System.out.println("     \uD83D\uDCE7 Email: " + email + "\n");
                encontrouCliente = true;
            }
        }

        if (!encontrouCliente) {
            System.out.println("Cliente não encontrado.");
        }
    }

    /**
     * Método: Função para receber o id do cliente através do input
     * @return idCliente, numero inserido pelo utilizador
     */
    public static int obterIdCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n     \uD83D\uDD0D Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        return idCliente;
    }
}
