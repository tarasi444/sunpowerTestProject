package utils.enums;

public enum HomeAddresses {

    RIO_ROBLES_SAN_JOSE_CA_USA("Rio RoblesSan Jose, CA, USA");

    private final String address;

    HomeAddresses(String title) {
        this.address = title;
    }

    @Override
    public String toString() {
        return address;
    }
}
