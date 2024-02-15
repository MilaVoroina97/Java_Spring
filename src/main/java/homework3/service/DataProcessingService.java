package homework3.service;

import homework3.model.User;
import homework3.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Getter
@AllArgsConstructor
public class DataProcessingService {

    private UserRepository repository;

    /**
     * Метод вызова сортировки по возрасту
     * @return Список пользователей, отсортированный по возрасту
     */
    public List<User> sortUsersByAge() {
        return repository.sortedUserByAge();
    }

    /**
     * Метод вызова фильтрации по возрасту
     * @param age Возраст пользователя
     * @return Список пользователей, соответствующих условию
     */
    public List<User> filterUsersByAge(int age) {
        return repository.filterUserByAge(age);
    }

    /**
     * Метод вызова вычисления среднего возраста
     * @return Средний возраст пользователей
     */
    public double calculateAverageAge() {
        return repository.averageAge();
    }

    /**
     * Метод вызова добавления пользователя
     * @param user Новый пользователь
     */
    public void  addUserToList(User user)
    {
        repository.save(user);
    }
}
