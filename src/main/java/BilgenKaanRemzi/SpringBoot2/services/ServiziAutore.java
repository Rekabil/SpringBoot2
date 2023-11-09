package BilgenKaanRemzi.SpringBoot2.services;

import BilgenKaanRemzi.SpringBoot2.entites.Autore;
import BilgenKaanRemzi.SpringBoot2.exceptions.NotFoundException;
import BilgenKaanRemzi.SpringBoot2.repositories.AutoreRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ServiziAutore {

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private Cloudinary cloudinary;

    public Autore save(Autore body){
        body.setAvatar("https://ui-avatars.com/api/?name="+ body.getNome() + "+" + body.getCognome());

        return autoreRepository.save(body);
    }
    public Page<Autore> GetAutori(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(orderBy));
        return autoreRepository.findAll(pageable);
    }

    public Autore findById(int id) throws NotFoundException {
        return autoreRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) throws  NotFoundException {
        Autore found = this.findById(id);
        autoreRepository.delete(found);
    }

    public Autore findByIdAndUpdate(int id , Autore body){
        Autore found = this.findById(id);
                found.setId(id);
                found.setNome(body.getNome());
                found.setEmail(body.getEmail());
                found.setDataDiNascita(body.getDataDiNascita());
                found.setAvatar(body.getAvatar());
          return autoreRepository.save(found);
    }

public String uploadPicture(MultipartFile file) throws IOException{
        return (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
}

}
