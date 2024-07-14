package Cliente.Catalago;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class JogosCategoria {

    /**
     * Método: Permite o cliente filtrar jogos pela categoria.
     * @param caminho arquivo de vendas dos jogos
     * @param categoria input do nome dado pelo usuário na função auxilar obeterNomeCategoria
     * @return imprime em tela a lista de jogos por categoria
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void catalogoCategoria(String caminho, String categoria) throws FileNotFoundException {
        String[][] matriz = gerarMatriz(caminho);

        boolean encontrouCategoria = false;

        // Aqui percorro a matriz vendas para comparar com a pesquisa
        for (int X = 0; X < matriz.length; X++) {

            String jogoEditora = matriz[X][2];
            String categoriaJogo = matriz[X][3];
            String jogo = matriz[X][4];

            if (categoriaJogo.equalsIgnoreCase(categoria)) {
                if (!encontrouCategoria) {
                    System.out.println("\n     \uD83D\uDD25 Categoria: " + categoria + "\n");
                    encontrouCategoria = true;
                }

                boolean jogoRepetido = false;
                // Aqui encontro os jogos que pertecem a categoria/editora e vejo se são repetidos
                for (int Y = 0; Y < X; Y++) {

                    if (matriz[Y][2].equalsIgnoreCase(jogoEditora) && matriz[Y][4].equalsIgnoreCase(jogo)) {
                        jogoRepetido = true;
                    }
                }

                if (!jogoRepetido) {
                    System.out.println("     \uD83C\uDFB2 Editora: " + jogoEditora);
                    System.out.println("          \uD83C\uDFAE" + jogo);
                }
            }
        }

        if (!encontrouCategoria) {
            System.out.println("Categoria não encontrada ou sem jogos nesta categoria.");
        }
    }

    /**
     * Método: Função auxiliar que capta o nome da categoria inserido pelo usuário.
     * @return nomeCategoria
     */
    public static String obterNomeCategoria() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n     \uD83D\uDD0D Digite o nome da categoria: ");
        String nomeCategoria = input.nextLine();

        return nomeCategoria;
    }

}
