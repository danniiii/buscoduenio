package mascotas.perdidas.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "razas")
public class RazaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_raza", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "id_tipo_mascota")
    private Integer idTipoMascota;

    @Column(name = "nombre")
    private String nombre;
}
