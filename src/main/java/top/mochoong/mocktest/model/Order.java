package top.mochoong.mocktest.model;

import lombok.Data;

import java.util.List;

/**
 * @author: caizhenya
 * @email: caizhenya@shandiantech.com
 * @date: 2021/9/18 11:23
 */
@Data
public class Order {

    private Integer orderId;

    private String orderName;

    private List<Address> addressList;

}
