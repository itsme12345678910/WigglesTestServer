import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {

    public static void send() throws Exception{

        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        socket = new Socket("127.0.0.1", 8273);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());

        String msg = "DSPSYSSTS";
        oos.write(msg.getBytes());
        oos.flush();

        //read the server response message
        String message = (String) ois.readObject();

        //close resources
        ois.close();
        oos.close();
        socket.close();//!!!!

    } }