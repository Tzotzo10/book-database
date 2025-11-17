/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uniwa.booksrest;

import gr.uniwa.booksrest.client.Books;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:BooksRestService
 * [/BooksService]<br>
 * USAGE:
 * <pre>
 *        BooksRestClient client = new BooksRestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Georgia
 */
public class BooksRestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8081/WebBooksRestPrg/webresources";
    private static final String BOOK_SERVICE_URI = "bookService";
    private static final String BOOKS_XML_SERVICE_URI = "booksxml";
    private static final String BOOKS_JSON_SERVICE_URI = "booksjson";
    private static final String BOOKS_SERVICE_URI = "books";

    public BooksRestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(BOOK_SERVICE_URI);
    }
        
    public String OrderBooks(Books book) {
        Form form = new Form();
        form.param("id", String.valueOf(book.getID()));
        form.param("title", book.getTitle());
        form.param("author", book.getAuthor());
        form.param("order_num", String.valueOf(book.getOrder_Num()));
        
        
        WebTarget resource = webTarget;
        resource = resource.path(BOOKS_SERVICE_URI);
        return resource.request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
    }

     public String UpdateBooks(Books book) {
        Form form = new Form();
        form.param("id", String.valueOf(book.getID()));
        form.param("title", book.getTitle());
        form.param("author", book.getAuthor());
        form.param("availability", String.valueOf(book.getAvailability()));
        
        WebTarget resource = webTarget;
        resource = resource.path(BOOKS_SERVICE_URI);
        return resource.request().put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
    }

    public String getAvailableBooksXml() {
        WebTarget resource = webTarget;
        resource = resource.path(BOOKS_XML_SERVICE_URI);
        return resource.request().get(String.class);
    }

    public String getAvailableBooksJson() {
        WebTarget resource = webTarget;
        resource = resource.path(BOOKS_JSON_SERVICE_URI);
        return resource.request().get(String.class);
    }
    
    public String getBookByIDXml(String id) {
        WebTarget resource = webTarget;
        resource = resource.path(BOOKS_XML_SERVICE_URI).path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request().get(String.class);
    }
    
    public String getBookByIDJson(String id) {
        WebTarget resource = webTarget;
        resource = resource.path(BOOKS_JSON_SERVICE_URI).path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request().get(String.class);
    }
    
    public String RegisterBooks(Books book) {
        Form form = new Form();
        form.param("id", String.valueOf(book.getID()));
        form.param("title", book.getTitle());
        form.param("author", book.getAuthor());
        form.param("availability", String.valueOf(book.getAvailability()));
        
        WebTarget resource = webTarget;
        resource = resource.path(BOOKS_SERVICE_URI);
        return resource.request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
    }

    public String DeleteBooks(String id) {
        WebTarget resource = webTarget;
        resource = resource.path(BOOKS_SERVICE_URI).path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request().delete(String.class);
    }
    
    public void close() {
        client.close();
    }
}
