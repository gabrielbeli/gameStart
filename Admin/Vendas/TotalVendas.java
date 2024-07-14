package Admin.Vendas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TotalVendas {

    /**
     * Método: Uma leitura simples para calcluar o total de vendas
     * @return imprime em tela a lista de vendas e o valor total
     * @param caminho arquivo de vendas
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void totalVendas(String caminho) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File(caminho));

        fileScanner.nextLine();
        String linha;

        double total = 0, precoUnitario;

        while (fileScanner.hasNextLine()) {
            linha = fileScanner.nextLine();
            String[] itensLinha = linha.split(";");

            precoUnitario = Double.parseDouble(itensLinha[5]);

            total += (precoUnitario);
        }

        System.out.println("     \uD83D\uDCB5 Total: " + total + " €");
    }
}
