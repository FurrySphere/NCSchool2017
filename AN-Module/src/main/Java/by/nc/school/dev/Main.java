package by.nc.school.dev;
import by.nc.school.dev.model.user.Role;
import by.nc.school.dev.model.user.User;
import by.nc.school.dev.service.user.UserServiceFactory;
import by.nc.school.dev.service.user.UserService;


import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> list;
    public static void main(String[] args) {
        ObjectOutputStream ois;
        UserService userService;
        Scanner in = new Scanner(System.in);
        list = new ArrayList<User>();
        userService = UserServiceFactory.getInstance();

        while (true)
        {
            int key = in.nextInt();
            if(key == 0){
                break;
            }
            switch(key)
            {
                case 1: {
                    if(userService.login(in.next(), in.next()))
                    {
                        System.out.println("You log in succsesfull");
                    }
                    else
                    {
                        System.out.println("Invalid username or password");
                    }
                    break;
                }
                case 2: {
                    userService = UserServiceFactory.getInstance();
                    userService.addUser(new User(in.next(), in.next()));
                    break;
                }
                case 3: {

                }
            }
        }
    }
}
