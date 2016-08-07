package cn.pku.meizi.service;

import cn.pku.meizi.enumer.Level;
import cn.pku.meizi.domain.User;

import java.util.List;

/**
 * Created by sunbo on 16/6/2.
 */
public interface UserService {
    List<User> listAllUsers();
    List<User> listUsersByLevel(Level level);
    User getUserByID(Integer id);
    User getUserByUsername(String username);
    User getUserByTel(String tel);
    User getUserByEmail(String email);
    User getUserByNTE(String nameTelEmail);
    boolean updateUser(User user);
    void deleteById(Integer id);
}
