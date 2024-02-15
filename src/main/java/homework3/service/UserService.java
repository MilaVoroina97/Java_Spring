package homework3.service;

import homework3.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private NotificationService notificationService;

    /**
     * Метод создания нового пользователя
     * @param name Имя
     * @param age Возраст
     * @param email E-mail
     * @return Новый пользователь
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notificationService.notifyUser(user);

        return user;
    }
}
