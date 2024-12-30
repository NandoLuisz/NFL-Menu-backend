package com.luis.foodsapp.email;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "*")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping
    public void sendEmail(@RequestBody Email email){
        emailService.sendEmail(email);
    }
}
