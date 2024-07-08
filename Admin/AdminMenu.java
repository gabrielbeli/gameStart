package Admin;

import java.util.Scanner;

public class AdminMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu Admin:");
            System.out.println("1. Consultar Ficheiros");
            System.out.println("2. Total de Vendas");
            System.out.println("3. Total de Lucro");
            System.out.println("4. Melhor Cliente");
            System.out.println("5. Melhor Categoria");
            System.out.println("6. Jogo Mais Caro");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Conteudo do ficheiro: \n");
                    // função para ler arquivos
                    break;
                case 2:
                    System.out.println("Total em vendas: \n");
                    // função para total de vendas
                    break;
                case 3:
                    System.out.println("Lucro total de: \n");
                    // função para total de lucro
                    break;
                case 4:
                    System.out.println("O(s) melhor(es) cliente(s): \n");
                    // função para melhor(es) cliente(s)
                    break;
                case 5:
                    System.out.println("A melhor categoria baseada em vendas: \n");
                    // função para melhor categoria
                    break;
                case 6:
                    System.out.println("O jogo mais caro em estoque: \n");
                    // função para consultar jogo mais caro
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}


