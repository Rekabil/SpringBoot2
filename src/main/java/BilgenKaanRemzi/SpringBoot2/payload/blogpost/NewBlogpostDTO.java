package BilgenKaanRemzi.SpringBoot2.payload.blogpost;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewBlogpostDTO(
        @NotEmpty(message = "Must have a Title")
   String title,

   @NotEmpty(message = "Must have Content")
   String contenuto,
   @NotEmpty(message = "Must have a category")
   String category
) { }
