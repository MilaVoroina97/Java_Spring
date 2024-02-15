package homework3.service;

import homework3.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
@AllArgsConstructor
public class RegistrationService {

    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;


    /**
     * Метод регистрации пользователя
     * @param name Имя
     * @param age Возраст
     * @param email E-mail
     * @return в случае успешного добавления пользователя возвращается строка
     */
    public String processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        return notificationService.sendNotification(newUser);
    }
}
