//Ali Emre SAVAŞ
//13070001034
//Computer Engineering
package project;

public class Magazine extends Item{

    private String issue;
    private String publisher;

    public Magazine(int iD){
        this.setiD(iD);
    }
    @Override
    public int compareTo(Item other) {

        return getName().compareTo(other.getName());
    }
    public String getIssue() {
        return issue;
    }
    public void setIssue(String issue) {
        this.issue = issue;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString(){
        return super.toString() +"\nIssue : "+this.issue+"\nPublisher : "+this.publisher+"\n"+"=============";
    }

}
