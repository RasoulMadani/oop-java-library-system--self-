package CommandManager;

import baseClasses.*;
import publicClasses.IdGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class AddCommand {
    String command;
    Scanner scanner;
    Library library;

    public AddCommand(String command, Scanner scanner, Library library) {
        this.command = command;
        this.scanner = scanner;
        this.library = library;
    }

    public void runCommand() {
        switch (command) {
            case "member":
                addMember();
                break;
            case "book":
                addBook();
                break;
            case "borrow":
                addBorrow();
                break;
            case "item":
                addItem();
                break;
        }
    }

    public void addMember() {
        System.out.println("Enter name :");
        String name = scanner.next();
        System.out.println("Enter provinceName :");
        String province = scanner.next();
        System.out.println("Enter town :");
        String town = scanner.next();
        System.out.println("street");
        String street = scanner.next();
        System.out.println("plaque");
        int plaque = scanner.nextInt();
        int id = new IdGenerator().generator();
        Address address = new Address(province, town, street, plaque);
        Member member = new Member(name, id, address);
        library.addMember(member);
        System.out.println(Arrays.toString(library.getMembers()));
    }

    public void addBook() {
        int id = new IdGenerator().generator();
        System.out.println("Enter name book:");
        String name = scanner.next();
        System.out.println("Enter count of authors :");
        Writer[] writers = getAuthorDetails();
        System.out.println("Enter publish year :");
        int publishYear = scanner.nextInt();
        Book book = new Book(name, id, writers, publishYear);
        library.addBook(book);
        System.out.println(Arrays.toString(library.getAllBooks()));
    }

    public void addBorrow() {
        int id = new IdGenerator().generator();
        System.out.println("Enter Your ID :");
        int userId = scanner.nextInt();
        Member member = library.getMember(userId);
        if (member != null) {
            System.out.println(member);
        }
        Borrow borrow = new Borrow(id, member);
        assert member != null;
        member.addBorrow(borrow);

        System.out.println(Arrays.toString(member.getBorrows()));
    }

    public void addItem() {
        System.out.println("Enter your borrow id :");
        int borrowId = scanner.nextInt();
        System.out.println("Enter book id :");
        int bookId = scanner.nextInt();
        Member[] members = library.getMembers();
        for (Member member : members) {
            if (member != null) {
                Borrow borrow = member.getBorrow(borrowId);
                if (borrow != null) {
                    Book book = library.getBook(bookId);
                    if (book != null && !book.isBorrowed()) {
                        borrow.addItem(book);
                        book.setBorrowed(true);

                        System.out.println(borrow);
                    } else {
                        System.out.println("book not exist or is borrowed");
                    }
                } else {
                    System.out.println("borrow id is incorrect or you don't have borrow id ");
                }
            }

        }
    }

    public Writer[] getAuthorDetails() {
        int countAuthor = scanner.nextInt();
        Writer[] authors = new Writer[countAuthor];
        for (int i = 0; i < countAuthor; i++) {
            System.out.println("Enter First Name :");
            String firstName = scanner.next();
            System.out.println("Enter Last Name :");
            String lastName = scanner.next();
            Writer writer = new Writer(firstName, lastName);
            authors[i] = writer;
        }
        return authors;
    }
}
