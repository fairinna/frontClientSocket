import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Inna on 12/6/2018.
 */
public class Game_ClientMain {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 7777;
    public static final int NEW_GAME = 104;
    String newWord;
    Socket socket;
    OutputStream outputStream;
    InputStream inputStream;
    Scanner scanner = new Scanner(System.in);

   public void startGame( String input) throws IOException {
       socket= null;
       inputStream = null;
       outputStream = null;
socket = new Socket(HOST,PORT);
outputStream = socket.getOutputStream();
       if (input.equals("4")){
           enterNewWord();
           if(scanner.hasNext()){
               this.newWord = scanner.nextLine();
               Game_Start_ClientSide game_start_clientSide = new Game_Start_ClientSide(newWord);
               System.out.println("Your word is: " + newWord);
               outputStream.write(NEW_GAME);


               inputStream = socket.getInputStream();
               int response = inputStream.read();
               if(response == 200){
                   System.out.println("Server got a word");
               }
           }

       }

   }

    private void enterNewWord() {
        System.out.println("enter new Word: ");
    }


}
