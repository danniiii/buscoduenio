package mascotas.perdidas.data.repository;


import mascotas.perdidas.data.entity.LocalidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository <LocalidadEntity, Integer> {
}
