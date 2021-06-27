package org.acme.books.controllers;

import org.acme.books.controllers.request.BookRequest;
import org.acme.books.models.Book;
import org.acme.books.services.BookService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Tag(name = "Books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BooksController {

    @Inject
    BookService bookService;

    @GET
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") Long id){
        return bookService.getBook(id);
    }

    @POST
    public Book createBook(BookRequest request){
        return bookService.create(request.getName(), request.getAuthor(), request.getPages());
    }
}
