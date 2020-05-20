package com.example.demo.service.impl;

import com.example.demo.entity.BorrowBooks;
import com.example.demo.entity.Library;
import com.example.demo.mapper.LibraryMapper;
import com.example.demo.service.BorrowBooksService;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.LineBreakMeasurer;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryMapper libraryMapper;
    @Autowired
    private BorrowBooksService borrowBooksService;

    /**
     * 新增书籍
     * @param library
     * @return
     */
    @Override
    public String insertLibrary(Library library) {
        Integer count = libraryMapper.insertLibrary(library);
        if (count > 0 ){
            return "该书已成功入库!";
        }
        return "请确认书籍信息是否正确!!";
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @Override
    public String delLibrary(Integer id) {
        Integer count = libraryMapper.delLibrary(id);
        if (count > 0 ){
            return "该书已成功从库中删除!";
        }
        return "书籍删除失败!!";
    }

    /**
     * 更新书籍
     * @param
     * @return
     */
    @Override
    public String updateLibrary(Library library) {
        Integer count = libraryMapper.updateLibrary(library);
        if (count > 0 ){
            return "该书已成功更新信息!";
        }
        return "更新书籍信息失败!!";
    }

    /**
     * 查询所有书籍信息
     * @return
     */
    @Override
    public List<Library> getLibrary() {
        return libraryMapper.getLibrary();
    }

    /**
     * 根据书籍id查询书籍信息
     * @param id
     * @return
     */
    @Override
    public List<Library> getLibraryId(Integer id) {
        return libraryMapper.getLibraryId(id);
    }

    /**
     * 根据书籍id归还书籍
     * @param bookName
     * @return
     */
    @Override
    public String updateByState(String bookName) {
        Integer count = libraryMapper.updateByState(bookName);
        BorrowBooks borrowBooks = borrowBooksService.getBorrowBooksName(bookName);
        borrowBooksService.delState(borrowBooks.getBookName());
        if (count > 0 ){
            return "书籍已成功归还!";
        }
        return "书籍归还失败!!";
    }

    /**
     * 根据书籍id借出书籍
     * @param bookName
     * @param
     * @return
     */
    @Override
    public String updateState(String bookName) {
        Integer count = libraryMapper.updateState(bookName);
        if (count > 0 ){
            return "书籍已成功借出!";
        }
        return "书籍借出失败!!";
    }

    /**
     * 查询书籍根据书籍名称
     * @param name
     * @return
     */
    @Override
    public Library getName(String name) {
        return libraryMapper.getName(name);
    }

    /**
     * 查询书籍状态不为已借出的
     * @param state
     * @return
     */
    @Override
    public List<Library> getState(String state) {
        return libraryMapper.getState(state);
    }
}
