package Admin;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;
import static Admin.TotalVendas.totalVendas;
import static Admin.Relatorio.relatorio;
import static Admin.PesquisaCliente.pesquisaCliente;

public class AdminMenu {
    public static void adminMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu Admin:");
            System.out.println("1.Relatorio");
            System.out.println("2.Pesquisa cliente");
            System.out.println("3.Total de Vendas");
            System.out.println("4.Total de Lucro");
            System.out.println("5.Melhor Cliente");
            System.out.println("6.Melhor Categoria");
            System.out.println("7.Jogo Mais Caro");
            System.out.println("8.Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // função para ler arquivos
                    relatorio();
                    break;
                case 2:
                    // função para ler arquivos
                    pesquisaCliente("Ficheiros/GameStart_Clientes.csv");
                    break;
                case 3:
                    System.out.println("Total em vendas: \n");
                    // função para total de vendas
                    imprimirAquivo("Ficheiros/GameStart_Vendas.csv");
                    totalVendas("Ficheiros/GameStart_Vendas.csv");
                    break;
                case 4:
                    System.out.println("Lucro total de: \n");
                    // função para total de lucro
                    break;
                case 5:
                    System.out.println("O(s) melhor(es) cliente(s): \n");
                    // função para melhor(es) cliente(s)
                    break;
                case 6:
                    System.out.println("A melhor categoria baseada em vendas: \n");
                    // função para melhor categoria
                    break;
                case 7:
                    System.out.println("O jogo mais caro em estoque: \n");
                    // função para consultar jogo mais caro
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}


