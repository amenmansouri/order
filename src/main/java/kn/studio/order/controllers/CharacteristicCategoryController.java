package kn.studio.order.controllers;

import kn.studio.order.dtos.CharacteristicCategoryDto;
import kn.studio.order.services.CharacteristicCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("characteristic_categories")
public class CharacteristicCategoryController {
    private final CharacteristicCategoryService  characteristicCategoryService;

    public CharacteristicCategoryController(CharacteristicCategoryService characteristicCategoryService) {
        this.characteristicCategoryService = characteristicCategoryService;
    }
    @PostMapping
    public CharacteristicCategoryDto saveOrUpdate(CharacteristicCategoryDto dto) {
        return characteristicCategoryService.saveOrUpdate(dto);
    }
    @GetMapping("{id}")
    public Optional<CharacteristicCategoryDto> findById(long id) {
        return characteristicCategoryService.findById(id);
    }
    @GetMapping
    public Page<CharacteristicCategoryDto> findAll(Pageable pageable) {
        return characteristicCategoryService.findAll(pageable);
    }
    @DeleteMapping("{id}")
    public void deleteById(long id) {
        characteristicCategoryService.deleteById(id);
    }
}
