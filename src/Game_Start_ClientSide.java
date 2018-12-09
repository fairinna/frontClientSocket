import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.OutputStream;

/**
 * Created by Inna on 12/9/2018.
 */
public class Game_Start_ClientSide {
    private String wordToServer;
    private String sender;
    private char aChar;


    public Game_Start_ClientSide(String wordToServer) {
        this.wordToServer = wordToServer;

    }
    public Game_Start_ClientSide(String wordToServer, String sender) {
        this.wordToServer = wordToServer;
        this.sender = sender;
    }

    public Game_Start_ClientSide(String sender, char aChar) {
        this.sender = sender;
        this.aChar = aChar;
    }

    public Game_Start_ClientSide(InputStream inputStream) throws IOException {
        int senderLength = inputStream.read();
        if (senderLength == -1) throw new IOException("NO SENDER");
        byte[] senderByte = new byte[senderLength];
        int actualyRead = inputStream.read(senderByte);
        if(actualyRead != senderLength) throw new IOException("sender is coming");
        this.sender = new String(senderByte);

        int wordToServerLength = inputStream.read();
        if(wordToServerLength == -1) throw new IOException ("No word today");

        if (wordToServerLength >4) {
            byte[] wordFrom = new byte[wordToServerLength];
            actualyRead = inputStream.read(wordFrom);
            if (actualyRead != wordToServerLength) throw new IOException("word is coming");
            this.wordToServer = new String(wordFrom);
        }
        int aCharleng = inputStream.read();
        if (aCharleng == -1) throw new IOException("no char today");
        byte[] aChar = new byte[4];
        actualyRead = inputStream.read(aChar);
        if(actualyRead != aCharleng ) throw new IOException("char is coming");
        this.aChar = new String(aChar).charAt(0);




    }
    public void sendWordORCharToServer(OutputStream output) throws IOException {
        byte[] senderBytes = sender.getBytes();
        output.write(senderBytes.length);
        output.write(senderBytes);
         byte[] wordBytes = wordToServer.getBytes();
         if(wordBytes.length >4){
             byte charByte = (byte)aChar;
             output.write(charByte);
         }else {
             output.write(wordBytes.length);
             output.write(wordBytes);
         }


    }

    public String getWordToServer() {
        return wordToServer;
    }

    public void setWordToServer(String wordToServer) {
        this.wordToServer = wordToServer;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }
}
