package com.example.mstapaz.service;

import com.example.mstapaz.client.BirBankClient;
import com.example.mstapaz.entity.MattEntity;
import com.example.mstapaz.exception.ErrorHandler;
import com.example.mstapaz.exception.ExceptionConstant;
import com.example.mstapaz.exception.NotFound;
import com.example.mstapaz.mapper.MattMapper;
import com.example.mstapaz.model.dto.MattDto;
import com.example.mstapaz.model.dto.PageAbleDto;
import com.example.mstapaz.model.request.MattRequest;
import com.example.mstapaz.model.request.MattSearchRequest;
import com.example.mstapaz.repository.MattRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class MattService {
    private final MattRepository mattRepository;
    private final BirBankClient birBankClient;


    
    public MattDto getIdMattress(Long id)  {
        var mattress = fetchExistsId(id);
        var mattressPrice = mattress.getPrice();

        var birbank = birBankClient.getAvailableAmount(id);
        BigDecimal birBankAmount = birbank.getAmount();


        if (mattressPrice.compareTo(birBankAmount) > 0) {
            throw new NotFound(ExceptionConstant.EXCEPTION_MESSAGE_PRICE);
//            throw new RuntimeException("Büdcəniz kifayət etmir. Lazım olan məbləğ: "
//                    + mattressPrice + ", mövcud məbləğ: " + birBankAmount);


        } else if (mattressPrice.compareTo(birBankAmount) <= 1) {
            log.info("ActionLog.started.success :{}",id);
            var balance=birBankAmount.subtract(mattressPrice);
            System.out.println("Mattress qiymeti balansinizdan cixildi: "+mattressPrice);
            birBankClient.updateAmountContr(id,mattressPrice);
            mattRepository.save(mattress);
            System.out.println("Cari balance:"+balance);
            return MattMapper.mattToDto(mattress);


        }

        return null;
    }


    public PageAbleDto getFilters(int page, int count, MattSearchRequest searchRequest) {
        var pageRequest = PageRequest.of(page, count, Sort.by(Sort.Direction.ASC, "id"));

        var pageAble = mattRepository.findAll(new MattSpecification(searchRequest), pageRequest);

        var mattress = pageAble.getContent().stream()
                .map(MattMapper::mattToDto)
                .toList();


        return PageAbleDto.builder()
                .mattress(mattress)
                .totalPages(pageAble.getTotalPages())
                .totalElements(pageAble.getTotalElements())
                .hasNExtPages(pageAble.hasNext())
                .build();


    }

    public List<MattDto> getAllMattress() {
        log.info("ActionLog.getAllMattress.start");
        var mattress = mattRepository.findAll()
                .stream()
                .map(MattMapper::mattToDto).toList();

        log.info("ActionLog.getAllMattress.success");

        return mattress;
    }


    public void saveMattress(MattRequest mattRequest) {
        mattRepository.save(MattMapper.mattToEntity(mattRequest));
    }

    public MattDto getMattress(Long id) {
        var mattress = fetchExistsId(id);
        return MattMapper.mattToDto(mattress);
    }


//    public void updateMattressPrice(String name, MattPriceRequest priceRequest) {
//        var mattress = fetchExistsName(name);
//        MattMapper.updateMapper(mattress, priceRequest);
//        mattRepository.save(mattress);
//
//    }


    private MattEntity fetchExistsId(Long id) {
        return mattRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This_mattress_NotFound"));


    }

    private MattEntity fetchExistsName(String name) {
        return mattRepository.findByName(name).orElseThrow(
                () -> new RuntimeException("THis mattress not Found"));
    }

}
