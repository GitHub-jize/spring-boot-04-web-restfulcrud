package com.ji.springboot.controller;

import com.ji.springboot.dao.DepartmentDao;
import com.ji.springboot.dao.EmployeeDao;

import com.ji.springboot.entities.Department;
import com.ji.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmpAll(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emp", all);
        return "list";
    }


    @GetMapping("/emp")
    public String toAddEmp(Model model) {
        Collection<Department> department = departmentDao.getDepartments();
        model.addAttribute("dept", department);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toModEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> department = departmentDao.getDepartments();
        model.addAttribute("dept", department);
        return "/emp/add";
    }

    @PutMapping("/emp")
    public String ModEmp(Employee employee) {
        //System.out.println(employee);
        employeeDao.save(employee);
        //System.out.println(employee);
        return "redirect:/emps";
    }

    @GetMapping("/empdel/{id}")
    public String del(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
