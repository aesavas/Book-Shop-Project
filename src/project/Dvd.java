//Ali Emre SAVAŞ
//13070001034
//Computer Engineering
package project;

public class Dvd extends Item{

    private String producer;
    private String duration;


    public Dvd(int iD){
        this.setiD(iD);
    }


    @Override
    public int compareTo(Item other){
        return this.getName().compareTo(other.getName());
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString(){
        return super.toString() +"\nProducer : "+this.producer+"\nDuration : "+this.duration+" min. "+"\n"+"=========";
    }


}

