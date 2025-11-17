package gr.uniwa.booksrest.database;

import gr.uniwa.booksrest.model.Books;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {
    
    public static Connection getConnection() {
        Connection con = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rest_db", "papapanagiotou", "");
        } catch (ClassNotFoundException | SQLException ex) {           
        }
        return con;
    }
    
    public List<Books> getAvailableBooks() {
        List<Books> booksList = new ArrayList();
        Connection con = BooksDao.getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE availability>0");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Books book = new Books();  
                book.setID(rs.getInt(1));  
                book.setTitle(rs.getString(2));  
                book.setAuthor(rs.getString(3));  
                book.setAvailability(rs.getInt(4));  
                booksList.add(book);  
            }  
            con.close();            
        } catch (SQLException ex) {}
        
        return booksList;
    } 
    
    public Books getBookByID(int id) {
        Books book = new Books();
        Connection con = BooksDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?");
            ps.setInt(1,id);  
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){  
                book.setID(rs.getInt(1));  
                book.setTitle(rs.getString(2));  
                book.setAuthor(rs.getString(3));  
                book.setAvailability(rs.getInt(4));  
            }
            con.close();
        } catch (SQLException ex) {}
        return book;
    }
    
    public int RegisterBooks(Books book) {
        int status = 0;
        Connection con = BooksDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO books(id, title, author, availability) VALUES (?, ?, ?, ?)");
            ps.setInt(1,book.getID());  
            ps.setString(2,book.getTitle());  
            ps.setString(3,book.getAuthor());  
            ps.setInt(4,book.getAvailability());  
            status=ps.executeUpdate();                
            con.close();
            System.out.println("Insert Completed");
        } catch (SQLException ex) {System.out.println("Insert Error");}
        return status;        
    }
    
    public int UpdateBooks(Books book) {
        int status = 0;
        Connection con = BooksDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE books SET title=?, author=? WHERE id=?");
            ps.setInt(1, book.getID());
            ps.setString(2, book.getTitle());  
            ps.setString(3, book.getAuthor()); 
            status=ps.executeUpdate();                
            con.close();
            System.out.println("Update Completed");
        } catch (SQLException ex) {System.out.println("Update Error");}
        return status;
    }
    
    public int OrderBooks(Books book) {
        int status = 0;
        Connection con = BooksDao.getConnection();
        try {
            int dumvar;
            dumvar=book.getOrder_Num();
            while (dumvar>0) {
            PreparedStatement ps = con.prepareStatement("UPDATE books(id, title, author, availability) VALUES (?, ?, ?, ?)");
            if (book.getAvailability()<=0) {
                System.out.println("Out of Stock");
                break;
            }
            ps.setInt(1,book.getID());  
            ps.setString(2,book.getTitle());  
            ps.setString(3,book.getAuthor());  
            ps.setInt(4,book.getAvailability()-1);  
            status=ps.executeUpdate();
            dumvar--;
            }
            con.close();
            System.out.println("Succesful Order");
        } catch (SQLException ex) {System.out.println("Order Error");}
        return status;        
    }
    
    public int DeleteBooks(int id) {
        int status = 0;
        Connection con = BooksDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setInt(1, id);
            status=ps.executeUpdate();                
            con.close();
            System.out.println("Delete Completed");
        } catch (SQLException ex) {System.out.println("Delete Error");}
        return status;
    }
}