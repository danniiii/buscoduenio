package mascotas.perdidas.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "refugios")
public class RefugioEntity {

    @Id
    @Column(name = "id_refugio", updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "id_partido")
    private Integer partido;

    @Column(name = "n_partido")
    private String nombrePartido;

    @Column(name = "id_localidad")
    private Integer localidad;

    @Column(name = "n_localidad")
    private String nombreLocalidad;

    @Column(name = "mail")
    private String mail;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "instagram")
    private String instagram;
}
