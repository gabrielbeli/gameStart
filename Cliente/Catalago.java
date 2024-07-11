package Cliente;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catalago {


    public static void catalago() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n    \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E \n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                          1.Todos os Jogos");
            System.out.println("                          2.Jogos por categoria");
            System.out.println("                          3.Jogos por editora");
            System.out.println("                          4.Catalago gráfico");
            System.out.println("                          5.Voltar\n");
            System.out.print("     \uD83D\uDD79\uFE0FOpção:");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("");
                    //imprimirAquivo("");
                    break;
                case 2:
                    System.out.println("");
                    //função para imprimir arquivo
                    break;
                case 3:
                    System.out.println("");
                    //função para impimir as vagas disponiveis de estacionamento
                    break;
                case 4:
                    System.out.println("");
                    //função para imprimir arquivo
                    break;
                case 5:
                    return;
                default:
                    System.out.println("");
            }
        } while (true);
    }

    // 3. Imprimir Catálogo: Imprima todos os títulos de jogos (sem duplicados).

    // 4. Imprimir Catálogos Gráficos: Escolhe o jogo da lista dos jogos com arte gráfica (Call of Duty, Fifa,
    // Hollow Knight, Mortal Kombat, Overcooked, Witcher 3: Wild Hunt, Minecraft), e de seguida imprime a consola o
    // conteúdo do ficheiro correspondente.

    // 5.Imprimir Catálogo Editora: Dada uma Editora, imprima todas as categorias e os respetivos jogos.
    //(Preferencialmente com formatação visual)

    //6. Imprimir Catálogo Categoria: Dada uma Categoria, imprima todas as editoras e os respetivos jogos.
    // (Preferencialmente com a mesma formatação visual do ponto anterior).
}
