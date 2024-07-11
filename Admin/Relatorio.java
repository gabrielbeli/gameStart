package Admin;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Cliente.ProcurarEstacionamento.estacionamento;
import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;

public class Relatorio {

    // 1. Consulta de Ficheiros: Imprima o conteúdo do ficheiro na consola (deve permitir ver o conteúdo do ficheiro
    // de Vendas, Clientes e Categorias consoante a escolha).

    public static void relatorio() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("     \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E \n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                               1.Vendas");
            System.out.println("                               2.Clientes");
            System.out.println("                               3.Categorias");
            System.out.println("                               4.Voltar\n");
            System.out.print("     \uD83D\uDD79\uFE0FOpção:");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    //função para acessar catalagos;
                    imprimirAquivo("Ficheiros/GameStart_Vendas.csv");
                    break;
                case 2:
                    //função para imprimir arquivo
                    imprimirAquivo("Ficheiros/GameStart_Clientes.csv");
                    break;
                case 3:
                    //função para impimir as vagas disponiveis de estacionamento
                    imprimirAquivo("Ficheiros/GameStart_Categorias.csv");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }

}
