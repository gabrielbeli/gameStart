package Cliente;

import java.io.FileNotFoundException;
import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class JogoMaisRecente {

    /**
     * Método: Apresenta o jogo "novo" mais recente nas entre as vendas.
     * @return imprime o jogo em tela
     */
    public static void jogoMaisRecente(String caminhoVendas) throws FileNotFoundException {

        String[][] matriz = gerarMatriz(caminhoVendas);

        String jogos = ",";
        String ultimoJogo = "";

        for (int i = 1; i < matriz.length; i++) {

            String jogo = matriz[i][4];

            if (!jogos.contains("," + jogo + ",")) {
                jogos += jogo + ",";
                ultimoJogo = jogo;
            }
        }

        System.out.println("Último jogo não repetido: " + ultimoJogo);
    }
}
