package org.acme.books.services;

import io.quarkus.panache.common.Parameters;
import org.acme.books.models.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@Transactional
@ApplicationScoped
public class BookService {

    public List<Book> getBooks(){
        return Book
                .find("")
                .list();
    }

    public Book getBook(Long id){

        return Book.<Book>
                find("id", id)
                .singleResult();
//                .orElseThrow( ()-> new WebApplicationException("Este libro no existe"));
    }

    public Book getBook(String name, String author){

        //SELECT FROM book WHERE name = ?1 AND author = ?2
        return Book.find("name = ?1 AND author = ?2", name, author)
                .singleResult();
                //.orElseThrow( ()-> new WebApplicationException("Este libro no existe"));
    }

    public Book create( String name, String author, Long pages){
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setPages(pages);

        book.persist();
        return book;
    }

}
