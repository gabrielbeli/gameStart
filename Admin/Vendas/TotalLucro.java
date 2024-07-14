package Admin.Vendas;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class TotalLucro {

    /**
     * Método: Calcular o lucro geral das vendas
     * @return imprime em tela o valor total de lucro
     * @param caminhoVendas arquivo de vendas
     * @param caminhoPercentagens arquivo das percentagens por categoria
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void totalGeralLucro(String caminhoVendas, String caminhoPercentagens) throws FileNotFoundException {
        String[][] matrizVendas = gerarMatriz(caminhoVendas);
        String[][] matrizPorcentagens = gerarMatriz(caminhoPercentagens);

        double totalLucro = 0.0;

        for (int X = 1; X < matrizVendas.length; X++) {

            double valorVenda = Double.parseDouble(matrizVendas[X][5]);
            String categoriaJogo = matrizVendas[X][3];
            double porcentagemMargem = 0.0;

            for (int Y = 1; Y < matrizPorcentagens.length; Y++) {
                if (matrizPorcentagens[Y][0].equalsIgnoreCase(categoriaJogo)) {
                    porcentagemMargem = Double.parseDouble(matrizPorcentagens[Y][1]);
                }
            }

            double custoProduto = valorVenda * (1 * (porcentagemMargem) / 100);

            totalLucro += custoProduto;

        }

        System.out.println("\n     \uD83D\uDCB5 Lucro total: " + totalLucro);
    }
}
