package homework3.controllers;

import homework3.model.User;
import homework3.service.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class TaskController {

    private DataProcessingService service;

    /**
     * Вывод всех запросов
     * @return список запросов
     */
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    /**
     * Ответ на запрос сортировки по возрасту
     * @return Список пользователей, возраст которых больше указанного в запросе
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge();
    }

    /**
     * Ответ на запрос фильтрации по возрасту
     * @param age Возраст пользователя
     * @return Список пользователей старше заданного возраста
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        return service.filterUsersByAge(age);
    }

    /**
     * Ответ на запрос вычисления среднего возраста
     * @return Средний возраст пользователей
     */
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge();
    }
}
