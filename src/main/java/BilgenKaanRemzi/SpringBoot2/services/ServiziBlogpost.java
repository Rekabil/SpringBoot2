package BilgenKaanRemzi.SpringBoot2.services;

import BilgenKaanRemzi.SpringBoot2.entites.Autore;
import BilgenKaanRemzi.SpringBoot2.entites.Blogpost;
import BilgenKaanRemzi.SpringBoot2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ServiziBlogpost {
    private List<Blogpost> blogposts = new ArrayList<>();

    public Blogpost save(Blogpost body){
        Random random = new Random();
        body.setId(random.nextInt(1,100000));

        this.blogposts.add(body);
        return body;
    }
    public List<Blogpost> GetBlogposts() {
        return this.blogposts;
    }

    public Blogpost findById(int id) {
        Blogpost blogpost = null;
        for (Blogpost blogpost1: this.blogposts){
            if (blogpost1.getId() == id) {
                blogpost  = blogpost1;
            }
        }
        if (blogpost  == null) {
            throw new NotFoundException(id);
        } else return blogpost ;
    }

    public void findByIdAndDelete(int id) {
        this.blogposts.removeIf(current -> current.getId() == id);
    }

    public Blogpost findByIdAndUpdate(int id , Blogpost body){
        Blogpost found = null;

        for (Blogpost blogpost : this.blogposts){
            if (blogpost .getId() == id){
                found = blogpost ;
                found.setId(id);
                found.setCategory(body.getCategory());
                found.setCover(body.getCover());
                found.setContenuto(body.getContenuto());
                found.setTitolo(body.getTitolo());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if (found==null){
            throw new NotFoundException(id);
        } else return found;
    }

}
