package com.example.demo.service.impl;

import com.example.demo.entity.BorrowBooks;
import com.example.demo.entity.Library;
import com.example.demo.mapper.BorrowBooksMapper;
import com.example.demo.mapper.LibraryMapper;
import com.example.demo.service.BorrowBooksService;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;

@Service
public class BorrowBooksServiceImpl implements BorrowBooksService {

    @Autowired
    private BorrowBooksMapper borrowBooksMapper;
    @Autowired
    private LibraryService libraryService;

    @Override
    public String insertBorrowBooks(BorrowBooks borrowBooks) {
        Integer count = borrowBooksMapper.insertBorrowBooks(borrowBooks);
        Library library = libraryService.getName(borrowBooks.getBookName());
        libraryService.updateState(library.getBookName());
        if (count > 0 ){
            return "成功新增借书记录!";
        }
        return "新增借书记录失败,请查看是否有误!!";
    }

    @Override
    public String delBorrowBooks(Integer id) {
        Integer count = borrowBooksMapper.delBorrowBooks(id);
        if (count > 0 ){
            return "成功删除借书记录!";
        }
        return "删除借书记录失败!!";
    }

    @Override
    public String updateBorrowBooks(BorrowBooks borrowBooks) {
        Integer count = borrowBooksMapper.updateBorrowBooks(borrowBooks);
        if (count > 0 ){
            return "成功修改借书记录信息!";
        }
        return "修改借书记录失败,请查看是否有误!!";
    }

    /**
     * 查询所有借书记录
     * @return
     */
    @Override
    public List<BorrowBooks> getBorrowBooks() {
        return borrowBooksMapper.getBorrowBooks();
    }

    /**
     * 根据书名查询
     * @param BookName
     * @return
     */
    @Override
    public BorrowBooks getBorrowBooksName(String BookName) {
        return borrowBooksMapper.getBorrowBooksName(BookName);
    }

    /**
     * 归还书籍后删除借书记录
     * @param BookName
     * @return
     */
    @Override
    public Integer delState(String BookName) {
        return borrowBooksMapper.delState(BookName);
    }

    /**
     * 根据id查询借书记录
     * @param id
     * @return
     */
    @Override
    public List<BorrowBooks> getBorrowBooksId(Integer id) {
        return borrowBooksMapper.getBorrowBooksId(id);
    }
}
