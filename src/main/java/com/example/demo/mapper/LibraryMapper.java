package com.example.demo.mapper;

import com.example.demo.entity.BorrowBooks;
import com.example.demo.entity.Library;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LibraryMapper {

    // 新增书籍信息
    Integer insertLibrary(Library library);

    // 删除书籍信息
    Integer delLibrary(Integer id);

    // 修改书籍信息
    Integer updateLibrary(Library library);

    // 查看所有书籍信息
    List<Library> getLibrary();

    // 根据书籍id查询书籍信息
    List<Library> getLibraryId(Integer id);

    // 根据书籍id借出书籍
    Integer updateState(String bookName);

    // 根据书籍id归还书籍
    Integer updateByState(String bookName);

    // 查询借出书籍名称
    Library getName(String name);

    // 查询书籍不为已借出的
    List<Library> getState(String state);
}
