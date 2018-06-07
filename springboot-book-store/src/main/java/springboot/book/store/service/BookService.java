/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.book.store.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.book.store.entity.BookEntity;
import springboot.book.store.repository.BookRepository;

/**
 *
 * @author francis taguiam
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookEntity save(BookEntity data) {
        BookEntity retval = null;
        if (data != null) {
            retval = bookRepository.save(data);
            return retval;
        } else {
            return retval;
        }

    }

    public BookEntity update(BookEntity book) {
        System.out.println("updating book....");

        boolean existsById = bookRepository.existsById(book.getBookId());
        BookEntity retval = null;

        if (existsById == true) {
            retval = bookRepository.save(book);
        } else {
            retval = null;
        }

        return retval;
    }

    public List<BookEntity> getAll() {
        List<BookEntity> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        System.out.println("getall: " + books);
        return books;
    }

    public boolean deleteByBookId(BookEntity book) {
        System.out.println("deleting book...");
        boolean condition = true;
        boolean findById = bookRepository.existsById(book.getBookId());

        if (findById == true) {
            bookRepository.deleteById(book.getBookId());
            condition = true;
        } else {
            condition = false;
        }
        return condition;
    }
}
