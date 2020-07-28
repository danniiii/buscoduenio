package mascotas.perdidas.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "mascota")
public class MascotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_desaparicion")
    private Date fechaDesaparicion;

    @Column(name = "id_tipo_mascota")
    private Integer idTipoMascota;

    @Column(name = "n_tipo_mascota")
    private String nombreTipoMascota;

    @Column(name = "id_color_1")
    private Integer color1;

    @Column(name = "n_color_1")
    private String nombreColor1;

    @Column(name = "id_color_2")
    private Integer color2;

    @Column(name = "n_color_2")
    private String nombreColor2;

    @Column(name = "tamanio")
    private String tamanioMascota;

    @Column(name = "id_raza")
    private Integer raza;

    @Column(name = "n_raza")
    private String nombreRaza;

    @Column(name = "id_partido")
    private Integer partido;

    @Column(name = "n_partido")
    private String nombrePartido;

    @Column(name = "id_localidad")
    private Integer localidad;

    @Column(name = "n_localidad")
    private String nombreLocalidad;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "telefono")
    private String tel;

    @Column(name = "facebook")
    private String face;

    @Column(name = "mail")
    private String email;

    @Column(name = "url_img")
    private String urlImagen;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @Column(name = "continua_perdido")
    private String continuaPerdido;

}
