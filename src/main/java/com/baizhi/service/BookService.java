package com.baizhi.service;

import com.baizhi.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface BookService {

    public List<Book> showAllBooks();

    public Book selectById(String id);

    public void insertBook(Book book, MultipartFile fileName, HttpServletRequest request);

    public void updateBook(Book book,MultipartFile fileName);

    public List<Book> sellHot();

}
