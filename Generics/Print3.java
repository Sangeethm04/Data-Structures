package Generics;

public class Print3<Item> {

    private Item data;

    public Print3(Item data) {
        this.data = data;
    }

    public Item getData() {
        return data;
    }

    public void setData(Item data) {
        this.data = data;
    }

    public void print3() {
        System.out.println(data + "  " + data + "  " + data);
    }
  }