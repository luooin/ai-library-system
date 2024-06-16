package com.book.backend.pojo.dto;

import com.book.backend.pojo.BooksBorrow;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 */
@Data
public class BooksBorrowDTO extends BooksBorrow implements Serializable {
    /**
     * 接受图书管理员的id
     */
    public Integer bookAdminId;

}
