package BilgenKaanRemzi.SpringBoot2.repositories;

import BilgenKaanRemzi.SpringBoot2.entites.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {
}
