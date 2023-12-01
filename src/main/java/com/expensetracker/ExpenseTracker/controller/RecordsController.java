package com.expensetracker.ExpenseTracker.controller;

import com.expensetracker.ExpenseTracker.Entities.Records;
import com.expensetracker.ExpenseTracker.Entities.Registration;
import com.expensetracker.ExpenseTracker.repositories.RecordRepository;
import com.expensetracker.ExpenseTracker.service.LoginService;
import com.expensetracker.ExpenseTracker.service.RecordService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecordsController {

    private ModelAndView modelAndView;
    private List<Records> expenseList = new ArrayList<>();

    @Autowired
    private RecordService recordService;

    @Autowired
    private LoginService loginService;

    private RecordRepository recordRepository;


    @PostMapping("/addRecord")
    public ModelAndView addRecord(HttpServletRequest httpServletRequest){


        String name=  httpServletRequest.getParameter("aname");
        String mode = httpServletRequest.getParameter("amode");
       String paidTo = httpServletRequest.getParameter("apaidTo");
        String paidAmount = httpServletRequest.getParameter("apaidAmount");
        String description = httpServletRequest.getParameter("adescription");

        System.out.println(name);
        System.out.println(mode);
        System.out.println(paidTo);
        System.out.println(paidAmount);
        System.out.println(description);



        recordService.addRecord(name,mode,paidTo,paidAmount,description);
        List<Records> list = recordService.getAllexpenses();
        System.out.println(list);

        return new ModelAndView("records.html","records",list);

    }


    @RequestMapping(value = "/login")
    public ModelAndView login(){

        return new ModelAndView("index.html");
    }

    // Delete Method

    @RequestMapping(value = "/deleteRecord/{id}")
    public ModelAndView deleteRecord(@PathVariable Long id){

        recordService.deleteRecord(id);
        System.out.println("Signing into Records Table");

        List<Records> list = loginService.getAllRecords();
        System.out.println(list);

        return new ModelAndView("records.html","records",list);
    }

    @RequestMapping(value = "/editRecord/{id}")
    public ModelAndView updateRecord(@PathVariable Long id,HttpServletRequest httpServletRequest){

        String name=  httpServletRequest.getParameter("ename");
        String mode = httpServletRequest.getParameter("emode");
        String paidTo = httpServletRequest.getParameter("epaidTo");
        String paidAmount = httpServletRequest.getParameter("epaidAmount");
        String description = httpServletRequest.getParameter("edescription");

        System.out.println(name);
        System.out.println(mode);
        System.out.println(paidTo);
        System.out.println(paidAmount);
        System.out.println(description);

        recordService.addRecord(name,mode,paidTo,paidAmount,description);
        List<Records> list = loginService.getAllRecords();
        System.out.println(list);
        return new ModelAndView("records.html","records",list);
    }

    @GetMapping(value = "/getAllrecords")
    public List<Records> getAllRecords(){

        return recordRepository.findAll();
    }



}

