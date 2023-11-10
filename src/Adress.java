public class Adress {
    private String city;
    private int postalCode;
    private String streetName;
    private String port;

    public Adress(String city, int postalCode, String streetName, String port){
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.port = port;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "{\n" +
                "city:" + city +
                "\npostalCode:" + postalCode +
                "\nstreetName:" + streetName +
                "\nport:" + port +
                "\n}";
    }

    @Override
    public boolean equals(Object obj) {
        String adressObj = (String)obj;
        return this.getStreetName().equals(adressObj) || this.getCity().equals(adressObj);
    }
}
