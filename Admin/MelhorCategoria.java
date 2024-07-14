package Admin;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class MelhorCategoria {

    /**
     * Método: Encontra a categoria que mais vendeu e apresenta seu lucro total
     * @return imprime em tela o melhor cliente e suas informações
     * @param caminhoVendas arquivo das vendas
     * @param caminhoPercentagens arquivo com a referencia de percentagens
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void categoriaMaisLucrativa(String caminhoVendas, String caminhoPercentagens) throws FileNotFoundException {

        String[][] matrizVendas = gerarMatriz(caminhoVendas);
        String[][] matrizPorcentagens = gerarMatriz(caminhoPercentagens);

        String[] categorias = new String[matrizPorcentagens.length];
        double[] lucros = new double[matrizPorcentagens.length];

        // Começo percebendo das categorias dentro da matriz de percentagem
        for (int X = 0; X < matrizPorcentagens.length; X++) {
            categorias[X] = matrizPorcentagens[X][0];
        }

        // Percorro cada categoria
        for (int CT = 0; CT < categorias.length; CT++) {

            String categoriaAtual = categorias[CT];

            // Percorro a matriz de vendas para calcular
            for (int VD = 1; VD < matrizVendas.length; VD++) {

                String categoriaJogo = matrizVendas[VD][3];
                double valorVenda = Double.parseDouble(matrizVendas[VD][5]);

                // Verificar se a venda pertence à categoria atual
                if (categoriaJogo.equalsIgnoreCase(categoriaAtual)) {
                    double porcentagemMargem = 0.0;

                    // Aqui eu defino a porcentagem
                    for (int PG = 0; PG < matrizPorcentagens.length; PG++) {

                        if (matrizPorcentagens[PG][0].equalsIgnoreCase(categoriaJogo)) {
                            porcentagemMargem = Double.parseDouble(matrizPorcentagens[PG][1]);
                        }
                    }

                    // Faço a conta e acrescento ao valor atual
                    double lucroJogo = valorVenda * (porcentagemMargem / 100.0);
                    lucros[CT] += lucroJogo;
                }
            }
        }

        String categoriaMaisLucrativa = null;
        double lucroMais = 0.0;

        // Aqui encontro a categoria de maior lucro geral
        for (int X = 0; X < categorias.length; X++) {
            if (lucros[X] > lucroMais) {
                lucroMais = lucros[X];
                categoriaMaisLucrativa = categorias[X];
            }
        }

        System.out.println("\n     \uD83C\uDFC6 Categoria + lucrativa\n");
        System.out.println("     \uD83D\uDC51 "+categoriaMaisLucrativa);
        System.out.println("     \uD83D\uDCB5 Lucro Gerado: " + lucroMais + " € ");
    }

}




