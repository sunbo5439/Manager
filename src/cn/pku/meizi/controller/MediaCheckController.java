package cn.pku.meizi.controller;
import cn.pku.meizi.domain.Manager;
import cn.pku.meizi.domain.Material;
import cn.pku.meizi.domain.MaterialCheckInfoItem;
import cn.pku.meizi.domain.PageModel;
import cn.pku.meizi.enumer.VideoCheckStatus;
import cn.pku.meizi.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by sunbo on 16/7/5.
 */
@Controller
public class MediaCheckController {

    @Autowired
    MaterialService materialService;


    @RequestMapping("mediaCheck/{id}")
    public String mediaCheck(Model model, @PathVariable("id") Integer id){
        Material material = materialService.getByID(id);
        model.addAttribute("media", material);
        return "mediaCheck";
    }

    @RequestMapping("checkHistory/{id}")
    public String mediaHistroy(@PathVariable("id") Integer id, Model model){
        Material curMaterial = materialService.getByID(id);
        List<MaterialCheckInfoItem> historyInfo= curMaterial.getCheckInfo();
        model.addAttribute("historyInfo",historyInfo);
        model.addAttribute("curMedia", curMaterial);
        return "checkHistory";
    }

    @RequestMapping("mediaCheck/check/{id}")
    public String checkMedia(@PathVariable("id") Integer id,HttpServletRequest arg0,Model model,HttpSession session){
        Integer resultStatus=Integer.parseInt(arg0.getParameter("resultStatus"));
        String remark="";
        try {
            remark =new String((arg0.getParameter("remark")).getBytes("ISO8859_1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Manager curManager=(Manager) session.getAttribute("curManager");
        materialService.setStatus(id,VideoCheckStatus.getFromInt(resultStatus),curManager,remark);
        //System.out.println(remark);
        return "chooseMediaStatus";
    }

    @RequestMapping("listMedia0")
    public String listMedia0(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page")); //当前页
        int rows = Integer.parseInt(request.getParameter("rows"));//每页显示记录数
        PageModel pageModel = materialService.getPageModel(page-1,rows,0);
        request.setAttribute("pageModel", pageModel);
        return "mediaList0";
    }
    @RequestMapping("listMedia1")
    public String listMedia1(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page")); //当前页
        int rows = Integer.parseInt(request.getParameter("rows"));//每页显示记录数
        PageModel pageModel = materialService.getPageModel(page-1,rows,1);
        request.setAttribute("pageModel", pageModel);
        return "mediaList1";
    }
    @RequestMapping("listMedia2")
    public String listMedia2(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page")); //当前页
        int rows = Integer.parseInt(request.getParameter("rows"));//每页显示记录数
        PageModel pageModel = materialService.getPageModel(page-1,rows,2);
        request.setAttribute("pageModel", pageModel);
        return "mediaList2";
    }

    @RequestMapping("gowelcome")
    public String goWelcome(){
        return "welcome";
    }


}
