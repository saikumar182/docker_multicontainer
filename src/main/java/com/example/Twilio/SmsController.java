package com.example.Twilio;
import com.twilio.type.PhoneNumber;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.twilio.rest.api.v2010.account.Message;
@RestController
public class SmsController {


    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody UserRequest userRequest) {

        if ((userRequest==null)||userRequest.message==null||userRequest.toNumber==null||userRequest.fromNumber==null){
           return ResponseEntity.badRequest().body(" Invalid information");
        }
        String fromNumber = userRequest.fromNumber;
        String toNumber =userRequest.toNumber;
        String message  =userRequest.message;

       Message.creator (new PhoneNumber(toNumber), new PhoneNumber(fromNumber),
                message).create();
     return   ResponseEntity.ok().body(" Message Sent Successfully");
    }

    @GetMapping
    public String message(){
        return  "hello this is Twilio account";
    }

}
