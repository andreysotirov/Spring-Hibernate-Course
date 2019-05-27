package com.andrewsotirov.webapp.controller;

import com.andrewsotirov.webapp.entity.Customer;
import com.andrewsotirov.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model){

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "add-customers";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer){

        customerService.addCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int id, Model model){

        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);

        return "add-customers";
    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") int id){

        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("searchName") String searchName, Model model){
        List<Customer> searchCustomers = customerService.searchCustomers(searchName);
        model.addAttribute("customers", searchCustomers);

        return "list-customers";
    }
}
