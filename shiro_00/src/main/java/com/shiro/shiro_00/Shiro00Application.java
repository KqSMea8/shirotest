package com.shiro.shiro_00;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URLDecoder;

@SpringBootApplication
public class Shiro00Application {

    public static void main(String[] args) throws Exception{

        SpringApplication.run(Shiro00Application.class, args);
        /*String s = URLDecoder.decode("defaultToken1_um_not_loaded%40%40http%3A%2F%2Fpre-validate-ntm.aliyun-inc.com%2F%3F%23%2Faccessrequest%3F_k%3D5rg0nz%40%401559792286810", "utf8");
        System.out.println(s);*/
        //通过安全工具类获取实体
        Subject subject = SecurityUtils.getSubject();
        //通过实体获取
        Session session = subject.getSession();
        session.setAttribute("ad", "dsa");
        if (subject.isAuthenticated()) {
            UsernamePasswordToken passwordToken = new UsernamePasswordToken("lonestarr", "vespa");
            passwordToken.setRememberMe(true);
            subject.login(passwordToken);
        }
    }

}
