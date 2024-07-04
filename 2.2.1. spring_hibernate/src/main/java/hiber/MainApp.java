package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Vito", "Paskane", "vito@mail.ru");
      Car car = new Car("Toyta", 345);
      user1.setCar(car);

      User user2 = new User("Pyx", "Vinni", "vin@mail.ru");
      Car car2 = new Car("Pego", 307);
      user2.setCar(car2);

      User user3 = new User("Tom", "Kryz", "Tom@mail.ru");
      Car car3 = new Car("Lada", 600);
      user3.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
         System.out.println("--------------");
      }

      System.out.println(userService.getUserByCar("Lada", 600));
      context.close();
   }
}
