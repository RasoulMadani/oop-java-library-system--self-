public class Member {
    String name;
    int ID;
    Address address;

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
    public void addBorrow(Borrow borrow){

    }
    public Borrow[] getTotalBorrows(){
        return null;
    }
    public Member getMember(int id) {
        return null;
    }
}
