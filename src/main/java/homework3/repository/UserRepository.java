package homework3.repository;

import homework3.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Setter
@Getter
@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;

    /**
     * Вывод всех пользователей
     * @return все пользователи
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, newUserRowMapper());
    }

    /**
     * Метод добавления нового пользователя
     * @param user новый пользователь
     */
    public void save(User user) {
        String sql = "INSERT INTO users (name,age, email) VALUES ( ?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

    /**
     * Сортировка пользователей по возрасту
     * @param age Возраст пользователя
     * @return Список пользователей, соответствующих условию
     */
    public List<User> filterUserByAge(int age){
        String sql = "SELECT * FROM users WHERE age>?";
        return jdbc.query(sql, newUserRowMapper(), age);
    }

    /**
     * Метод сортировки по возрасту
     * @return Список пользователей, отсортированный по возрасту
     */
    public List<User> sortedUserByAge(){
        String sql = "SELECT * FROM users ORDER BY age";



        return jdbc.query(sql, newUserRowMapper());
    }

    /**
     * Нахождение среднего возраста пользователей
     * @return Средний возраст пользователей
     */
    public Double averageAge(){
        String sql = "SELECT AVG(age) AS Average_Age FROM users";
        return jdbc.queryForObject(sql, Double.class);
    }

    /**
     * Метод создания словаря пользователей
     * @return Словарь пользователей
     */
    private RowMapper<User> newUserRowMapper(){
        return (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
    }
}
