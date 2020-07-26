package mascotas.perdidas.data.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class SugerenciaDto {

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String mail;

    @NotNull
    private String sugerencia;
}
