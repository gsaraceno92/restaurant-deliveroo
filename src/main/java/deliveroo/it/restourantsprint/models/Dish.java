package deliveroo.it.restourantsprint.models;

public class Dish {

    private String name;
    private float price;

    public Dish(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
