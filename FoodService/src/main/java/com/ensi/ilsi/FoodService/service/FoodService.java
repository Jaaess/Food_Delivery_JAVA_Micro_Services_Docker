package com.ensi.ilsi.FoodService.service;

import com.ensi.ilsi.foodDelivery.commons.dto.FoodDto;
import com.ensi.ilsi.FoodService.domain.Food;
import com.ensi.ilsi.FoodService.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class FoodService {
    private FoodRepository foodRepository;
   

    public List<FoodDto> findAll() {
        //log.debug("Request to get all Foods");
        return this.foodRepository.findAll()
                .stream()
                .map(FoodService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FoodDto findById(Long id) {
        //log.debug("Request to get Food : {}", id);
        return this.foodRepository.findById(id).map(FoodService::mapToDto).orElse(null);
    }

    public FoodDto create(FoodDto FoodDto) {
        //log.debug("Request to create Food : {}", FoodDto);

        return mapToDto(this.foodRepository.save(
                new Food(
                		FoodDto.getId(),
                        FoodDto.getName(),
                        FoodDto.getDescription(),
                        FoodDto.getPrice()
                )));
    }

    public void delete(Long id) {
        //log.debug("Request to delete Food : {}", id);
        this.foodRepository.deleteById(id);
    }

    public static FoodDto mapToDto(Food Food) {
        if (Food != null) {
            return new FoodDto(
            );
        }
        return null;
    }
}
