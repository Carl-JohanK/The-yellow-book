public class AdressBuilder {
    private String city;
    private int postalCode;
    private String streetName;
    private String port;

    public AdressBuilder City(String city){
        this.city = city;
        return this;
    }
    public AdressBuilder PostalCode(int postalCode){
        this.postalCode = postalCode;
        return this;
    }
    public AdressBuilder StreetName(String streetName){
        this.streetName = streetName;
        return this;
    }
    public AdressBuilder Port(String port){
        this.port = port;
        return this;
    }
    public Adress Build(){
        return new Adress(city, postalCode, streetName, port);
    }
}
