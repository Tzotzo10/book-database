package gr.uniwa.booksrest.client;

import gr.uniwa.booksrest.BooksRestClient;

public class RestDbClient {

    public static void main(String[] args) {
        
        BooksRestClient client = new BooksRestClient();
        
        //GET AVAILABLE BOOKS (XML)
        String booksxml = client.getAvailableBooksXml();
        System.out.println("Books List (xml): " + booksxml);
        
        System.out.println();
        
        //GET AVAILABLE BOOKS (JSON)
        String booksjson = client.getAvailableBooksJson();
        System.out.println("Books List (json): " + booksjson);
        
        System.out.println();
        
        //GET ONE BOOK (XML)
        String book1xml=client.getBookByIDXml("1");
        System.out.println("Book (xml): " + book1xml);
        
        System.out.println();
        
        //GET ONE BOOK (JSON)
        String book1json=client.getBookByIDJson("1");
        System.out.println("Book (json): " + book1json);
        
        System.out.println();
        
        //REGISTER NEW BOOK
        Books book = new Books();
        book.setID(book.getID());
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setAvailability(book.getAvailability()+1);
        String response = client.RegisterBooks(book);
        System.out.println("Register book result: " + response);
        
        System.out.println();
        
        //UPDATE BOOK
        Books book1 = new Books();
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setAvailability(book.getAvailability());
        String response1 = client.UpdateBooks(book1);
        System.out.println("Update book result: " + response1);
        
        System.out.println();
        
        //ORDER BOOK
        Books book2 = new Books();
        book1.setID(book.getID());
        book2.setTitle(book.getTitle());
        book2.setAuthor(book.getAuthor());
        book2.setOrder_Num(book.getOrder_Num());
        String response2 = client.OrderBooks(book2);
        System.out.println("Order book result: " + response2);
        
        System.out.println();
        
        //DELETE BOOKS
        String DeleteBooks = client.DeleteBooks(String.valueOf(book.getID()));
        System.out.println("Delete book result: " + DeleteBooks);
    }
    
}
