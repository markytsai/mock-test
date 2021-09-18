package top.mochoong.mocktest.model;

import lombok.Data;

import java.util.List;

/**
 * @author: caizhenya
 * @email: caizhenya@shandiantech.com
 * @date: 2021/9/17 11:23
 */
@Data
public class People {

    private String name;

    private Integer age;

    private List<Order> orderList;

    public People() {
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
