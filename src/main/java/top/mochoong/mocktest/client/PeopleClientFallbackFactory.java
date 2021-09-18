package top.mochoong.mocktest.client;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.mochoong.mocktest.model.People;
import top.mochoong.mocktest.model.Response;

import javax.annotation.Resource;

/**
 * @author: caizhenya
 * @email: caizhenya@shandiantech.com
 * @date: 2021/9/17 11:26
 */
@Component
public class PeopleClientFallbackFactory implements FallbackFactory<PeopleClient> {

    @Resource
    private PeopleClientFallback peopleClientFallback;

    private Logger logger = LoggerFactory.getLogger(PeopleClientFallbackFactory.class);


    @Component
    class PeopleClientFallback implements PeopleClient {
        @Override
        public Response<People> getPeople() {
            return new Response<>(500, "fail");
        }

        @Override
        public Response<People> getPeopleEx() {
            return new Response<>(500, "fail");
        }

        @Override
        public Response<Integer> getInteger() {
            return new Response<>(500, "fail");
        }

        @Override
        public People getPeopleSingle() {
            return new People();
        }
    }


    @Override
    public PeopleClient create(Throwable throwable) {
        logger.error("", throwable);
        return peopleClientFallback;
    }
}
