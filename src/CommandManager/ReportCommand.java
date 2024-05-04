package CommandManager;

import baseClasses.*;

import java.util.Arrays;
import java.util.Scanner;

public class ReportCommand {
    String command;
    Scanner scanner;
    Library library;

    public ReportCommand(String command, Scanner scanner, Library library) {
        this.command = command;
        this.scanner = scanner;
        this.library = library;
    }

    public void runCommand() {
        switch (command) {
            case "customers":
                reportCustomers();
                break;
            case "book":
                reportExistBooks();
                break;
            case "borrow":
                reportBorrow();
                break;
        }
    }

    public void reportCustomers() {
        Member[] members = library.getMembers();
        StringBuilder str = new StringBuilder();
        for (Member m : members) {
            if (m != null) {
                Address address = m.getAddress();
                str.append("ID :").append(m.getID())
                        .append(" - name : ")
                        .append(m.getName())
                        .append(" - province : ")
                        .append(address.getProvinceName())
                        .append(" - town : ")
                        .append(address.getTownName())
                        .append(" - street : ")
                        .append(address.getStreetName())
                        .append(" - plaque : ")
                        .append(address.getPlaque())
                        .append(" - total Borrow Size :")
                        .append(m.getBorrows().length)
                        .append("\n");
            }
        }
        System.out.println(str);

    }

    public void reportExistBooks() {
        Book[] books = library.getExistBooks();
        int counter = 0;
        for (Book book : books) {
            if (book != null) {
                counter++;
            }
        }
        System.out.println("Count of Exists books :" + counter);
    }

    public void  reportBorrow(){
        System.out.println("Enter Borrow id");
        int borrowId = scanner.nextInt();
        StringBuilder str = new StringBuilder();
        str.append("Borrow ID : ").append(" ").append(borrowId);

        Member[] members = library.getMembers();
        for (Member member : members){
            if(member != null ){
               Borrow borrow = member.getBorrow(borrowId);
               if(borrow != null){
                   str.append(" - Member id :").append(member.getID()).append(" book list : \n");
                   for(Book item : borrow.getItems()){
                       if (item != null){
                           str.append("book id :").append(item.getID())
                                   .append(", book name : ")
                                   .append(item.getName())
                                   .append(", year : ")
                                   .append(item.getYear());
                           Writer[] writers = item.getWriters();
                           int counter = 1;
                           for (Writer writer : writers){
                               if (writer != null){
                                   str.append(", book_write_")
                                           .append(counter)
                                           .append(" ")
                                           .append(writer.getFirstName())
                                           .append(" ")
                                           .append(writer.getLastName());
                               }

                           }
                       }
                   }

               }
            }
        }
        System.out.println(str);
    }

}
