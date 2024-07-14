package Cliente;

import java.io.FileNotFoundException;
import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class JogoMaisRecente {

    /**
     * Método: Apresenta o jogo "novo" mais recente nas entre as vendas.
     * @param caminhoVendas arquivo de vendas da loja
     * @return imprime o jogo em tela
     */
    public static void jogoMaisRecente(String caminhoVendas) throws FileNotFoundException {

        String[][] matriz = gerarMatriz(caminhoVendas);

        String jogos = ",";
        String ultimoJogo = "";

        for (int X = 0; X < matriz.length; X++) {

            String jogo = matriz[X][4];

            if (!jogos.contains("," + jogo + ",")) {
                jogos += jogo + ",";
                ultimoJogo = jogo;
            }
        }

        System.out.println("\n     \uD83C\uDFAE Jogo mais recente: " + ultimoJogo + "\n");
    }
}
