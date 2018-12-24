package com.baizhi.service;

import com.baizhi.dao.BookDAO;
import com.baizhi.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class BookServiceImplements implements BookService {

    @Autowired
    private BookDAO bookDAO;

    Set<HostAndPort> nodes = new HashSet<HostAndPort>();

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<Book> showAllBooks() {

        nodes.add(new HostAndPort("192.168.197.137",7000));
        nodes.add(new HostAndPort("192.168.197.137",7001));
        nodes.add(new HostAndPort("192.168.197.137",7002));
        nodes.add(new HostAndPort("192.168.197.137",7003));
        nodes.add(new HostAndPort("192.168.197.137",7004));
        nodes.add(new HostAndPort("192.168.197.137",7005));

        JedisCluster jedisCluster = new JedisCluster(nodes);

        Map<String,String> map = new HashMap<String,String>();
        List<Book> books = bookDAO.showAll();
        for (Book book : books) {
            Integer sales = book.getSales();
            String hot = String.valueOf(sales);
            map.put(book.getId(), hot);
        }
        jedisCluster.hmset("showHot",map);

        return books;
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Book selectById(String id) {

        Book bookById = bookDAO.selectById(id);

        return bookById;
    }

    @Override
    @Transactional
    public void insertBook(Book book,MultipartFile fileName, HttpServletRequest request)  {

        //获得文件夹的相对路径
        String url = "/bookimgs";
        //获取文件夹的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath(url);
        //为文件夹指定名称
        String originalFilename = fileName.getOriginalFilename();
        System.out.println(originalFilename);
        //将文件上传至文件夹
        try{
            fileName.transferTo(new File(realPath,originalFilename));
        }catch (IOException e){
            e.printStackTrace();
        }

        book.setSales(1);
        book.setImgPath(request.getContextPath()+url+"/"+originalFilename);
        book.setId(UUID.randomUUID().toString());
        bookDAO.insert(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book,MultipartFile fileName){

    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public List<Book> sellHot() {
        nodes.add(new HostAndPort("192.168.197.137",7000));
        nodes.add(new HostAndPort("192.168.197.137",7001));
        nodes.add(new HostAndPort("192.168.197.137",7002));
        nodes.add(new HostAndPort("192.168.197.137",7003));
        nodes.add(new HostAndPort("192.168.197.137",7004));
        nodes.add(new HostAndPort("192.168.197.137",7005));

        JedisCluster jedisCluster = new JedisCluster(nodes);
        Map<String, String> books = jedisCluster.hgetAll("showHot");
        List<Book> list = new ArrayList<Book>();
        Set<String> set = books.keySet();
        for (String id : set) {
            Book book = bookDAO.selectById(id);
            list.add(book);
        }

        return list;
    }


}
