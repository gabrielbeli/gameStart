package Admin;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Admin.PesquisaCliente.pesquisaCliente;
import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class PesquisaVendas {

    public static void pesquisarJogo(String caminhoVendas, String nomeJogo) throws FileNotFoundException {
        String[][] matrizVendas = gerarMatriz(caminhoVendas);

        boolean jogoEncontrado = false;

        for (int X = 1; X < matrizVendas.length; X++) {
            String jogo = matrizVendas[X][4];

            if (jogo.equalsIgnoreCase(nomeJogo)) {
                if (!jogoEncontrado) {
                    System.out.println("\n" + nomeJogo);
                    jogoEncontrado = true;
                }

                int idCliente = Integer.parseInt(matrizVendas[X][1]);
                pesquisaCliente("Ficheiros/GameStart_Clientes.csv", idCliente);
            }
        }

        if (!jogoEncontrado) {
            System.out.println("Jogo não encontrado.");
        }
    }

    public static String obterNomeJogo() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n     \uD83D\uDD0D Digite o nome do jogo: ");
        String nomeJogo = input.nextLine();

        return nomeJogo;
    }
}
