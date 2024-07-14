import java.io.FileNotFoundException;

import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;
import static BaseFuncoes.Login.login;

public class Start {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println();
        imprimirAquivo("Ficheiros/Header.txt");

        //função para iniciar o programa
        login();
    }

}

