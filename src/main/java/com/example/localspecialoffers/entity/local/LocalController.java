package com.example.localspecialoffers.entity.local;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local")
@AllArgsConstructor
public class LocalController {

    private final LocalService localService;

    @GetMapping
    public List<Local> getLocals(){
        return localService.findAll();
    }

    @PostMapping
    public ResponseEntity<Local> saveLocal(@RequestBody Local local){
        Local savedLocal = localService.save(local);
        return new ResponseEntity<>(savedLocal, HttpStatus.OK);
    }

}
