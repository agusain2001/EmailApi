package com.email.EmailApi.Controller;


import com.email.EmailApi.Service.EmailService;
import com.email.EmailApi.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private EmailService emailService;
    @RequestMapping("/welcome")
    public String Welcome(){
        return "hello this is my email";
    }

    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){

        System.out.println(request);
      boolean b=  this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo() );
      if(b){
      return ResponseEntity.ok("Successfully email is send");}
      else {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
    }

}
