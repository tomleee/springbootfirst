package two.test.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import two.test.dao.User;
import two.test.service.UserService;

import java.util.Objects;

/**
 * @author tomlee
 * @program: first
 * @Date: 2019/12/21 10:37
 * @Description:
 */
@RestController   // @Controller+@ResponseBody两个注解的结合, 不能返回jsp页面
@RequestMapping(value = "/test1")
@Log4j2
public class Test1 {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/v1/add",produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public String addData(
            @PathVariable(name = "age") Integer ages,
            @PathVariable(name = "name",required = false) String name,
            @RequestBody User user){
        // request中发送json数据用post方式发送Content-type用application/json;
        // charset=utf-8方式发送的话，直接用springMVC的@RequestBody标签接收后面跟实体对象就行了，spring会帮你自动拼装成对象，如果Content-type设置成application/x-www-form-urlencoded;charset=utf-8就不能用spring的东西了，只能以常规的方式获取json串了
        /*通过@PathVariable，例如/blogs/1    // 路径的一部分
        通过@RequestParam，例如blogs?blogId=1*/   // 对资源进行过滤或筛选时
        // RequestBody主要通过请求体body传值，常用来处理content-type=application/json请求，同时支持get和post请求，能获取到body中的数据并转化为对象
        if (Objects.isNull(user) || StringUtils.isEmpty(name) || ages == 0){
            log.info("user or name {} or age not empty. ", name);
        }
        User newUser = User.builder().age(ages).build();
        userService.addUser(newUser);
        return null;

    }
}
