import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Inna on 12/2/2018.
 */
public class Main_Client_Server {

    public static void main(String[] args) {
        String userName, password;
        Scanner scannerMain = new Scanner(System.in);


        System.out.println("Welcome To Word Fair Game ! ");
        System.out.println();
        //  mainMenu();


        boolean mainMenu = true;
        String name = "non Name";
        while (mainMenu) {

            mainMenu();
            String inputMain = scannerMain.nextLine();
            if (inputMain.trim().equals("3")){return;}

            boolean isSingUp = inputMain.trim().equals("2");

            //Registration or login
//mainMenu=false;
            if (inputMain.trim().equals("1") || isSingUp) {
                // nextStep(userName, password, scannerMain, mainMenu, isSingUp);
mainMenu=false;

                do {
                    System.out.println("0. Back to main menu");

                    System.out.println("Enter name: ");
                    userName = scannerMain.nextLine().trim();
                    //  if (name.equals("12")) { mainMenu=true; break; }

                    name = userName;
                    //  if (scannerMain.hasNext())
                    System.out.println("Enter password: ");
                    password = scannerMain.nextLine().trim();
                    if (password.equals("0") || name.equals("0")) {
                        mainMenu = true;
                        break;
                    }


                } while (!Server_Cline_Side.login_Client(userName, password, isSingUp));
                if(!mainMenu) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Welcome, ");
                    stringBuilder.append(name.toUpperCase());
                    stringBuilder.append(" !");
                    System.out.println(stringBuilder);
                    System.out.println(isSingUp ? "SignUp SUCCESS " : "Login SUCCESS");
                    printMenu();
                }

            }
        }
    }









    private static void mainMenu() {
        System.out.println("1. Login");
        System.out.println("2. SignUp");
        System.out.println("3. Quit");

    }
    private static boolean backToMainMenu(String input){
        if(input.equals("0")) return true;
return false;
    }


    private static void printMenu() {
        System.out.println("GAME MENU: ");
        System.out.println(" 4 ->  NEW GAME ");
        System.out.println(" 5 -> SHOW ACTIVE PLAYERS");
        System.out.println(" 6 -> JOIN TO CURRENT GAME");
        System.out.println(" 3 -> QUIT without saving");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        Game_ClientMain game_clientMain = new Game_ClientMain();
        try {
            game_clientMain.startGame(s);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
