/*
   Author : aesavas
*/
package project;

public abstract class Item implements Comparable<Item> {
    private String name;
    private String publishDate;
    private int id;
    private String type;
    private int quantity;

    public Item(int id, String name, String type, String publishDate, int quantity){
        this.id = id;
        this.name = name;
        this.type = type;
        this.publishDate = publishDate;
        this.quantity = quantity;
    }


    @Override
    public int compareTo(Item otherItem){
        return this.name.compareTo(otherItem.name);
    }

    // Getter - Setter Section
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    // Method Section
    @Override
    public String toString(){
        return "============"+"\n"+ "ID : "+this.id+"\nName : "+this.name+"\nDate : "+this.publishDate+
                "\nType : "+this.type;
    }


}
