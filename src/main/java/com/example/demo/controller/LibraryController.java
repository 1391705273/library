package com.example.demo.controller;

import com.example.demo.entity.BorrowBooks;
import com.example.demo.entity.Library;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    /**
     * 书籍库
     * @return
     */
    @GetMapping("/library")
    public String library(){
        return "library";
    }

    /**
     * 编辑书籍
     * @return
     */
    @GetMapping("/editLibrary")
    public String editLibrary(){
        return "editLibrary";
    }

    /**
     * 新增书籍
     * @param library
     * @return
     */
    @PostMapping("/insertLibrary")
    @ResponseBody
    public String insertLibrary(Library library) {
        return libraryService.insertLibrary(library);
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @PostMapping("/delLibrary")
    @ResponseBody
    public String delLibrary(Integer id) {
        return libraryService.delLibrary(id);
    }

    /**
     * 更新书籍
     * @param library
     * @return
     */
    @PostMapping("/updateLibrary")
    @ResponseBody
    public String updateLibrary(Library library) {
        return libraryService.updateLibrary(library);
    }

    /**
     * 查询所有书籍信息
     * @return
     */
    @GetMapping("/getLibrary")
    @ResponseBody
    public List<Library> getLibrary() {
        return libraryService.getLibrary();
    }

    /**
     * 根据书籍id查询该书信息
     * @param id
     * @return
     */
    @GetMapping("/getLibraryId")
    @ResponseBody
    public List<Library> getLibraryId(Integer id) {
        return libraryService.getLibraryId(id);
    }

    /**
     * 根据书籍bookName借出书籍
     * @param bookName
     * @return
     */
    @PostMapping("/updateState")
    @ResponseBody
    public String updateState(String bookName){
        return libraryService.updateState(bookName);
    }

    /**
     * 根据书籍bookName归还书籍
     * @param bookName
     * @param
     * @return
     */
    @PostMapping("/updateByState")
    @ResponseBody
    public String updateByState(String bookName){
        return libraryService.updateByState(bookName);
    }

    /**
     * 查询借出书籍名称
     * @return
     */
    @ResponseBody
    @GetMapping("/getName")
    public Library getName(String name) {
        return libraryService.getName(name);
    }

    /**
     * 查询书籍状态不为已借出的
     * @param state
     * @return
     */
    @GetMapping("/getState")
    @ResponseBody
    public List<Library> getState(String state){
        return libraryService.getState(state);
    }
}
