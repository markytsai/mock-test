package top.mochoong.mocktest.client;

import feign.hystrix.Mapping;
import feign.hystrix.Mock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import top.mochoong.mocktest.model.Address;
import top.mochoong.mocktest.model.People;
import top.mochoong.mocktest.model.Response;

/**
 * @author: caizhenya
 * @email: caizhenya@shandiantech.com
 * @date: 2021/9/17 11:26
 */
@FeignClient(
        name = "mock-test",
        path = "/mock-test1",
        fallbackFactory = PeopleClientFallbackFactory.class
)
public interface PeopleClient {

    /**
     * getPeople
     *
     * @return
     */
    @Mock(mappings = {
            @Mapping(type = Response.class, name = "code", value = "200")
    })
    @GetMapping("/getPeople")
    Response<People> getPeople();

    @Mock(mappings = {
            @Mapping(type = Response.class, name = "code", value = "200"),
            @Mapping(type = People.class, name = "name", value = "caizhenya"),
            @Mapping(type = People.class, name = "age", value = "24"),
            @Mapping(type = Address.class, name = "district", value = "hangzhou"),
            @Mapping(type = Address.class, name = "code", value = "0571"),
    })
    @GetMapping("/getPeopleEx")
    Response<People> getPeopleEx();

    /**
     * T: 不支持 Java包装类型的类
     *
     * @return
     */
    @Mock(mappings = {
            @Mapping(type = Response.class, name = "code", value = "200"),
            @Mapping(type = Integer.class, name = "data", value = "200")
    })
    @GetMapping("/getPeopleEx")
    Response<Integer> getInteger();

    @Mock(mappings = {
            @Mapping(type = People.class, name = "age", value = "24")
    })
    @GetMapping("/getPeople")
    People getPeopleSingle();
}
