package com.example.demo.controller;

import com.example.demo.model.Programmer;
import com.example.demo.repository.ProgrammerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProgrammerRepo programmerRepo;

    @RequestMapping("/home")
    public  String  home(){
        return "HomePage.html";
    }


    @RequestMapping("/addProgrammer")
    public ModelAndView addProgrammer(@ModelAttribute Programmer programmer){

        programmerRepo.save(programmer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProgrammerInfo.html");

        return  modelAndView;
    }


    @PostMapping("/findById")
    public String findById(@RequestParam int pId, Model model){

        Programmer p = programmerRepo.getOne(pId);

        model.addAttribute("programmer",p);
        return  "ProgrammerInfo.html";
    }



    @PostMapping("/deleteById")
    public String deleteById(@RequestParam int pId){
        programmerRepo.deleteById(pId);
        return  "redirect:/home";

    }
     @PostMapping("/updateProgrammer")
    public String updateProgrammer(@ModelAttribute Programmer programmer){

        Programmer db_programmer = programmerRepo.getOne(programmer.getpId());

        db_programmer.setpLanguage(programmer.getpLanguage());
        db_programmer.setpName(programmer.getpName());

        programmerRepo.save(db_programmer);

         return  "ProgrammerInfo.html";

    }

    @PostMapping("/findByLanguage")
    public String findByLanguage(@RequestParam String  lang,Model model){
        List<Programmer> programmerList = programmerRepo.findBypLanguage(lang);
        model.addAttribute("programmers",programmerList);
        return  "AllProgrammer.html";
    }

    @PostMapping("/findByName")
    public  String findByName(@RequestParam String name , Model model){

        List<Programmer> programmerList = programmerRepo.findByName(name);
        model.addAttribute("programmers",programmerList);
        return  "AllProgrammer.html";


    }





    @GetMapping("/allProgrammer")
    public String allProgrammer(Model model){


        List<Programmer> p = new ArrayList<>();
        p.add(new Programmer(101,"Abdullah","Java"));
        p.add(new Programmer(102,"Munna","Python"));
        p.add(new Programmer(103,"Rimon","C#"));
        p.add(new Programmer(104,"Fajle","Dart"));
        p.add(new Programmer(105,"Riyad","C++"));
        p.add(new Programmer(106,"Niloy","C"));

        model.addAttribute("programmers",p);

        return  "AllProgrammer.html";
    }
}
