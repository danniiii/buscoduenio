package mascotas.perdidas.data.repository;

import mascotas.perdidas.data.entity.RazaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaRepository extends JpaRepository <RazaEntity, Integer> {
}
