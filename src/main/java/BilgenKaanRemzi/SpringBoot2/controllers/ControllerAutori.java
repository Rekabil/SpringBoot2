package BilgenKaanRemzi.SpringBoot2.controllers;

import BilgenKaanRemzi.SpringBoot2.entites.Autore;
import BilgenKaanRemzi.SpringBoot2.services.ServiziAutore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class ControllerAutori {
    @Autowired
    private ServiziAutore serviziAutore;

    @GetMapping("")
    public Page<Autore> getAutore(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue = "id") String orderBy){
        return serviziAutore.GetAutori(page, size, orderBy);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody   @Validated Autore body){
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

    @PostMapping("/upload")
    public String upload(@RequestParam("avatar")MultipartFile body) throws IOException{
        System.out.println(body.getSize());
        System.out.println(body.getContentType());
        return serviziAutore.uploadPicture(body);
    }
}
