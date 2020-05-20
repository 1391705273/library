package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BorrowBooks {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 借书人姓名
     */
    private String name;

    /**
     * 借书人性别
     */
    private String sex;

    /**
     * 借书人性别
     */
    private Integer age;

    /**
     * 被借书籍名称
     */
    private String bookName;

    /**
     * 被借书籍作者
     */
    private String bookAuthor;

    /**
     * 借书时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lendingTime;

    /**
     * 大约归还书籍时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnTime;

}
