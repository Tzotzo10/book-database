package gr.uniwa.booksrest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Books {
    
    private int id;
    private String title;
    private String author;
    private int availability;
    private int order_num;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public void setOrder_Num(int order_num) {
        this.order_num = order_num;
    }

    public int getOrder_Num() {
        return order_num;
    }
        
}
