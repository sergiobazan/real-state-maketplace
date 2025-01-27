package com.bazan.backend.realstate.presentation;

import com.bazan.backend.realstate.application.sellers.getByToken.GetSellerByToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sellers")
public class SellerController {
    private final GetSellerByToken sellerByToken;

    @GetMapping("/me")
    public ResponseEntity<?> getSellerByToken(
            @RequestHeader("Authorization") String token
    ) {
        var result = sellerByToken.getByToken(token);

        if (result.isFailure())
            return ResponseEntity.badRequest().body(result.error());

        return ResponseEntity.ok(result.getValue());
    }
}
