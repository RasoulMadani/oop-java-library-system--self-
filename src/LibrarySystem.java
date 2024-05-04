import CommandManager.AddCommand;
import CommandManager.RemoveCommand;
import CommandManager.ReportCommand;
import baseClasses.Library;

import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        Library library = new Library("allah");
        Scanner scanner = new Scanner(System.in);
        label:
        while (true){
            System.out.println("Enter \"add\" or \"remove\" or \"report\" command :");
            String firstCommand = scanner.next();
            if(checkTerminate(firstCommand))break;

            switch (firstCommand) {
                case "add" -> {
                    System.out.println("Enter \"borrow\" or \"book\" or \"member\" or \"item\"  :");
                    String secondCommand = scanner.next();
                    if (checkTerminate(secondCommand)) break label;

                    AddCommand addCommand = new AddCommand(secondCommand, scanner, library);
                    addCommand.runCommand();
                }
                case "report" -> {
                    System.out.println("Enter \"customers\" or \"book\" or \"borrow\"  :");
                    String secondCommand = scanner.next();
                    if (checkTerminate(secondCommand)) break label;
                    ReportCommand reportCommand = new ReportCommand(secondCommand, scanner, library);
                    reportCommand.runCommand();
                }
                case "remove" -> {
                    System.out.println("Enter \"item\" :");
                    String command = scanner.next();
                    if (checkTerminate(command)) break label;
                    RemoveCommand removeCommand = new RemoveCommand(command,scanner,library);
                    removeCommand.runCommand();
                }
            }
        }
    }
    public static boolean checkTerminate(String input){
        if(input.equals("terminate")){
            return  true;
        }else{
            return false;
        }
    }
}
