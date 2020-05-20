package com.example.demo.service;

import com.example.demo.entity.BorrowBooks;

import java.util.List;

public interface BorrowBooksService {


    // 新增借书记录
    String insertBorrowBooks(BorrowBooks borrowBooks);

    // 删除借书记录
    String delBorrowBooks(Integer id);

    // 修改借书信息
    String updateBorrowBooks(BorrowBooks borrowBooks);

    // 查看所有借书记录
    List<BorrowBooks> getBorrowBooks();

    //查询借出书籍名称
    BorrowBooks getBorrowBooksName(String BookName);

    //归还书籍后删除借书记录
    Integer delState(String BookName);

    // 根据id查询借书信息
    List<BorrowBooks> getBorrowBooksId(Integer id);
}
