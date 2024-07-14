package Admin.Vendas;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class Top5Jogos {

    /**
     * Método: Calcula o lucro dos jogos e apresenta em tela os jogos mais lucrativos.
     * @param caminhoVendas arquivo de vendas dos jogos
     * @param caminhoPercentagens arquivo de percentagem de lucro por categoria
     * @param numeroJogos define o tamnho da lista a ser apresentada.
     * @return impressão em tela top 5 jogos mais lucrativos
     */
    public static void topJogosLucro(String caminhoVendas, String caminhoPercentagens, int numeroJogos) throws FileNotFoundException {

        String[][] matrizVendas = gerarMatriz(caminhoVendas);
        String[][] porcentagensMargem = gerarMatriz(caminhoPercentagens);

        String[][] jogosLucro = new String[matrizVendas.length][2];
        int totalJogos = 0;

        //aqui estou percorrendo as matrizes, encontrando os jogos, valores, lucros e fazendo os calculos
        for (int X = 1; X < matrizVendas.length; X++) {
            String nomeJogo = matrizVendas[X][4];
            double valorVenda = Double.parseDouble(matrizVendas[X][5]);
            String categoriaJogo = matrizVendas[X][3];

            double margemPercentagem = percentagemMargem(categoriaJogo, porcentagensMargem);

            double lucro = valorVenda * (margemPercentagem / 100.0);

            boolean jogoRegistrado = false;

            //nesse ciclo estou calculando o lucro por jogos
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

        System.out.println("\n     \uD83C\uDFC6 Top " + numeroJogos + " + lucrativos \n");

        //aqui eu imprimo a lista de jogos de acordo com o parametro "5"
        for (int X = 0; X < numeroJogos && X < totalJogos; X++) {

            System.out.println("     \uD83C\uDFAE Jogo: " + jogosLucro[X][0]);
            System.out.println("     \uD83D\uDCB5 Lucro Gerado: R$" + jogosLucro[X][1]);
            System.out.println();
        }
    }

    /**
     * Método: que encontra o referencial de percentagem de acordo com a categoria do jogo.
     * @param categoriaJogo identificação da categoria para identificar a percentagem
     * @param percentagensMargem matriz das percentagens
     * @return a percentagem especifica de cada categoria
     */
    public static double percentagemMargem(String categoriaJogo, String[][] percentagensMargem) {
        for (int X = 0; X < percentagensMargem.length; X++) {
            if (percentagensMargem[X][0].equalsIgnoreCase(categoriaJogo)) {
                return Double.parseDouble(percentagensMargem[X][1]);
            }
        }
        return 0.0;
    }

    /**
     * Método: função auxiliar que ordena de forma decrescente através da comparação de lucro.
     * @param totalJogos conjunto de jogos
     * @param jogosLucro matriz com os jogos e lucros
     * @return lista ordenada de forma decrescente
     */
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
