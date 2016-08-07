package cn.pku.meizi.controller;

import cn.pku.meizi.domain.*;
import cn.pku.meizi.service.ManagerService;
import cn.pku.meizi.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by sunbo on 16/5/25.
 */
@Controller
public class LoginController {
    private Manager curManager=new Manager();

    @Autowired
    private ManagerService myManagerService;
    @Autowired
    private MaterialService myMaterialService;

    @RequestMapping("login")
    public String login(Model model) {
        List<Role> roles=myManagerService.getAllRoles();
        model.addAttribute("manager",new Manager());
        model.addAttribute("roles",roles);
        return "login";
    }
    @RequestMapping("verify")
    public String verify(@ModelAttribute Manager manager,Model model,HttpSession session){
        String errMessage="";
        List<Manager> managerList=myManagerService.getManagerByName(manager.getName());
        Manager compareManager=null;
        if(managerList.size()==0) {
            errMessage="用户名不存在";
        }
        else {
            compareManager=managerList.get(0);
            if(!manager.getPassword().equals(compareManager.getPassword())) errMessage="用户名或密码错误";
            if(manager.getRole().getId()!=compareManager.getRole().getId()) errMessage="用户类型错误";
        }
        model.addAttribute("errMessage",errMessage);
        if(errMessage.equals("")) {
            curManager=compareManager;
            session.setAttribute("curManager", curManager);
            return "welcome";
        }
        else {
            List<Role> roles=myManagerService.getAllRoles();
            model.addAttribute("manager",new Manager());
            model.addAttribute("roles",roles);
            return "login";
        }
    }
    @RequestMapping("usermanager")
    public String userManager(){
        return "userForm";
    }

    @RequestMapping("ordermanager")
    public String  orderManager() {
        return "orderSearch";
    }

    @RequestMapping("media")
    public String chooseMedia(){
        return "chooseMediaStatus";
    }

    @RequestMapping("authorized_keys")
    public String authorized_keys(HttpServletRequest request){
        String value= request.getParameter("value");
        String fileName="/Users/sunbo/Desktop/test.txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(value+"\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
    @RequestMapping("gowelcome")
    public String goWelcome(){
        return "welcome";
    }

}
