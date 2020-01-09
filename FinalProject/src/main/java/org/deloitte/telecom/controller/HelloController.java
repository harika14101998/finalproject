package org.deloitte.telecom.controller;


import org.deloitte.telecom.exceptions.*;
import org.deloitte.telecom.dto.SessionData;
import org.deloitte.telecom.entities.Account;
import org.deloitte.telecom.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {

    private IAccountService service;

    public IAccountService getService() {
        return service;
    }

    @Autowired
    public void setService(IAccountService service) {
        this.service = service;
    }

    private SessionData sessionData;

    @Autowired
    public void setSessionData(SessionData data) {
        this.sessionData = data;

    }

    public SessionData getSessionData() {
        return sessionData;
    }


    @GetMapping("/userinput1")
    public ModelAndView userInput1() {
        System.out.println("inside userinput");
        return new ModelAndView("userinput1");
    }

    @GetMapping("/logincheck")
    public RedirectView loginCheck(@RequestParam("mobileNo") String mobileNo,
                                   @RequestParam("password") String password) {

        boolean correct = service.checkCredentialsByMobileNo(mobileNo, password);
        if (!correct) {
            return new RedirectView("/userinput1");
        }
        Account customer = service.findAccountByMobileNo(mobileNo);
        sessionData.setCustomer(customer);
        return new RedirectView("/home1");
    }

    @GetMapping("/home1")
    public Object home1() {
        if (sessionData.getCustomer() == null) {
            return new RedirectView("/userinput1");
        }
        Account accCustomer = sessionData.getCustomer();
        ModelAndView mv = new ModelAndView("home1", "customer", accCustomer);
        return mv;
    }
    
    @GetMapping("/processregister")
    public RedirectView processRegister(@RequestParam("mobileNo") String mobileNo,
    		 @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("accountType") String accountType,
                                 @RequestParam("balance") double balance) {
        Account customer = new Account(mobileNo, name, password, accountType, balance);
        customer=service.save(customer);
        sessionData.setCustomer(customer);
        return new RedirectView("/home1");
    }
    
    
    @GetMapping("/processrecharge")
    public RedirectView processrecharge(@RequestParam("amount") double amount) {
    	Account customer = sessionData.getCustomer();
    	service.rechargeAccount(customer, amount);
    	return new RedirectView("/home1");
    }
    
    @GetMapping("/recharge")
    public ModelAndView recharge(){
        return new ModelAndView("/recharge");
    }

    @GetMapping("/register1")
    public ModelAndView register1(){
        return new ModelAndView("/register1");
    }

    @GetMapping("/signout")
    public RedirectView signout(){
        sessionData.setCustomer(null);
        return new RedirectView("/userinput1");
    }
    
    @GetMapping("/error")
    public ModelAndView error(){
    	return new ModelAndView("error","message","Something went wrong");
    }
    
 
    
    @ExceptionHandler(MobileNoAlreadyExistsException.class)
    public ModelAndView handleIfMobileNoAlreadyExists(MobileNoAlreadyExistsException e) {
    	return new ModelAndView("register1","message","Mobile No Already exists");
    }
   
    
    @ExceptionHandler(value = Throwable.class)
    public ModelAndView catchAll(Throwable e) {
    	e.printStackTrace();
    	return new ModelAndView("error","message","Something went wrong");
    }



}
