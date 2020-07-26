package mascotas.perdidas.data.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MascotaDto {

    private String nombre;

    private String fechaDesaparicion;

    private Integer idTipoMascota;

    private String nombreTipoMascota;

    private Integer idColor1;

    private String nombreColor1;

    private Integer color2;

    private String nombreColor2;

    private String tamanioMascota;

    private Integer raza;

    private String nombreRaza;

    private Integer partido;

    private String nombrePartido;

    private Integer localidad;

    private String nombreLocalidad;

    private String comentario;

}
