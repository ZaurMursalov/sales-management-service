package com.example.mstapaz.client;

import com.example.mstapaz.model.client.KartDto;
import lombok.Data;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "ms-birbank",url = "${client.ms-birbank.endpoint}")
public interface BirBankClient {
    String V1="/v1/karts";


    @GetMapping(V1)
     KartDto getAvailableAmount(@RequestParam Long id);

    @PutMapping(V1+"/{id}/amount")
    public void updateAmountContr(@RequestParam Long id, @RequestBody BigDecimal amount);
}
