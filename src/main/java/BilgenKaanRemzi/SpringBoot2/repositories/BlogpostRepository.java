package BilgenKaanRemzi.SpringBoot2.repositories;


import BilgenKaanRemzi.SpringBoot2.entites.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogpostRepository extends JpaRepository<Blogpost, Integer> {
}
