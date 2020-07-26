package mascotas.perdidas.data.repository;

import mascotas.perdidas.data.entity.PartidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository <PartidoEntity, Integer> {
}
