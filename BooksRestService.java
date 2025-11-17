package gr.uniwa.booksrest;

import gr.uniwa.booksrest.database.BooksDao;
import gr.uniwa.booksrest.model.Books;
import gr.uniwa.booksrest.service.BooksService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/BooksService")
public class BooksRestService implements BooksService {
    
    BooksDao booksDao = new BooksDao();

    @GET
    @Path("/booksxml")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<Books> getAvailableBooksXml() {
        return booksDao.getAvailableBooks();
    }

    @GET
    @Path("/booksjson")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Books> getAvailableBooksJson() {
        return booksDao.getAvailableBooks();
    }

    @GET
    @Path("/booksxml/{bookid}")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public Books getBookXml(@PathParam("bookid")int id) {
        return booksDao.getBookByID(id);
    }

    @GET
    @Path("/booksjson/{bookid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Books getBookJson(@PathParam("bookid")int id) {
        return booksDao.getBookByID(id);
    }
    
    @POST
    @Path("/RegisterBooks")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String RegisterBooks(@FormParam("id") int id,
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("availability") int availability,
            @Context HttpServletResponse servletResponse, String RESULT_SUCCESS, String RESULT_FAILURE) {
        Books book = new Books();
        book.setID(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setAvailability(availability);
        int result = booksDao.RegisterBooks(book);
        if (result == 1) {
            return RESULT_SUCCESS;
        }
        return RESULT_FAILURE;
    }
    
   @PUT
    @Path("/UpdateBooks")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String UpdateBooks(@FormParam("id") int id,
            @FormParam("title") String title,
            @FormParam("author") String author,
            @Context HttpServletResponse servletResponse, String RESULT_SUCCESS, String RESULT_FAILURE) {
        Books book = new Books();
        book.setID(id);
        book.setTitle(title);
        book.setAuthor(author);
        int result = booksDao.UpdateBooks(book);
        if (result == 1) {
            return RESULT_SUCCESS;
        }
        return RESULT_FAILURE;
    }

    @POST
    @Path("/OrderBooks")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String OrderBooks(@FormParam("id") int id,
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("order_num") int order_num,
            @Context HttpServletResponse servletResponse, String RESULT_SUCCESS, String RESULT_FAILURE) {
        Books book = new Books();
        book.setID(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setOrder_Num(order_num);
        int result = booksDao.OrderBooks(book);
        if (result == 1) {
            return RESULT_SUCCESS;
        }
        return RESULT_FAILURE;
    }
    
    @DELETE
    @Path("/DeleteBooks/{bookid}")
    @Produces(MediaType.TEXT_HTML)
    public String DeleteBooks(@PathParam("bookid") int id, String RESULT_SUCCESS, String RESULT_FAILURE) {
        int result = booksDao.DeleteBooks(id);
        if (result == 1) {
            return RESULT_SUCCESS;
        }
        return RESULT_FAILURE;
    }

    @Override
    public String RegisterBooks(int id, String title, String author, int availability, HttpServletResponse servletResponse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String UpdateBooks(int id, String title, String author, HttpServletResponse servletResponse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String OrderBooks(int id, String title, String author, int availability, HttpServletResponse servletResponse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String DeleteBooks(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}