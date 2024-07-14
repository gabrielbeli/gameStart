package Admin.Vendas;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Admin.PesquisaCliente.pesquisaCliente;
import static BaseFuncoes.DisparoArquivos.caminhosDosArquivos;
import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class PesquisaVendas {

    /**
     * Método: filtrar vendas pelo nome do jogo
     * @return imprime em tela as pessoas que compraram o jogo filtrado
     * @param caminhoVendas arquivo de vendas
     * @param nomeJogo input captado do usuário
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void pesquisarJogo(String caminhoVendas, String nomeJogo) throws FileNotFoundException {
        String[][] matrizVendas = gerarMatriz(caminhoVendas);

        boolean jogoEncontrado = false;

        for (int X = 1; X < matrizVendas.length; X++) {
            String jogo = matrizVendas[X][4];

            if (jogo.equalsIgnoreCase(nomeJogo)) {
                if (!jogoEncontrado) {
                    System.out.println("\n" + "     \uD83C\uDFAE "+nomeJogo);
                    jogoEncontrado = true;
                }

                int idCliente = Integer.parseInt(matrizVendas[X][1]);
                pesquisaCliente(caminhosDosArquivos(4), idCliente);
            }
        }

        if (!jogoEncontrado) {
            System.out.println("Jogo não encontrado.");
        }
    }

    /**
     * Método: Captar input de usuário do nome do jogo a ser filtrado
     * @return o nome do jogo para a função de pesquisa
     */
    public static String obterNomeJogo() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n     \uD83D\uDD0D Digite o nome do jogo: ");
        String nomeJogo = input.nextLine();

        return nomeJogo;
    }
}
