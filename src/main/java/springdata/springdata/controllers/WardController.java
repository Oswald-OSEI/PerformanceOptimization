package springdata.springdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springdata.springdata.dtos.WardDto;
import springdata.springdata.repositories.WardRepository;
import springdata.springdata.services.WardService;

@RestController
@RequestMapping("/ward")
public class WardController {
    @Autowired
    private WardService wardService;

    @PostMapping("/addward")
    public ResponseEntity<WardDto> addWard(@RequestBody WardDto wardDto) {
        WardDto wardDtoSaved = wardService.addWard(wardDto);
        return ResponseEntity.ok().body(wardDtoSaved);
    }
}
