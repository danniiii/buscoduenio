package mascotas.perdidas.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefugioDto {

    private String nombre;

    private String facebook;

    private String telefono;

    private Integer localidad;

    private String nombreLocalidad;

    private Integer partido;

    private String nombrePartido;

    private String mail;

    private String comentario;

    private String instagram;

}
