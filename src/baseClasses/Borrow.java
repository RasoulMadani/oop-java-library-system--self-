package baseClasses;

import publicClasses.ArrayOfObjects;

import java.security.PublicKey;

public class Borrow {
    ArrayOfObjects items = new ArrayOfObjects();
    int ID;
    Member m;

    public int getID() {
        return this.ID;
    }

    public Borrow(int ID, Member m) {
        this.ID = ID;
        this.m = m;
    }

    public void addItem(Book book) {
        items.add(book);
    }

    public void removeItem(Book book) {
        ArrayOfObjects arr_new = new ArrayOfObjects();
        for (int i = 0; i < items.data.length; i++) {
            if (items.get(i) != null) {
                Book book1 = (Book) items.get(i);
                if (book1.getID() != book.getID()) {
                    arr_new.add(book1);
                }
            }
        }
        items = arr_new;
    }

    public Book[] getItems() {
        Book[] newBooks = new Book[items.data.length];
        for (int i = 0; i < items.data.length; i++) {
            if (items.get(i) != null) {
                newBooks[i] = (Book) items.get(i);
            }
        }
        return newBooks;
    }

    public Book getItem(int id) {
        for (int i = 0; i < items.data.length; i++) {
            if (items.get(i) != null) {
                Book b = (Book) items.get(i);
                int bookId = b.getID();
                if (bookId == id) {
                    return b;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "items=" + items +
                ", ID=" + ID +
                ", m=" + m +
                '}';
    }
}
