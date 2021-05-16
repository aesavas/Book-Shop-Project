package project;

public abstract class Item implements Comparable<Item> {

    private String name;
    private String date;
    private int iD;
    private String type;
    private String itemDetail;
    private String status;

    @Override
    public int compareTo(Item other){

        return this.name.compareTo(other.name);
    }

    public int getiD() {
        return iD;
    }
    public void setiD(int iD) {
        this.iD = iD;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getItemDetail() {
        return itemDetail;
    }
    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "============"+"\n"+ "ID : "+this.iD+"\nName : "+this.name+"\nDate : "+this.date+
                "\nType : "+this.type+"\nItem Detail : "+this.itemDetail+"\nStatus : "+this.status;
    }


}
