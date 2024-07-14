package Cliente.Catalago;

import java.io.FileNotFoundException;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class TodosJogos {

    /**
     * Método: Mostra a lista de todos os jogos da loja.
     * @param caminho arquivo de vendas dos jogos
     * @return imprime em tela a lista de jogos sem duplicados
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void todoJogos(String caminho) throws FileNotFoundException {

        String[][] matriz = gerarMatriz(caminho);
        String jogos = ",";

        System.out.println("\n     \uD83C\uDFAE Nossos Jogos:\n ");

        for (int i = 0; i < matriz.length; i++) {

            String jogo = matriz[i][4];

            if (!jogos.contains("," + jogo + ",")) {
                jogos += jogo + ",";
                System.out.println("     "+jogo);
            }
        }
    }
}
