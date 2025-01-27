package com.bazan.backend.realstate.presentation;

import com.bazan.backend.realstate.application.buyer.getBuyerByToken.GetBuyerByToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/buyers")
public class BuyerController {
    private final GetBuyerByToken getBuyerByToken;

    @GetMapping("/me")
    public ResponseEntity<?> getBuyer(
            @RequestHeader("Authorization") String token
    ) {
        var result = getBuyerByToken.getBuyer(token);
        if (result.isFailure()) {
            return ResponseEntity.badRequest().body(result.error());
        }

        return ResponseEntity.ok(result.getValue());
    }
}
