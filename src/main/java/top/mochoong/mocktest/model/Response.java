package top.mochoong.mocktest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: caizhenya
 * @email: caizhenya@shandiantech.com
 * @date: 2021/9/17 11:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private int code;

    private String msg;

    private T data;

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }
}
