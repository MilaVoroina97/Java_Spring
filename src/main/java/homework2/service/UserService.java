package homework2.service;

import homework2.model.User;
import homework2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    //add new method
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public User findUserById(int id)  {
        return userRepository.findById(id);
    }

    public void updateUser(User user){
        userRepository.update(user, user.getId());
    }
}
