package BilgenKaanRemzi.SpringBoot2.services;

import BilgenKaanRemzi.SpringBoot2.entites.Blogpost;
import BilgenKaanRemzi.SpringBoot2.exceptions.NotFoundException;
import BilgenKaanRemzi.SpringBoot2.repositories.BlogpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ServiziBlogpost {
    @Autowired
    private BlogpostRepository blogpostRepository;

    public Blogpost save(Blogpost body){

        return blogpostRepository.save(body);
    }
    public Page<Blogpost> GetBlogposts(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(orderBy));

        return blogpostRepository.findAll(pageable);
    }

    public Blogpost findById(int id)throws NotFoundException {
    return blogpostRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) throws  NotFoundException {
        Blogpost found = this.findById(id);
        blogpostRepository.delete(found);
    }

    public Blogpost findByIdAndUpdate(int id , Blogpost body){
        Blogpost found = this.findById(id);
                found.setId(id);
                found.setCategory(body.getCategory());
                found.setCover(body.getCover());
                found.setContenuto(body.getContenuto());
                found.setTitolo(body.getTitolo());
                found.setTempoDiLettura(body.getTempoDiLettura());
                return blogpostRepository.save(found);
    }

}
