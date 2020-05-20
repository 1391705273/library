package com.example.demo.mapper;

import com.example.demo.entity.BorrowBooks;
import com.example.demo.entity.Library;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BorrowBooksMapper {

    // 新增借书记录
    Integer insertBorrowBooks(BorrowBooks borrowBooks);

    // 删除借书记录
    Integer delBorrowBooks(Integer id);

    // 修改借书信息
    Integer updateBorrowBooks(BorrowBooks borrowBooks);

    // 查看所有借书记录
    List<BorrowBooks> getBorrowBooks();

    //查询借出书籍名称
    BorrowBooks getBorrowBooksName(String BookName);

    //归还书籍后删除借书记录
    Integer delState(String BookName);

    // 根据id查询借书信息
    List<BorrowBooks> getBorrowBooksId(Integer id);
}
