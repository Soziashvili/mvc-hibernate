import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.AppConfig;
import web.config.WebConfig;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;
import web.service.UserService;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        context.register(WebConfig.class);
//        UserService userService = context.getBean(UserService.class);
//
//        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
//        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
//        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
//        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
//
//        userService.addUser(user1);
//        userService.addUser(user2);
//        userService.addUser(user3);
//        userService.addUser(user4);
//
//        System.out.println(userService.findUserById(3));
//        System.out.println(userService.findUserById(1));
//        System.out.println(userService.findUserById(4));
//        System.out.println(userService.findUserById(2));
//
//        userService.deleteUser(2);
//
//        User user5 = new User("test", "test1", "test@mail.ru");
//
//        userService.updateUser(4, user5);
//
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("--------------------------------------------------------");
//            System.out.println("Id = "+user.getId());
//            System.out.println("First Name = "+user.getFirstName());
//            System.out.println("Last Name = "+user.getLastName());
//            System.out.println("Email = "+user.getEmail());
//            System.out.println("--------------------------------------------------------");
//        }

    }
}
