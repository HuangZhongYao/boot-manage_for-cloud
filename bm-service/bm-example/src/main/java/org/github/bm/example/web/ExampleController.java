package org.github.bm.example.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.github.bm.base.base.response.ApiResponse;
import org.github.bm.base.base.web.BaseController;
import org.github.bm.example.dto.ExampleValidateInputDTO;
import org.github.bm.example.service.IExampleService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 演示controller,演示Validate注解使用。接口编写方式、mybatis-plus查询
 *
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-13 17:05
 */
@AllArgsConstructor // @AllArgsConstructor 加了全参构造函数注解可以省掉 @Autowired、@Resource来注入所需要的bean
@Tag(name = "演示使用参数验证", description = "演示使用")
@RestController
@RequestMapping("/test")
public class ExampleController extends BaseController {

    IExampleService exampleService;

    @Operation(summary = "演示validate注解", description = "测试validate注解的使用")//接口描述
    @PostMapping(value = "/exampleValidate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<String> exampleValidateAnnotations(
            @RequestBody @Validated ExampleValidateInputDTO inputDTO) {
        return ApiResponse.ok("参数全部验证通过");
    }

    @Operation(summary = "演示RequestParam注解参数验证", description = "测试RequestParam注解的使用")//接口描述
    @PostMapping(value = "/exampleRequestParam", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<String> exampleRequestParam(@RequestParam(name = "name") String name, @RequestParam(name = "code") String code) {
        return ApiResponse.ok("参数全部验证通过");
    }
}
