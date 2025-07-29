package org.github.user;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_USER_NAME, UserApplication.class, args);
    }
}
