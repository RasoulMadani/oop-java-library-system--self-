package baseClasses;

import baseClasses.Member;
import publicClasses.ArrayOfObjects;

public class Library {
    ArrayOfObjects members = new ArrayOfObjects();
    ArrayOfObjects books = new ArrayOfObjects();


    String name;


    public Library(String name) {
        this.name = name;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member[] getMembers() {
        Member[] newMember = new Member[members.data.length];
        for (int i = 0; i < members.data.length; i++) {
            if (members.get(i) != null) {
                newMember[i] = (Member) members.get(i);
            }
        }
        return newMember;
    }

    public Member getMember(int id) {
        for (int i = 0; i < members.data.length; i++) {
            if (members.get(i) != null) {
                Member m = (Member) members.get(i);
                int memberId = m.getID();
                if (memberId == id) {
                    return m;
                }
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public Book getBook(int id) {
        for (int i = 0; i < books.data.length; i++) {
            if (books.get(i) != null) {
                Book m = (Book) books.get(i);
                int memberId = m.getID();
                if (memberId == id) {
                    return m;
                }
            }
        }
        return null;
    }
    public Book[] getExistBooks() {
        Book[] newBook = new Book[books.data.length];
        for (int i = 0; i < books.data.length; i++) {
            Book getBook = (Book) books.get(i);
            if (getBook != null && !getBook.isBorrowed) {
                newBook[i] = getBook;
            }
        }
        return newBook;
    }

    public Book[] getAllBooks() {
        Book[] newBook = new Book[books.data.length];
        for (int i = 0; i < books.data.length; i++) {
            if (books.get(i) != null) {
                newBook[i] = (Book) books.get(i);
            }
        }
        return newBook;
    }





}
