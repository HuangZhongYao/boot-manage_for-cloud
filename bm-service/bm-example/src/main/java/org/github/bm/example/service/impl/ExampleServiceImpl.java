package org.github.bm.example.service.impl;

import lombok.AllArgsConstructor;
import org.github.bm.example.service.IExampleService;
import org.springframework.stereotype.Service;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-13 17:09
 */
@Service
// @AllArgsConstructor 加了全参构造函数注解可以省掉 @Autowired、@Resource来注入所需要的bean
@AllArgsConstructor
public class ExampleServiceImpl implements IExampleService {
}
