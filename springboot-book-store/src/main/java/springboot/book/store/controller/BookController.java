/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.book.store.controller;

import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.book.store.entity.BookEntity;
import springboot.book.store.response.BookListResponse;
import springboot.book.store.response.BookResponse;
import springboot.book.store.response.ServiceStatus;
import springboot.book.store.service.BookService;

/**
 *
 * @author francis taguiam
 */
@RestController
@RequestMapping("/BookController")
public class BookController {

    @Autowired
    private BookService bookService;

    private Gson gson = new Gson();

    @RequestMapping(method = RequestMethod.POST, value = "/book")
    public BookResponse createBook(@RequestBody BookEntity data) {
        BookEntity book = bookService.save(data);
        if (book != null) {
            return new BookResponse(book, ServiceStatus.SUCCESS);
        } else {
            return new BookResponse(ServiceStatus.FAILED, "empty data!");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/book")
    public BookResponse updateBook(@RequestBody BookEntity book) {
        System.out.println("update request mapping...");
        BookEntity update = bookService.update(book);
        String payload = gson.toJson(book);
        System.out.println("data: " + payload);

        if (update != null) {
            return new BookResponse(book, ServiceStatus.SUCCESS);
        } else {
            return new BookResponse(ServiceStatus.FAILED, "NO ID FOUND!!");
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/book")
    public BookListResponse findBooks() {
        List<BookEntity> books = bookService.getAll();
        return new BookListResponse(books, ServiceStatus.SUCCESS, "Successful request!");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/book/delete")
    public BookResponse deleteByBookId(@RequestBody BookEntity book) {
        System.out.println("delete request mapping.. ");

        boolean condition = bookService.deleteByBookId(book);

        if (condition == true) {
            return new BookResponse(ServiceStatus.SUCCESS, "SUCCESSFULLY DELETE");
        } else {
            return new BookResponse(ServiceStatus.FAILED, "NO ID FOUND");
        }

    }
}
