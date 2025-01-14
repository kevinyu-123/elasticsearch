package com.study.elastic.controller;

import com.study.elastic.dto.ItemCreateDTO;
import com.study.elastic.dto.ResponseDTO;
import com.study.elastic.entity.ItemDocument;
import com.study.elastic.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDTO> saveMockData(@RequestBody ItemCreateDTO itemDto) {
        log.info("called");

        itemService.saveMockItem(itemDto);

        ResponseDTO responseDTO = ResponseDTO.builder()
                .code(HttpStatus.CREATED.value())
                .msg("created")
                .body(null)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("")
    public ResponseEntity<ResponseDTO> getItemListByType(@RequestParam String type, @RequestParam String value) {
        ResponseDTO responseDTO = itemService.findByType(type, value);

        return ResponseEntity.status(HttpStatus.valueOf(responseDTO.getCode())).body(responseDTO);
    }






}
