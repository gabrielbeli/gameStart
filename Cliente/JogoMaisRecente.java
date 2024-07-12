package Cliente;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class JogoMaisRecente {

    public static void jogoMaisRecente(String caminhoVendas) throws FileNotFoundException {
        String[][] matrizVendas = gerarMatriz(caminhoVendas);

        int menorVendas = Integer.MAX_VALUE;
        String jogoMaisRecenteMenosVendido = "";

        int[] contagemVendas = new int[matrizVendas.length];
        String[] jogos = new String[matrizVendas.length];

        int indexJogos = 0;

        for (int X = 1; X < matrizVendas.length; X++) {
            String nomeJogo = matrizVendas[X][4];
            boolean encontrado = false;

            for (int Y = 0; Y < indexJogos; Y++) {
                if (nomeJogo.equals(jogos[Y])) {
                    contagemVendas[Y]++;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                jogos[indexJogos] = nomeJogo;
                contagemVendas[indexJogos] = 1;
                indexJogos++;
            }
        }

        // aqui eu vou encontrar o jogo mais recente com menos vendas
        for (int X = 1; X < matrizVendas.length; X++) {
            String nomeJogo = matrizVendas[X][4];
            int vendasAtual = 0;

            // aqui faço a contagem de vendas para o jogo atual
            for (int Y = 0; Y < indexJogos; Y++) {
                if (nomeJogo.equals(jogos[Y])) {
                    vendasAtual = contagemVendas[Y];
                    break;
                }
            }

            // verifico se é o jogo mais recente com menos vendas
            if (vendasAtual <= menorVendas) {
                menorVendas = vendasAtual;
                jogoMaisRecenteMenosVendido = nomeJogo;
            }
        }

        System.out.println("Jogo mais recente com menos vendas: " + jogoMaisRecenteMenosVendido);
    }
}
