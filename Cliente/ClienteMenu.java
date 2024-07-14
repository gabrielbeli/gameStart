package Cliente;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Cliente.JogoMaisRecente.jogoMaisRecente;
import static Cliente.ProcurarEstacionamento.estacionamento;
import static Cliente.Catalago.MenuCatalago.catalago;

public class ClienteMenu {

    /**
     * Método: Gera o menu principal do cliente, dando acesso a opções de consulta.
     * @return 1-Catalago de jogos, 2-Jogo mais recente, 3-vagas de estacionamento, 4 voltar
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
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
                    //função para acessar catalagos de acordo com as opções;
                    catalago();
                    break;
                case 2:
                    //função para imprimir arquivo de vendas;
                    jogoMaisRecente();
                    caminhosArquivos();
                    break;
                case 3:
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
