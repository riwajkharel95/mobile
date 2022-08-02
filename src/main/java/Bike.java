public class Bike {

    private final int ID;
    private final String Make;
    private final String model;
    private final int price;
    private final int userid;
    private final String date;

    public Bike(int ID, String make, String model, int price, int userid, String date) {
        this.ID = ID;
        Make = make;
        this.model = model;
        this.price = price;
        this.userid = userid;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return model.toLowerCase().replaceAll("-"," ");
    }

    public int getPrice() {
        return price;
    }

    public int getUserid() {
        return userid;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "ID=" + ID +
                ", Make='" + Make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", userid=" + userid +
                ", date='" + date + '\'' +
                '}';
    }
}
