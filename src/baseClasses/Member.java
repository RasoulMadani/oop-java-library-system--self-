package baseClasses;

import publicClasses.ArrayOfObjects;

public class Member {


    String name;
    int ID;

    Address address;

    public int getID() {
        return ID;
    }
    public Address getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    ArrayOfObjects borrows = new ArrayOfObjects();

    public Member(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public Member(String name, int ID, Address address) {
        this.name = name;
        this.ID = ID;
        this.address = address;
    }
    public int getNumBorrows(){
        return 1;
    }
    public void addBorrow(Borrow borrow) {
        borrows.add(borrow);
    }
    public Borrow[] getBorrows() {
        Borrow[] newBorrow = new Borrow[borrows.data.length];
        for (int i = 0; i < borrows.data.length; i++) {
            if (borrows.get(i) != null) {
                newBorrow[i] = (Borrow) borrows.get(i);
            }
        }
        return newBorrow;
    }
    public Borrow getBorrow(int id) {
        for (int i = 0; i < borrows.data.length; i++) {
            if (borrows.get(i) != null) {
                Borrow m = (Borrow) borrows.get(i);
                int memberId = m.getID();
                if (memberId == id) {
                    return m;
                }
            }
        }
        return null;
    }
    public Borrow[] getTotalBorrows(){
        return null;
    }
    public Member getMember(int id) {
        return null;
    }
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", address=" + address +
                '}';
    }
}
