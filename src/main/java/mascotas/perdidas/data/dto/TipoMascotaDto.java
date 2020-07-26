package mascotas.perdidas.data.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class TipoMascotaDto {

    @NotNull
    private Integer idTipoMascota;

    @NotNull
    private String tipoMascota;
}
