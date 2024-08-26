package Verde.TP01.Q08;
import java.io.RandomAccessFile;

public class Arq {

    // metodo de ler
    static void start(String fileName) {
        int x = MyIO.readInt();
        lerGravar(fileName, x);
        printar(fileName, x);
    }

    // metodo de ler e gravar em arquivo
    static void lerGravar(String fileName, int y) {
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            for (int x = 0; x < y; x = x + 1) {
                double input = MyIO.readDouble();
                file.writeDouble(input);
            } // end for
            file.close();
        } catch (Exception e) {
            MyIO.println("ERRO: " + e.getMessage());
        } // end try catch
    }

    // metodo de ler arquivo e printar
    static void printar(String fileName, int y) {
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            int fileLen = (int) file.length();
            for (int x = 0; x < y; x = x + 1) {
                fileLen -= 8;
                file.seek(fileLen);
                double value = file.readDouble();
                if (value == (int) value) {
                    MyIO.println((int) value);
                } else {
                    MyIO.println(value);
                } // end if
            } // end for
            file.close();
        } catch (Exception e) {
            MyIO.println("ERRO: " + e.getMessage());
        } // end try catch
    }

    // metodo main
    public static void main(String args[]) {
        // definir dados
        String fileName = "reais.txt";
        MyIO.setCharset("UTF-8");
        // começar programa
        start(fileName);
    }

}
