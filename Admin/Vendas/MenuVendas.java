package Admin.Vendas;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Admin.Vendas.Bottom5Jogos.topJogosMenosLucro;

import static Admin.Vendas.PesquisaVendas.obterNomeJogo;
import static Admin.Vendas.PesquisaVendas.pesquisarJogo;
import static Admin.Vendas.Top5Jogos.topJogosLucro;
import static Admin.Vendas.TotalLucro.totalGeralLucro;
import static Admin.Vendas.TotalVendas.totalVendas;
import static BaseFuncoes.DisparoArquivos.caminhosDosArquivos;
import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;

public class MenuVendas {

    /**
     * Método: Gera o menu de vendas do user admin, onde tem acesso a ações
     * @return 1-total vendas, 2-total lucros...
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void vendasMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n     \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E \n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                            1.Total Vendas");
            System.out.println("                            2.Total Lucro");
            System.out.println("                            3.Top 5 vendas");
            System.out.println("                            4.Top 5 piores vendas");
            System.out.println("                            5.Pesquisa Vendas");
            System.out.println("                            6.Voltar");
            System.out.print("     \uD83D\uDD79\uFE0F Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // função para total de vendas
                    System.out.println("\n     \uD83D\uDCC8 Vendas geral\n");
                    imprimirAquivo(caminhosDosArquivos(1));
                    totalVendas(caminhosDosArquivos(1));
                    break;
                case 2:
                    // função para total de lucro
                    totalGeralLucro(caminhosDosArquivos(1), caminhosDosArquivos(3));
                    break;
                case 3:
                    //função para filtrar os 5 jogos que mais lucraram
                    topJogosLucro(caminhosDosArquivos(1),caminhosDosArquivos(3), 5);
                    break;
                case 4:
                    //função para filtrar os 5 jogos menos lucrativos
                    topJogosMenosLucro(caminhosDosArquivos(1),caminhosDosArquivos(3), 5);
                    break;
                case 5:
                    // função para filtrar vendas por jogo
                    pesquisarJogo(caminhosDosArquivos(1), obterNomeJogo());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}
