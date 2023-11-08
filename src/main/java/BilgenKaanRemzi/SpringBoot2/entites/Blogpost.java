package BilgenKaanRemzi.SpringBoot2.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "blogposts")
public class Blogpost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Autore autore;
}
