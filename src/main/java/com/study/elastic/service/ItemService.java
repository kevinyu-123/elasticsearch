package com.study.elastic.service;

import com.study.elastic.dto.ResponseDTO;
import com.study.elastic.entity.ItemDocument;
import com.study.elastic.dto.ItemCreateDTO;
import com.study.elastic.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public void saveMockItem(ItemCreateDTO itemDTO) {
        ItemDocument itemDocument = ItemDocument.builder()
                .name(itemDTO.name())
                .description(itemDTO.description())
                .usage(itemDTO.usage())
                .build();

        try {
            itemRepository.save(itemDocument);
        } catch (RuntimeException e) {
            log.error("error : {}" , e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

    }

    public ResponseDTO findByType(String type, String value) {
        return switch (type) {
            case "name" -> getItemListByName(value);
            case "description" -> getItemListByDescription(value);
            case "usage" -> getItemListByUsage(Integer.parseInt(value));
            default -> ResponseDTO.builder().code(HttpStatus.NO_CONTENT.value()).msg("success").body(null).build();
        };

    }

    private ResponseDTO getItemListByName(String name) {
        List<ItemDocument> itemList = itemRepository.findAllByName(name);

        return ResponseDTO.builder()
                .code(HttpStatus.OK.value())
                .msg("success")
                .body(itemList)
                .build();
    }

    private ResponseDTO getItemListByDescription(String description) {
        List<ItemDocument> itemList = itemRepository.findAllByDescription(description);

        return ResponseDTO.builder()
                .code(HttpStatus.OK.value())
                .msg("success")
                .body(itemList)
                .build();
    }

    private ResponseDTO getItemListByUsage(int usage) {
        List<ItemDocument> itemList = itemRepository.findAllByUsage(usage);

        return ResponseDTO.builder()
                .code(HttpStatus.OK.value())
                .msg("success")
                .body(itemList)
                .build();
    }











}
