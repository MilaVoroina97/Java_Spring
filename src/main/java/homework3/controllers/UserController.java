package homework3.controllers;

import homework3.model.User;
import homework3.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    private RegistrationService service;

    /**
     * Метод для вывода всехпользователей
     * @return Список всех пользователей
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().findAll();
    }

    /**
     * Ответ на запрос добавления пользователя при помощи переданного Json-файла
     * @param user Пользователь, переданный в виде Json-файла
     * @return Ответ успешного добавления пользователя
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().save(user);
        service.getNotificationService().notifyUser(user);
        return service.getNotificationService().sendNotification(user);
    }

    /**
     *
     * @param name Имя, переданное в запросе как параметр
     * @param age Возраст, переданный в запросе как параметр
     * @param email E-mail, переданный в запросе как параметр
     * @return Ответ успешного добавления пользователя
     */
    @PostMapping("/param")
    @ResponseBody
    public String userAddFromParam(
            @RequestParam("name") String name
            , @RequestParam("age") int age
            , @RequestParam("email") String email) {
        return service.processRegistration(name, age, email);
    }
}
