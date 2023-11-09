package BilgenKaanRemzi.SpringBoot2.payload.autore;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record NewAutoreDTO(

        @NotEmpty(message = "Name is obbligatory")
        @Size(min = 3, max = 30,message = "Must Contain from 3 to 30 caracters")
        String nome,
        @NotEmpty(message = "Surname is obbligatory")
        String cognome,
        @NotEmpty(message = "Email is obbligaroty")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" , message = "Email not valid")
        String email
) {
}
