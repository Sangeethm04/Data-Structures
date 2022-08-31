public class Vegetables {

    private String name;
    private String color;
    private int calories;

    public Vegetables(String name, String color, int calories) {
        this.name = name;
        this.color = color;
        this.calories = calories;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public String getName() {
        return this.name;
    }
    public String getColor() {
        return this.color;
    }
    public int getCalories() {
        return this.calories;
    }

    public void swapColor(Vegetables veg2) {
        String hello = this.color;
        this.color = veg2.color;
        veg2.color = hello;
    }

    public String toString() {
        return "This is a " + this.name + ", it's color is " + this.color + ", and one serving has " + this.calories + " calories";
    }

    public static void main(String[] args) {
        Vegetables veg1 = new Vegetables("Tomatos", "red", 40);
        Vegetables veg2 = new Vegetables("Carrot", "orange", 50);
        System.out.println(veg1.toString());
        System.out.println(veg2.toString());
        veg1.swapColor(veg2);
        System.out.println(veg1.toString());
        System.out.println(veg2.toString());
    }
}