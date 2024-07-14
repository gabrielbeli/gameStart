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

    public static void vendasMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu Vendas:");
            System.out.println("1.Total Vendas");
            System.out.println("2.Total Lucro");
            System.out.println("3.Top 5 vendas");
            System.out.println("4.Top 5 piores vendas");
            System.out.println("5.Pesquisa Vendas");
            System.out.println("6.Voltar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // função para total de vendas
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
