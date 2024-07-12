package Admin;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class Top5Jogos {

    public static void topJogosLucro(String caminhoVendas, String caminhoPorcentagens, int numeroJogos) throws FileNotFoundException {

        String[][] matrizVendas = gerarMatriz(caminhoVendas);
        String[][] porcentagensMargem = gerarMatriz(caminhoPorcentagens);

        String[][] jogosLucro = new String[matrizVendas.length][2];
        int totalJogos = 0;

        for (int X = 1; X < matrizVendas.length; X++) {
            String nomeJogo = matrizVendas[X][4];
            double valorVenda = Double.parseDouble(matrizVendas[X][5]);
            String categoriaJogo = matrizVendas[X][3];

            double percentagemMargem = porcentagemMargem(categoriaJogo, porcentagensMargem);

            double lucro = valorVenda * (percentagemMargem / 100.0);

            boolean jogoRegistrado = false;

            for (int Y = 0; Y < totalJogos; Y++) {

                if (jogosLucro[Y][0].equalsIgnoreCase(nomeJogo)) {
                    double lucroAtual = Double.parseDouble(jogosLucro[Y][1]);
                    jogosLucro[Y][1] = Double.toString(lucroAtual + lucro);
                    jogoRegistrado = true;
                }
            }

            if (!jogoRegistrado) {
                jogosLucro[totalJogos][0] = nomeJogo;
                jogosLucro[totalJogos][1] = Double.toString(lucro);
                totalJogos++;
            }
        }

        lucroDecrescente(jogosLucro, totalJogos);

        System.out.println("\n Top " + numeroJogos + " Jogos que Mais Geraram Lucro ###\n");
        for (int X = 0; X < numeroJogos && X < totalJogos; X++) {

            System.out.println("Jogo: " + jogosLucro[X][0]);
            System.out.println("Lucro Gerado: R$" + jogosLucro[X][1]);
            System.out.println();
        }
    }

    public static double porcentagemMargem(String categoriaJogo, String[][] porcentagensMargem) {
        for (int X = 0; X < porcentagensMargem.length; X++) {
            if (porcentagensMargem[X][0].equalsIgnoreCase(categoriaJogo)) {
                return Double.parseDouble(porcentagensMargem[X][1]);
            }
        }
        return 0.0;
    }

    public static void lucroDecrescente(String[][] jogosLucro, int totalJogos) {
        for (int X = 0; X < totalJogos - 1; X++) {

            for (int Y = X + 1; Y < totalJogos; Y++) {
                double lucroI = Double.parseDouble(jogosLucro[X][1]);
                double lucroJ = Double.parseDouble(jogosLucro[Y][1]);

                if (lucroI < lucroJ) {

                    String[] tempJogoLucro = jogosLucro[X];
                    jogosLucro[X] = jogosLucro[Y];
                    jogosLucro[Y] = tempJogoLucro;
                }
            }
        }
    }
}
