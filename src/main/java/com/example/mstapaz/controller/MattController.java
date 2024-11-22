package com.example.mstapaz.controller;

import com.example.mstapaz.model.dto.MattDto;
import com.example.mstapaz.model.dto.PageAbleDto;
import com.example.mstapaz.model.request.MattPriceRequest;
import com.example.mstapaz.model.request.MattRequest;
import com.example.mstapaz.model.request.MattSearchRequest;
import com.example.mstapaz.service.MattService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/mattress")
@RequiredArgsConstructor
public class MattController {
    private final MattService mattService;



    @GetMapping("/{id}")
    public MattDto getAvailableMattressContr(@PathVariable Long id){
        return mattService.getIdMattress(id);
    }

    @PostMapping
    public void saveMattress(@RequestBody MattRequest request) {
        mattService.saveMattress(request);

    }
//
//    @GetMapping("/{id}")
//    public MattDto getById(@PathVariable Long id) {
//        return mattService.getMattress(id);
//    }


//    @PatchMapping("/{name}/price")
//    public void updatePrice(@PathVariable String name, @RequestParam MattPriceRequest price) {
//        mattService.updateMattressPrice(name, price);
//    }


    @GetMapping
    public PageAbleDto getFilterMattress(@RequestParam int page,
                                         @RequestParam int count,
                                         MattSearchRequest mattSearchRequest) {

        return mattService.getFilters(page, count, mattSearchRequest);
    }


    @GetMapping
    public List<MattDto>getMattresses(){
        return mattService.getAllMattress();
    }

}
