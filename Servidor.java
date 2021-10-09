import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;

public class Servidor {
    public static void main(String[] args) throws IOException{
        ServerSocket servidor = null;
        Socket conexao = null;
        PrintWriter output = null;

        BufferImp buff = new BufferImp(100);

        Fibonacci f1 = new Fibonacci(15, buff, 1);
        Fibonacci f2 = new Fibonacci(25, buff, 5);
        Fibonacci f3 = new Fibonacci(35, buff, 10);

        try {
            servidor = new ServerSocket(7000);
            conexao = servidor.accept();
            output = new PrintWriter(conexao.getOutputStream(), true);

            f1.start();
            f2.start();
            f3.start();
            
            do {
                output.println(buff.remove());
            } while (true);
        } catch (Exception e) {
            System.out.println("Algo errado aconteceu");
        } finally {
            conexao.close();
            servidor.close();
        }
    }
}