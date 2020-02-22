package com.bill.springbootquick.controller;


import com.bill.springbootquick.dao.DepartmentDao;
import com.bill.springbootquick.dao.EmployeeDao;
import com.bill.springbootquick.entities.Department;
import com.bill.springbootquick.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String lists(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);


        return "emp/list";
    }


    @GetMapping("/toAddEmpPage")
    public String toAddEmpPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/addEmpPage";

    }


    @GetMapping("/toUpdatePage{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        System.out.println("要進行修改的Employee:" + employee);
        model.addAttribute("emp", employee);
        return "emp/updatePage";
    }

    @PostMapping("/addEmp")
    public String addEmp(Employee employee) {
        System.out.println("Before" + employee.toString());
        employeeDao.save(employee);
        System.out.println("After" + employee.toString());
        return "redirect:/emps";
    }

//    @RequestMapping(value = "/updateEmp" ,method = RequestMethod.PUT)
    @PutMapping("/updateEmp")
    public String updateEmp(Employee employee){
//        employee.setId(id);
        employeeDao.save(employee);
        return "redirect:/emps";
//        return "forward:emp/list";
    }


    @GetMapping("/toDeletePage")
    public String toDeletePage() {
        return "";
    }


    @GetMapping("/error")
    public String toErrorPage(){
        return "404";
    }
}
