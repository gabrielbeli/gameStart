package Cliente;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Cliente.JogoMaisRecente.jogoMaisRecente;
import static Cliente.ProcurarEstacionamento.estacionamento;
import  static Cliente.Catalago.catalago;

public class ClienteMenu {
    public static void clienteMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("     \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E \n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                          1.Catálago de Jogos");
            System.out.println("                          2.Jogo mais recente");
            System.out.println("                          3.Vagas estacionamento");
            System.out.println("                          4.Voltar\n");
            System.out.print("     \uD83D\uDD79\uFE0F Opção:");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    //função para acessar catalagos;
                    catalago();
                    break;
                case 2:
                    //função para imprimir arquivo;
                    jogoMaisRecente("Ficheiros/GameStart_Vendas.csv");
                    break;
                case 3:
                    System.out.println("\n      As vagas disponiveis no estacionamento nesse momento: \n");
                    //função para impimir as vagas disponiveis de estacionamento
                    estacionamento();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}
