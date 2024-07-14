package Admin;

import java.io.FileNotFoundException;

import static Admin.PesquisaCliente.pesquisaCliente;
import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class MelhoresClientes {

    /**
     * Método: apresenta o melhor cliente com base na quantidade/valor da compras
     * @return imprime em tela o mlhor cliente e os jogos que comprou
     * @param caminhoVendas arquivo de vendas
     * @param caminhoClientes arquivo de clientes
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void melhorCliente(String caminhoClientes, String caminhoVendas) throws FileNotFoundException {

        String[][] matrizClientes = gerarMatriz(caminhoClientes);
        String[][] matrizVendas = gerarMatriz(caminhoVendas);

        int idClienteComMaisGastos = -1;
        double maiorValorCompras = 0.0;

        //percorrendo para encontrar o id do cliente e usando da função auxiliar para determinar o valor total das compras
        for (int X = 0; X < matrizClientes.length; X++) {

            int idCliente = Integer.parseInt(matrizClientes[X][0]);
            double totalCompras = calcularTotalComprasCliente(idCliente, matrizVendas);

            if (totalCompras > maiorValorCompras) {
                maiorValorCompras = totalCompras;
                idClienteComMaisGastos = idCliente;
            }
        }

        System.out.println("\n Melhor Cliente \n");
        pesquisaCliente(caminhoClientes, idClienteComMaisGastos);

        System.out.println("Jogos comprados:");

        //aqui imprimindo todos os jogos comprados pelo cliente
        for (int X = 0; X < matrizVendas.length; X++) {

            int idCliente = Integer.parseInt(matrizVendas[X][1]);

            if (idCliente == idClienteComMaisGastos) {
                System.out.println("- " + matrizVendas[X][4]);
            }
        }
    }

    /**
     * Método: Calcula o total de compras por cliente
     * @return total de compras feita pelo cliente
     * @param idCliente identificação do cliente na lista
     * @param matrizVendas matriz da vendas da loja
     */
    public static double calcularTotalComprasCliente(int idCliente, String[][] matrizVendas) {

        double totalCompras = 0.0;

        for (int X = 0; X < matrizVendas.length; X++) {

            int id = Integer.parseInt(matrizVendas[X][1]);

            if (id == idCliente) {
                double valorVenda = Double.parseDouble(matrizVendas[X][5]);
                totalCompras += valorVenda;
            }
        }
        return totalCompras;
    }

}
