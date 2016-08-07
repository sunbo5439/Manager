package cn.pku.meizi.service;

import cn.pku.meizi.domain.Manager;
import cn.pku.meizi.domain.Role;

import java.util.List;

/**
 * Created by sunbo on 16/5/26.
 */
public interface ManagerService {
    List<Role> getAllRoles();
    List<Manager> getAllManager();
    List<Manager> getManagerByName(String name);
}
