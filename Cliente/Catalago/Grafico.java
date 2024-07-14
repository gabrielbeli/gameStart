package Cliente.Catalago;

import java.util.Scanner;

public class Grafico {

    /**
     * Método: Gera um menu que permite selecionar qual o catalago grafico o cliente quer ver.
     * @return o caminho do arquivo do jogo para que a função imprimirArquivo tenha acesso.
     */
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
                    return "Ficheiros/CatalogoGrafico/mortalKombat.txt";
                case 6:
                    return "Ficheiros/CatalogoGrafico/overcooked.txt";
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}
