package BaseFuncoes;

public class DisparoArquivos {

    public static String caminhosDosArquivos(int numeroFicheiro) {

        switch (numeroFicheiro) {
            case 1:
                return "Ficheiros/GameStart_Vendas.csv";
            case 2:
                return "Ficheiros/GameStart_Admins.csv";
            case 3:
                return "Ficheiros/GameStart_Categorias.csv";
            case 4:
                return "Ficheiros/GameStart_Clientes.csv";
            case 5:
                return "Ficheiros/GameStart_Copyright.txt";
        }
        return "caminho não definido";
    }
}
