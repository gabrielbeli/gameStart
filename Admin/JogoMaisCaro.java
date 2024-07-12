package Admin;

import java.io.FileNotFoundException;

import static Admin.PesquisaCliente.pesquisaCliente;
import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class JogoMaisCaro {

    public static void jogoMaisCaro(String caminhoVendas, String caminhoClientes) throws FileNotFoundException {
        String[][] matrizVendas = gerarMatriz(caminhoVendas);

        double maiorPreco = 0;
        String nomeJogoMaisCaro = "";

        for (int X = 1; X < matrizVendas.length; X++) {

            double preco = Double.parseDouble(matrizVendas[X][5]);

            if (preco > maiorPreco) {
                maiorPreco = preco;
                nomeJogoMaisCaro = matrizVendas[X][4];
            }
        }

        System.out.println("Jogo mais caro: " + nomeJogoMaisCaro + " (" + maiorPreco + " €)");

        System.out.println("\nClientes que compraram o jogo mais caro:");

        for (int X = 1; X < matrizVendas.length; X++) {

            String nomeJogo = matrizVendas[X][4];

            if (nomeJogo.equals(nomeJogoMaisCaro)) {
                int idCliente = Integer.parseInt(matrizVendas[X][1]);
                pesquisaCliente(caminhoClientes, idCliente);
            }
        }
    }

}
