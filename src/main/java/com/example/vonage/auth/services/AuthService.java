package com.example.vonage.auth.services;

import com.example.vonage.auth.utils.JWTUtil;
import com.vonage.client.VonageClient;
import com.vonage.client.verify.CheckResponse;
import com.vonage.client.verify.VerifyResponse;
import com.vonage.client.verify.VerifyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    @Autowired
    JWTUtil jwtUtil;

    VonageClient client = VonageClient.builder().apiKey("7ed*****").apiSecret("W3BuxE9VlaW*****").build();

    public String init(String identifier){
        System.out.println(identifier);
        VerifyResponse response = client.getVerifyClient().verify("919004******", "Vonage");


        if (response.getStatus() == VerifyStatus.OK) {
            return response.getRequestId();
        } else {
            return "ERROR! " + response.getStatus() + " " + response.getErrorText();
        }
    }

    public String verify(String identifier, String request_id, String otp){
        CheckResponse response = client.getVerifyClient().check(request_id, otp);

        if (response.getStatus() == VerifyStatus.OK) {
            return jwtUtil.generateToken(identifier);
        } else {
            return "Verification failed: " + response.getErrorText();
        }


    }
}
