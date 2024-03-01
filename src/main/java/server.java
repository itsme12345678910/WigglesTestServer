import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class server {
    public static void main(String[] args){


        try {
            while (true) {
                runServer();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void runServer () throws Exception {
        ServerSocket serverSocket = new ServerSocket(5591);
        Socket socket = serverSocket.accept();
        String cCommand = "";
        while(!socket.isClosed()) {
            InputStream input = socket.getInputStream();
            BufferedInputStream bin = new BufferedInputStream(input);
            while (bin.available() > 0) {
                cCommand = cCommand + (char) bin.read();
            }
            if(cCommand != "") {
                System.out.print(cCommand);
                cCommand = "";
            }
        }
    }
}
