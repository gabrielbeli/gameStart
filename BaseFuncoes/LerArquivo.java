package BaseFuncoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivo {

    /**
     * Método: Usado para ler o arquivo
     * @param caminho para o arquivo
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void lerAquivo(String caminho) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File(caminho));

        String linha;

        while (fileScanner.hasNextLine()) {
            linha = fileScanner.nextLine();
            System.out.println(linha );
        }

        System.out.println();

    }
}
