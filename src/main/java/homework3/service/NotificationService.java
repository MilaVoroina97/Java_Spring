package homework3.service;

import homework3.model.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    /**
     * Метод вывода в консоль успешного добавления пользователя
     * @param user Новый пользователь
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Метод составления сообщения в случае успешного добавления пользователя
     * @param user Новый пользователь
     * @return Строка успешного добавления пользователя
     */
    public String sendNotification(User user) {
        return "A new user has been created: " + user.getName();
    }
}
