package Cliente.Catalago;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;
import static Cliente.Catalago.Grafico.arquivoCatalogo;
import static Cliente.Catalago.TodosJogos.todoJogos;
import static Cliente.Catalago.JogosCategoria.catalogoCategoria;
import static Cliente.Catalago.JogosCategoria.obterNomeCategoria;
import static Cliente.Catalago.JogosEditora.catalogoEditora;
import static Cliente.Catalago.JogosEditora.obterNomeEditora;

public class MenuCatalago {

    /**
     * Método: Gera o menu de acesso aos catalagos e as opções de consulta.
     * @return 1-todos os jogos, 2-Jogos por categoria, 3-jogos por editora, 4-catalago gráfico
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void catalago() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n     \uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E\uD83C\uDFAE✮ ⋆˚｡\uD81A\uDDB9 ⋆｡°✩\uD83D\uDC7E \n");
            System.out.println("                         \uD83E\uDE99 INSERT YOUR COIN \uD83E\uDE99");
            System.out.println("                          1.Todos os Jogos");
            System.out.println("                          2.Jogos por categoria");
            System.out.println("                          3.Jogos por editora");
            System.out.println("                          4.Catalago gráfico");
            System.out.println("                          5.Voltar\n");
            System.out.print("     \uD83D\uDD79\uFE0F Opção:");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    //função para imprimir todos os jogos
                    todoJogos("Ficheiros/GameStart_Vendas.csv");
                    break;
                case 2:
                    //função para imprimir jogos categoria
                    catalogoCategoria("Ficheiros/GameStart_Vendas.csv", obterNomeCategoria());
                    break;
                case 3:
                    //função para impimir jogos por editora
                    catalogoEditora("Ficheiros/GameStart_Vendas.csv", obterNomeEditora());
                    break;
                case 4:
                    //função para imprimir catalago gráfico
                    imprimirAquivo(arquivoCatalogo());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        } while (true);
    }

}
