package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("request param name = {} age = {}", name, age);

        response.getWriter().write("ok");
    }

    //View를 반환하는 것이 아닌 Body값 반환 = RestController와 동일한 역할
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("request param name = {} age = {}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("request param name = {} age = {}", username, age);
        return "ok";
    }

    //String ,int, Integer 등의 단순 타입이면 @RequestParam도 생략가능
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
             String username,
             int age
    ){
        log.info("request param name = {} age = {}", username, age);
        return "ok";
    }

    //파라미터 필수 여부
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age
    ){
        log.info("request param name = {} age = {}", username, age);
        return "ok";
    }

    //defaultValue
    //defaultValue는 빈문자까지 처리해줌.
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age
    ){
        log.info("request param name = {} age = {}", username, age);
        return "ok";
    }

    //map으로 처리
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap
    ){
        log.info("request param name = {} age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}
