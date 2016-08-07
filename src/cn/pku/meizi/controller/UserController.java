package cn.pku.meizi.controller;

import cn.pku.meizi.domain.User;
import cn.pku.meizi.enumer.Gender;
import cn.pku.meizi.enumer.Level;
import cn.pku.meizi.enumer.UserStatus;
import cn.pku.meizi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by sunbo on 16/6/24.
 */
@Controller
public class UserController {
    @Autowired
    private UserService myUserService;
    @RequestMapping("useredit/{id}")
    public String useredit(Model model, @PathVariable int id){
        User user=myUserService.getUserByID(id);
        model.addAttribute("level", Level.values());
        model.addAttribute("status", UserStatus.values());
        model.addAttribute("gender", Gender.values());
        model.addAttribute("user",user);
        return "useredit";
    }

    @RequestMapping("userdelete/{id}")
    public String userdelete(@PathVariable int id){
        myUserService.deleteById(id);
        return "userForm";
    }

    @RequestMapping(value = "userupdate")
    public String userupdate(Model model,@ModelAttribute User user){
        user.setmDate(new Date());
        myUserService.updateUser(user);
        model.addAttribute("user",user);
        return "userForm";
    }

    @RequestMapping(value = "searchUser")
    public String searchUser(Model model ,@RequestParam("nameTelEmail")String nameTelEmail ){
        User user=myUserService.getUserByNTE(nameTelEmail);
        String errMessage="";
        if(user==null) {
            errMessage="用户不存在";
            model.addAttribute("errMessage",errMessage);
        }
        model.addAttribute("user",user);
        return "userForm";
    }
    /*@RequestMapping("listallusers")
    public String listAllUsers(Model model){
        List<User> users=myUserService.listAllUsers();
        String nte="";
        model.addAttribute("users",users);
        model.addAttribute("nameTelEmail",nte);
        //return "allusers";
        return "userForm";
    }*/
}
