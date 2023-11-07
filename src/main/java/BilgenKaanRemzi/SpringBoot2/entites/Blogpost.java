package BilgenKaanRemzi.SpringBoot2.entites;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Blogpost {
    private int id;
    private String category;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

}
