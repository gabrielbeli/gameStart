package BaseFuncoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GerarMatriz {

    /**
     * Método: Usado para gerar matriz do arquivo.
     * @param caminho para o arquivo
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static String[][] gerarMatriz(String caminho) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File(caminho));
        String texto = "";

        while (fileScanner.hasNextLine()) {
            texto += fileScanner.nextLine() + "\n";
        }

        fileScanner.close();

        String[] linhas = texto.split("\n");
        String[][] matriz = new String[linhas.length][];

        for (int X = 0; X < linhas.length; X++) {
            matriz[X] = linhas[X].split(";");
        }

        return matriz;
    }
}
