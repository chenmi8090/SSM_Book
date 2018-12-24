package com.baizhi.controller;


import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/showAllBooks")
    //查询所有
    public String showAllBooks(Model model){
        List<Book> books = bookService.showAllBooks();
        model.addAttribute("books",books);

        return "forward:/others/showAllBooks.jsp";
    }

    @RequestMapping("/insertBook")
    //添加图书
    public String insertBook(Book book,String date, MultipartFile fileName, HttpServletRequest request) throws IOException,ParseException  {

        //将页面得到的字符串时间格式转换为date类型时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date createDate = sdf.parse(date);

        try{
            System.out.println(createDate);
            bookService.insertBook(book,fileName,request);
            return "redirect:/books/showAllBooks";
        }catch(Exception e){
            e.printStackTrace();
            return "redirect:/others/addBook.jap";
        }
    }

    @RequestMapping("/showHot")
    @ResponseBody
    //热卖图书
    public List<Book> showHot(){

        List<Book> books = bookService.sellHot();

        return books;
    }
}
