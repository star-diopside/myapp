package jp.myapp.webservice.client.main;

import jp.myapp.webservice.bean.User;
import jp.myapp.webservice.service.UserService;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Launcher {

    private Launcher() {
    }

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {

            UserService service = context.getBean("userService", UserService.class);

            for (User user : service.getUserList()) {
                System.out.println(ToStringBuilder.reflectionToString(user));
            }

            User user = service.getUser("test");
            System.out.println(ToStringBuilder.reflectionToString(user));

            user.setUserId(RandomStringUtils.randomAlphanumeric(10));
            user = service.createUser(user);

            user = service.updateUser(user);

            service.deleteUser(user.getUserId(), user.getVersion());
        }
    }
}
