import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Inna on 12/4/2018.
 */
public class Server_Cline_Side {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 7777;
    public static final int SINGUP = 202;
    public static final int LOGIN = 201;
    public static final int OK = 200;
    public static final int QUIT = 203;
    public static final int NOLOGIN = 205;


    public static UserClientSide userClientSide;



    public static boolean login_Client(String user, String password, boolean isSingUp){
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            socket = new Socket(HOST, PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            outputStream.write(isSingUp? SINGUP : LOGIN);
            userClientSide = new UserClientSide(user, password);
            userClientSide.writeSendToServerNamePass(outputStream);
            int response = inputStream.read();
            if (response == OK) {
                return true;
            }
            if(response == NOLOGIN){
                System.out.println("Sorry,  name "+ user.toUpperCase()+" is not exist \n try again");
                return false;
            }

            System.out.println("Sorry,  name "+ user.toUpperCase()+" is already exist \n try again");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return false;
    }
    private static void quitFromGame(){
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(HOST,PORT);
            outputStream.write(QUIT);
            userClientSide.getUserName();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
