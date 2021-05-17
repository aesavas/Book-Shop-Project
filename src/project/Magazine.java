/*
   Author : aesavas
*/
package project;

public class Magazine extends Item{

    private String content;
    private String publisher;

    public Magazine(int id, String name, String publishDate, int quantity, String content, String publisher){
        super(id, name, "Magazine", publishDate, quantity);
        this.setContent(content);
        this.setPublisher(publisher);
    }
    @Override
    public int compareTo(Item otherItem) {
        return getName().compareTo(otherItem.getName());
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString(){
        return super.toString() +"\nContent : "+this.content+"\nPublisher : "+this.publisher+"\n"+"=============";
    }

}
