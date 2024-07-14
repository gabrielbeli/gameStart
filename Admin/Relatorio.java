package Admin;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.DisparoArquivos.caminhosDosArquivos;
import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;

public class Relatorio {

    /**
     * Método: Gera o menu de relátorio, onde pode acessar relatorio geral de vendas, clientes e categorias
     * @return 1-menu vendas, 2-menu relatorios...
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void relatorio() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("     \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E \n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                               1.Vendas");
            System.out.println("                               2.Clientes");
            System.out.println("                               3.Categorias");
            System.out.println("                               4.Voltar\n");
            System.out.print("     \uD83D\uDD79\uFE0F Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    //função para acessar catalagos;
                    System.out.println("");
                    imprimirAquivo(caminhosDosArquivos(1));
                    break;
                case 2:
                    //função para imprimir arquivo
                    System.out.println("");
                    imprimirAquivo(caminhosDosArquivos(4));
                    break;
                case 3:
                    //função para impimir as categorias
                    System.out.println("");
                    imprimirAquivo(caminhosDosArquivos(3));
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }

}
