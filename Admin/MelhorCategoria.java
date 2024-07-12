package Admin;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class MelhorCategoria {

    public static void categoriaMaisLucrativa(String caminhoVendas, String caminhoPorcentagens) throws FileNotFoundException {

        String[][] matrizVendas = gerarMatriz(caminhoVendas);
        String[][] matrizPorcentagens = gerarMatriz(caminhoPorcentagens);

        String categoriaMaisLucrativa = "";
        double lucroMaisLucrativo = 0.0;

        for (int X = 1; X < matrizVendas.length; X++) {

            String categoriaJogo = matrizVendas[X][3];
            double valorVenda = Double.parseDouble(matrizVendas[X][5]);

            double porcentagemMargem = 0.0;
            for (int Y = 1; Y < matrizPorcentagens.length; Y++) {
                if (matrizPorcentagens[Y][0].equalsIgnoreCase(matrizVendas[X][3])) {
                    porcentagemMargem = Double.parseDouble(matrizPorcentagens[Y][1]);
                    break;
                }
            }

            double custoJogo = valorVenda / (1+ (porcentagemMargem / 100.0));
            double lucroJogo = valorVenda - custoJogo;

            if (lucroJogo > lucroMaisLucrativo) {
                lucroMaisLucrativo = lucroJogo;
                categoriaMaisLucrativa = categoriaJogo;
            }
        }

        System.out.println("\nCategoria Mais Lucrativa\n");
        System.out.println(categoriaMaisLucrativa);
        System.out.println("Lucro Gerado: " + lucroMaisLucrativo + " € ");
    }
}
