package com.jy.controller;

import com.jy.model.Department;
import com.jy.model.Position;
import com.jy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class PositionController {
    @Autowired
    private AdminService adminService;

    //    *******************************招聘信息***************************************

    @RequestMapping("/position")//查询
    public String position(Model model)throws Exception{
        List<Position> positions=adminService.getAllPosition();
        List<Department> departments=adminService.getAllDepartment();
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);
        return "admin_view/position";
    }

    //*************新建************
    @RequestMapping("/position_save")
    public String position_save(Model model)throws Exception{
        model.addAttribute("position_s",true);
        List<Department> departments=adminService.getAllDepartment();
        model.addAttribute("departments",departments);
        return "admin_view/position";
    }

    @RequestMapping("/save_position")
    public String save_position(Position position,Model model)throws Exception{
        boolean res=adminService.savePosition(position);
        if(!res){
            model.addAttribute("msg","存入失败");
        }
        return position(model);
    }

    //*************更新************
    @RequestMapping("/position_update")
    public String position_update(int id,Model model,HttpSession session)throws Exception{
        Position position=adminService.getPositionById(id);
        List<Department> departments=adminService.getAllDepartment();
        model.addAttribute("departments",departments);
        model.addAttribute("position_u",position);
        return "admin_view/position";
    }

    @RequestMapping("/update_position")
    public String update_position(Position position,Model model,HttpSession session)throws Exception{
        boolean res=adminService.updatePosition(position);
        if(!res){
            model.addAttribute("msg","更新失败");
        }
        return position(model);
    }
    //*************删除************
    @RequestMapping("/position_del")
    public String  del_position(int id,Model model,HttpSession session)throws Exception{
        boolean res=adminService.delPosition(id);
        if(!res){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
        return position(model);
    }
}
