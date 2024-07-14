package Admin.Vendas;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class TotalLucro {

    public static void totalGeralLucro(String caminhoVendas, String caminhoPorcentagens) throws FileNotFoundException {
        String[][] matrizVendas = gerarMatriz(caminhoVendas);
        String[][] matrizPorcentagens = gerarMatriz(caminhoPorcentagens);

        double totalLucro = 0.0;

        for (int X = 1; X < matrizVendas.length; X++) {

            double valorVenda = Double.parseDouble(matrizVendas[X][5]);
            String categoriaJogo = matrizVendas[X][3];
            double porcentagemMargem = 0.0;

            for (int Y = 1; Y < matrizPorcentagens.length; Y++) {
                if (matrizPorcentagens[Y][0].equalsIgnoreCase(categoriaJogo)) {
                    porcentagemMargem = Double.parseDouble(matrizPorcentagens[Y][1]);
                    break;
                }
            }

            double custoProduto = valorVenda * (1 * (porcentagemMargem) / 100);

            totalLucro += custoProduto;

        }

        System.out.println("\nTotal Geral de Lucro das Vendas\n");
        System.out.printf(""+totalLucro);
    }
}
