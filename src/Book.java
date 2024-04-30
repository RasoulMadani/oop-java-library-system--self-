public class Book {
    String name;
    int ID;
    Writer[] writers;
    int year;
    public Book(String name, int ID , Writer[]writers , int year){
        this.name= name;
        this.ID = ID;
        this.writers = writers;
        this.year = year;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Writer[] getWriters() {
        return writers;
    }

    public void setWriters(Writer[] writers) {
        this.writers = writers;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
