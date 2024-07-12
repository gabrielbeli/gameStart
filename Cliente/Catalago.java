package Cliente;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.GerarMatriz.gerarMatriz;
import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;

public class Catalago {

    public static void catalago() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n     \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E \n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                          1.Todos os Jogos");
            System.out.println("                          2.Jogos por categoria");
            System.out.println("                          3.Jogos por editora");
            System.out.println("                          4.Catalago gráfico");
            System.out.println("                          5.Voltar\n");
            System.out.print("     \uD83D\uDD79\uFE0F Opção:");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n     \uD83C\uDFAE Nossos Jogos:\n ");
                    //função para impimir todos os jogos
                    todoJogos("Ficheiros/GameStart_Vendas.csv");
                    break;
                case 2:
                    //função para imprimir jogos categoria
                    catalogoCategoria("Ficheiros/GameStart_Vendas.csv", obterNomeCategoria());
                    break;
                case 3:
                    //função para impimir jogos por editora
                    catalogoEditora("Ficheiros/GameStart_Vendas.csv", obterNomeEditora());
                    break;
                case 4:
                    //função para imprimir catalago gráfico
                    imprimirAquivo(arquivoCatalogo());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        } while (true);
    }

    public static void todoJogos(String caminho) throws FileNotFoundException {

        String[][] matriz = gerarMatriz(caminho);
        String jogos = ",";

        for (int i = 1; i < matriz.length; i++) {

            String jogo = matriz[i][4];

            if (!jogos.contains("," + jogo + ",")) {
                jogos += jogo + ",";
                System.out.println("     "+jogo);
            }
        }
    }

    public static String arquivoCatalogo() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n    \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E \n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                          1.Call of Duty");
            System.out.println("                          2.Fifa");
            System.out.println("                          3.Hollow Knight");
            System.out.println("                          4.Minecraft");
            System.out.println("                          5.Mortal Kombat");
            System.out.println("                          6.Overcooked");
            System.out.print("     \uD83D\uDD79\uFE0FOpção:");
            int numeroFicheiro = scanner.nextInt();

            switch (numeroFicheiro) {
                case 1:
                    return "Ficheiros/CatalogoGrafico/callOfDuty.txt";
                case 2:
                    return "Ficheiros/CatalogoGrafico/fifa.txt";
                case 3:
                    return "Ficheiros/CatalogoGrafico/hollowKnight.txt";
                case 4:
                    return "Ficheiros/CatalogoGrafico/minecraft.txt";
                case 5:
                    return "Ficheiros/CatalogoGrafico/montalKombat.txt";
                case 6:
                    return "Ficheiros/CatalogoGrafico/overcooked.txt";
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }

    public static void catalogoEditora(String caminho, String editora) throws FileNotFoundException {
        String[][] matriz = gerarMatriz(caminho);

        String resultado = "";
        boolean encontrou = false;

        for (int X = 1; X < matriz.length; X++) {
            String jogoEditora = matriz[X][2];
            String categoria = matriz[X][3];
            String jogo = matriz[X][4];

            if (jogoEditora.equalsIgnoreCase(editora)) {
                if (!encontrou) {
                    System.out.println("\n      \uD83C\uDFAE Jogos da: " + editora+"\n");
                    encontrou = true;
                }

                boolean jogoRepetido = false;
                for (int Y = 1; Y < X; Y++) {
                    if (matriz[Y][4].equalsIgnoreCase(jogo)) {
                        jogoRepetido = true;
                        break;
                    }
                }
                if (!jogoRepetido) {
                    System.out.println("      \uD83D\uDD25 Categoria: " + categoria);
                    System.out.println("                 " + jogo);
                }
            }
        }

        if (!encontrou) {
            System.out.println("Editora não encontrada.");
        }
    }

    public static String obterNomeEditora() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n     \uD83D\uDD0D Digite o nome da editora: ");
        String nomeEditora = input.nextLine();

        return nomeEditora;
    }

    public static void catalogoCategoria(String caminho, String categoria) throws FileNotFoundException {
        String[][] matriz = gerarMatriz(caminho);

        boolean encontrouCategoria = false;

        for (int X = 1; X < matriz.length; X++) {
            String jogoEditora = matriz[X][2];
            String categoriaJogo = matriz[X][3];
            String jogo = matriz[X][4];

            if (categoriaJogo.equalsIgnoreCase(categoria)) {
                if (!encontrouCategoria) {
                    System.out.println("\n     \uD83D\uDD25 Categoria: " + categoria + "\n");
                    encontrouCategoria = true;
                }

                boolean jogoRepetido = false;
                for (int Y = 1; Y < X; Y++) {
                    if (matriz[Y][2].equalsIgnoreCase(jogoEditora) && matriz[Y][4].equalsIgnoreCase(jogo)) {
                        jogoRepetido = true;
                        break;
                    }
                }

                if (!jogoRepetido) {
                    System.out.println("     \uD83C\uDFAE Editora: " + jogoEditora);
                    System.out.println("                 " + jogo);
                }
            }
        }

        if (!encontrouCategoria) {
            System.out.println("Categoria não encontrada ou sem jogos nesta categoria.");
        }
    }

    public static String obterNomeCategoria() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n     \uD83D\uDD0D Digite o nome da categoria: ");
        String nomeCategoria = input.nextLine();

        return nomeCategoria;
    }

}
