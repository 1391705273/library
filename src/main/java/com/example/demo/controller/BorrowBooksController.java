package com.example.demo.controller;

import com.example.demo.entity.BorrowBooks;
import com.example.demo.service.BorrowBooksService;
import org.apache.coyote.OutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.FaultAction;
import java.util.List;

@Controller
public class BorrowBooksController {

    @Autowired
    private BorrowBooksService borrowBooksService;

    /**
     * 借书记录
     * @return
     */
    @GetMapping("/borrowBooks")
    public String borrowBooks(){
        return "borrowBooks";
    }

    /**
     * 编辑借书记录
     * @return
     */
    @GetMapping("/editBorrowBooks")
    public String editBorrowBooks(){
        return "editBorrowBooks";
    }

    /**
     * 插入借书日志
     * @param borrowBooks
     * @return
     */
    @ResponseBody
    @PostMapping("/insertBorrowBooks")
    public String insertBorrowBooks(BorrowBooks borrowBooks) {
        return borrowBooksService.insertBorrowBooks(borrowBooks);
    }

    /**
     * 删除借书日志
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/delBorrowBooks")
    public String delBorrowBooks(Integer id) {
        return borrowBooksService.delBorrowBooks(id);
    }

    /**
     * 修改借书日志
     * @param borrowBooks
     * @return
     */
    @ResponseBody
    @PostMapping("/updateBorrowBooks")
    public String updateBorrowBooks(BorrowBooks borrowBooks) {
        return borrowBooksService.updateBorrowBooks(borrowBooks);
    }

    /**
     * 查询所有借书日志
     * @return
     */
    @ResponseBody
    @GetMapping("/getBorrowBooks")
    public List<BorrowBooks> getBorrowBooks() {
        return borrowBooksService.getBorrowBooks();
    }

    /**
     * 查询书籍名称
     * @return
     */
    @ResponseBody
    @GetMapping("/getBorrowBooksName")
    public  BorrowBooks getBorrowBooksName(String BookName) {
        return borrowBooksService.getBorrowBooksName(BookName);
    }

    /**
     * 归还书籍后删除借书记录
     * @param BookName
     * @return
     */
    @PostMapping("/delState")
    @ResponseBody
    public Integer delState(String BookName){
        return borrowBooksService.delState(BookName);
    }
}
