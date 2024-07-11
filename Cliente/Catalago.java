package Cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;

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
                    //função para impimir todos os jogos
                    todoJogos("Ficheiros/GameStart_Vendas.csv");
                    break;
                case 2:
                    System.out.println("");
                    //função para imprimir jogos categoria
                    break;
                case 3:
                    System.out.println("");
                    //função para impimir jogos por editora
                    break;
                case 4:
                    System.out.println("");
                    //função para imprimir catalago gráfico
                    imprimirAquivo(arquivoCatalogo(1));
                    break;
                case 5:
                    return;
                default:
                    System.out.println("");
            }
        } while (true);
    }


    public static void todoJogos(String caminho) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File(caminho));

        fileScanner.nextLine();
        String linha;

        String jogos = "";

        while (fileScanner.hasNextLine()) {
            linha = fileScanner.nextLine();
            String[] itensLinha = linha.split(";");

            jogos += itensLinha[4];
        }

        System.out.println(jogos);

    }
    // 3. Imprimir Catálogo: Imprima todos os títulos de jogos (sem duplicados).


    /**
     * Método que, dado o índice, retorna o caminho do ficheiro do catálogo
     * @param numeroFicheiro 1 - callOfDuty | 2 - fifa | 3 - hollowKnight...
     * @return
     */
    public static String arquivoCatalogo(int numeroFicheiro) {

        switch (numeroFicheiro){
            case 1: return "Ficheiros/CatalogoGrafico/callOfDuty.txt";
            case 2: return "Ficheiros/CatalogoGrafico/fifa.txt";
            case 3: return "Ficheiros/CatalogoGrafico/hollowKnight.txt";
            case 4: return "Ficheiros/CatalogoGrafico/minecraft.txt";
            case 5: return "Ficheiros/CatalogoGrafico/montalKombat.txt";
            case 6: return "Ficheiros/CatalogoGrafico/overcooked.txt";
            case 7: return "Ficheiros/CatalogoGrafico/witcher.txt";
        }

        return "Caminho indefinido";
    }


    public static void jogosEditora(String caminho) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(caminho));
    }
    // 5.Imprimir Catálogo Editora: Dada uma Editora, imprima todas as categorias e os respetivos jogos.
    //(Preferencialmente com formatação visual)


    public static void jogosCategoria(String caminho) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(caminho));
    }
    //6. Imprimir Catálogo Categoria: Dada uma Categoria, imprima todas as editoras e os respetivos jogos.
    // (Preferencialmente com a mesma formatação visual do ponto anterior).
}
