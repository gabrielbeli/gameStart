package Cliente.Catalago;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class JogosEditora {

    /**
     * Método: Permite o cliente filtrar jogos pela editora.
     * @param caminho arquivo de vendas dos jogos
     * @param editora input do nome dado pelo usuário na função auxilar obeterNomeEditora
     * @return imprime em tela a lista de jogos por editora
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void catalogoEditora(String caminho, String editora) throws FileNotFoundException {
        String[][] matriz = gerarMatriz(caminho);

        boolean encontrou = false;

        // Aqui percorro a matriz vendas para comparar com a pesquisa
        for (int X = 0; X < matriz.length; X++) {
            String jogoEditora = matriz[X][2];
            String categoria = matriz[X][3];
            String jogo = matriz[X][4];

            if (jogoEditora.equalsIgnoreCase(editora)) {
                if (!encontrou) {
                    System.out.println("\n     \uD83C\uDFB2 Jogos da: " + editora+"\n");
                    encontrou = true;
                }

                boolean jogoRepetido = false;

                // Aqui encontro os jogos que pertecem a editora/categoria e vejo se são repetidos
                for (int Y = 0; Y < X; Y++) {
                    if (matriz[Y][4].equalsIgnoreCase(jogo)) {
                        jogoRepetido = true;
                    }
                }
                if (!jogoRepetido) {
                    System.out.println("     \uD83D\uDD25 Categoria: " + categoria);
                    System.out.println("          \uD83C\uDFAE" + jogo);
                }
            }
        }

        if (!encontrou) {
            System.out.println("Editora não encontrada.");
        }
    }

    /**
     * Método: Função auxiliar que capta o nome da editora inserido pelo usuário.
     * @return nomeEditora
     */
    public static String obterNomeEditora() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n     \uD83D\uDD0D Digite o nome da editora: ");
        String nomeEditora = input.nextLine();

        return nomeEditora;
    }
}
