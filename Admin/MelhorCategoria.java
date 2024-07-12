package Admin;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class MelhorCategoria {

    public static void categoriaMaisLucrativa(String caminhoVendas, String caminhoPorcentagens) throws FileNotFoundException {

        String[][] matrizVendas = gerarMatriz(caminhoVendas);
        String[][] matrizPorcentagens = gerarMatriz(caminhoPorcentagens);

        String categoriaMaisLucrativa = "";
        double lucroMais = 0.0;
        boolean encontrouCategoria = false;

        for(int X = 0; X < matrizVendas.length; X++) {
            String categoriaJogo = matrizVendas[X][3];
            System.out.println(categoriaJogo);
        }

        for (int X = 0; X < matrizVendas.length; X++) {

            double valorVenda = Double.parseDouble(matrizVendas[X][5]);
            String categoriaJogo = matrizVendas[X][3];
            double porcentagemMargem = 0.0;

            for (int Y = 0; Y < matrizPorcentagens.length; Y++) {
                if (matrizPorcentagens[Y][0].equalsIgnoreCase(categoriaJogo)) {
                    porcentagemMargem = Double.parseDouble(matrizPorcentagens[Y][1]);

                }
            }

            double custoJogo = valorVenda * ((porcentagemMargem / 100.0));
            double lucroJogo = custoJogo;

            if (lucroJogo > lucroMais) {
                lucroMais += lucroJogo;
                categoriaMaisLucrativa = categoriaJogo;
            }
        }

        System.out.println("\nCategoria Mais Lucrativa\n");
        System.out.println(categoriaMaisLucrativa);
        System.out.println("Lucro Gerado: " + lucroMais + " € ");
    }
}

