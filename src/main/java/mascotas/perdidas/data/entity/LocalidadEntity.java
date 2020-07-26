package mascotas.perdidas.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "localidades")
public class LocalidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidad", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "id_partido")
    private Integer idPartido;

    @Column(name = "nombre")
    private String nombre;

}
