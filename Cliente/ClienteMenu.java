package Cliente;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;

public class ClienteMenu {
    public static void clienteMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu Cliente:");
            System.out.println("1. Imprimir Catálogo de Jogos");
            System.out.println("2. Jogo Mais Recente");
            System.out.println("3. Procurar Estacionamento");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Os jogos disponiveis são: \n");
                    //imprimirAquivo("");
                    break;
                case 2:
                    System.out.println("O jogo mais recente: \n");
                    // função para imprimir arquivo
                    break;
                case 3:
                    System.out.println("As vagas disponiveis no estacionamento nesse momento: \n");
                    // função para total de lucro
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}
