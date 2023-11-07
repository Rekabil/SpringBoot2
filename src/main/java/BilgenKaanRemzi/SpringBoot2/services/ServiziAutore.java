package BilgenKaanRemzi.SpringBoot2.services;

import BilgenKaanRemzi.SpringBoot2.entites.Autore;
import BilgenKaanRemzi.SpringBoot2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class ServiziAutore {
    private List<Autore> autori = new ArrayList<>();

    public Autore save(Autore body){
        Random random = new Random();
        body.setId(random.nextInt(1,100000));
        body.setAvatar("https://ui-avatars.com/api/?name="+ body.getNome() + "+" + body.getCognome());
        this.autori.add(body);
        return body;
    }
    public List<Autore> GetAutori() {
        return this.autori;
    }

    public Autore findById(int id) {
        Autore autore = null;
        for (Autore autore1: this.autori){
            if (autore1.getId() == id) {
                autore = autore1;
            }
        }
        if (autore == null) {
            throw new NotFoundException(id);
        } else return autore;
    }

    public void findByIdAndDelete(int id) {
        this.autori.removeIf(current -> current.getId() == id);
    }

    public Autore findByIdAndUpdate(int id , Autore body){
        Autore found = null;

        for (Autore autore: this.autori){
            if (autore.getId() == id){
                found = autore;
                found.setId(id);
                found.setNome(body.getNome());
                found.setEmail(body.getEmail());
                found.setDataDiNascita(body.getDataDiNascita());
                found.setAvatar(body.getAvatar());
            }
        }
        if (found==null){
            throw new NotFoundException(id);
        } else return found;
    }



}
