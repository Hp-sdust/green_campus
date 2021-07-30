package com.qdtdhl.campus;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SchemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchemaApplication.class, args);

        /**
         *我们在开发Spring Boot应用时，通常同一套程序会被应用和安装到几个不同的环境，比如：开发、测试、生产等。其中每个环境的数据库地址、服务器端口等等配置都会不同，如果在为不同环境打包时都要频繁修改配置文件的话，那必将是个非常繁琐且容易发生错误的事。
         * 对于多环境的配置，各种项目构建工具或是框架的基本思路是一致的，通过配置多份不同环境的配置文件，再通过打包命令指定需要打包的内容之后进行区分打包，Spring Boot也不例外，或者说更加简单。
         * 在Spring Boot中多环境配置文件名需要满足application-{profile}.properties的格式，其中{profile}对应你的环境标识，比如：
         * application-dev.properties：开发环境
         * application-test.properties：测试环境
         * application-prod.properties：生产环境
         * 至于哪个具体的配置文件会被加载，需要在application.properties文件中通过spring.profiles.active属性来设置，其值对应{profile}值。
         * 如：spring.profiles.active=test就会加载application-test.properties配置文件内容
         * ————————————————
         * 版权声明：本文为CSDN博主「qq_45395640」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
         * 原文链接：https://blog.csdn.net/qq_45395640/article/details/104407074
         */

        /*String jsonFilePath = System.getProperty("user.dir") + "/dev.json";
        if (FileUtil.exist(jsonFilePath)) {
            String s = FileUtil.readString(jsonFilePath, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONUtil.parseObj(s);

            SpringApplication app = new SpringApplication(SchemaApplication.class);
            Map<String, Object> map = new HashMap<>(80);
            for (String x : jsonObject.keySet()) {
                map.put(x, jsonObject.getStr(x));
                Console.log("加载配置 " + x + " ,配置数据值 : " + jsonObject.getStr(x));
            }
            app.setDefaultProperties(map);
            ApplicationContext context = app.run(args);
        } else {
            SpringApplication.run(SchemaApplication.class, args);
        }*/
    }
}
