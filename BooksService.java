package gr.uniwa.booksrest.service;

import gr.uniwa.booksrest.model.Books;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface BooksService {
    
    static final String RESULT_SUCCESS = "<h3>success</h3>";
    static final String RESULT_FAILURE = "<h3>failure</h3>";
    
    List<Books> getAvailableBooksXml();
    List<Books> getAvailableBooksJson();
    Books getBookXml(int id);
    Books getBookJson(int id);
    String RegisterBooks(int id, String title, String author, int availability, HttpServletResponse servletResponse);
    String UpdateBooks(int id, String title, String author, HttpServletResponse servletResponse);
    String OrderBooks(int id, String title, String author, int availability, HttpServletResponse servletResponse);
    String DeleteBooks(int id);
}