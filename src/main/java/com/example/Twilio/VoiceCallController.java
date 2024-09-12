package com.example.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/call")
public class VoiceCallController {




    @GetMapping("/check")
    public String verify(){
        return " It's Working Fine";
    }

    @PostMapping("/voiceCall")
    public ResponseEntity<String>ToMakeCalls(@RequestBody UserRequest userRequest) throws URISyntaxException {
        if(userRequest==null){
            throw new UnsatisfiedLinkError("User Details Can Not Be Null");
        }
        if(userRequest.toNumber==null||userRequest.fromNumber==null){
            ResponseEntity.badRequest().body(" can not be null");
        }
        String toNumber=userRequest.toNumber;
        String  fromNUmber= userRequest.fromNumber;
        String meaasge = userRequest.message;

        Call.creator((new PhoneNumber(fromNUmber)),new PhoneNumber(toNumber),
                new URI("http://demo.twilio.com/docs/voice.xml")).create();
        return ResponseEntity.ok("Call made Successfully !");

    }

}
