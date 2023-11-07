package BilgenKaanRemzi.SpringBoot2.controllers;

import BilgenKaanRemzi.SpringBoot2.entites.Autore;
import BilgenKaanRemzi.SpringBoot2.entites.Blogpost;
import BilgenKaanRemzi.SpringBoot2.services.ServiziAutore;
import BilgenKaanRemzi.SpringBoot2.services.ServiziBlogpost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class ControllerBlogpost {
    @Autowired
    private ServiziBlogpost serviziBlogpost;

    @GetMapping("")
    public List<Blogpost> getBlogposts(){
        return serviziBlogpost.GetBlogposts();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blogpost saveBlogpost(@RequestBody Blogpost body){
        return serviziBlogpost.save(body);
    }

    @GetMapping("/{id}")
    public Blogpost findById(@PathVariable int id){
        return serviziBlogpost.findById(id);
    }

    @PutMapping("/{id}")
    public Blogpost findbyIdAndUpdate(@PathVariable int id, @RequestBody Blogpost body){
        return serviziBlogpost.findByIdAndUpdate(id,body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        serviziBlogpost.findByIdAndDelete(id);
    }
}