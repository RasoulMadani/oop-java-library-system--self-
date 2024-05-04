package baseClasses;

public class Address {
    String provinceName;
    String townName;
    String streetName;
    int plaque;

    public String getProvinceName() {
        return provinceName;
    }

    public String getTownName() {
        return townName;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPlaque() {
        return plaque;
    }

    public Address(String provinceName, String townName, String streetName, int plaque){
        this.provinceName = provinceName;
        this.townName = townName;
        this.streetName = streetName;
        this.plaque = plaque;
    }

    @Override
    public String toString() {
        return "Address{" +
                "provinceName='" + provinceName + '\'' +
                ", townName='" + townName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", plaque=" + plaque +
                '}';
    }
}
