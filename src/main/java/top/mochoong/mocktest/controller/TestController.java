package top.mochoong.mocktest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mochoong.mocktest.client.PeopleClient;
import top.mochoong.mocktest.model.Response;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: caizhenya
 * @email: caizhenya@shandiantech.com
 * @date: 2021/9/17 11:22
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Resource
    private PeopleClient peopleClient;

    @GetMapping("/getMap")
    public Response<List<Object>> getAll() {
        List<Object> list = new ArrayList<>();
        list.add(peopleClient.getPeopleEx());
        list.add(peopleClient.getInteger());
        list.add(peopleClient.getPeopleSingle());
        return new Response(list);
    }
}
