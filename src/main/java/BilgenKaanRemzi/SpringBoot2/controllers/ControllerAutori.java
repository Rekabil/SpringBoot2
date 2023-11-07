package BilgenKaanRemzi.SpringBoot2.controllers;

import BilgenKaanRemzi.SpringBoot2.entites.Autore;
import BilgenKaanRemzi.SpringBoot2.services.ServiziAutore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class ControllerAutori {
    @Autowired
    private ServiziAutore serviziAutore;

    @GetMapping("")
    public List<Autore> getAutore(){
        return serviziAutore.GetAutori();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody Autore body){
        return serviziAutore.save(body);
    }

    @GetMapping("/{id}")
    public Autore findById(@PathVariable int id){
        return serviziAutore.findById(id);
    }

    @PutMapping("/{id}")
    public Autore findbyIdAndUpdate(@PathVariable int id, @RequestBody Autore body){
        return serviziAutore.findByIdAndUpdate(id,body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        serviziAutore.findByIdAndDelete(id);
    }

}
