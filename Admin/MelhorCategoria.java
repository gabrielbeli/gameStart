package Admin;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class MelhorCategoria {

    public static void categoriaMaisLucrativa(String caminhoVendas, String caminhoPorcentagens) throws FileNotFoundException {

        String[][] matrizVendas = gerarMatriz(caminhoVendas);
        String[][] matrizPorcentagens = gerarMatriz(caminhoPorcentagens);


        String[] categorias = new String[matrizPorcentagens.length];
        double[] lucros = new double[matrizPorcentagens.length];


        for (int X = 0; X < matrizPorcentagens.length; X++) {
            categorias[X] = matrizPorcentagens[X][0];
            lucros[X] = 0.0;
        }

        for (int X = 0; X < matrizVendas.length; X++) {
            String categoriaJogo = matrizVendas[X][3];
            double valorVenda = Double.parseDouble(matrizVendas[X][5]);

            double porcentagemMargem = 0.0;
            for (int Y = 0; Y < matrizPorcentagens.length; Y++) {
                if (matrizPorcentagens[Y][0].equalsIgnoreCase(categoriaJogo)) {
                    porcentagemMargem = Double.parseDouble(matrizPorcentagens[Y][1]);
                }
            }

            double lucroJogo = valorVenda * (porcentagemMargem / 100.0);

            for (int k = 0; k < categorias.length; k++)
                if (categorias[k].equalsIgnoreCase(categoriaJogo)) {
                    lucros[k] += lucroJogo;
                }
        }

        String categoriaMaisLucrativa = null;
        double lucroMais = 0.0;
        for (int X = 0; X < lucros.length; X++) {
            if (lucros[X] > lucroMais) {
                lucroMais = lucros[X];
                categoriaMaisLucrativa = categorias[X];
            }
        }

        System.out.println("\nCategoria Mais Lucrativa\n");
        System.out.println(categoriaMaisLucrativa);
        System.out.println("Lucro Gerado: " + lucroMais + " € ");
    }
}




