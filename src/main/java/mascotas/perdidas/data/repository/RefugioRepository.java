package mascotas.perdidas.data.repository;

import mascotas.perdidas.data.entity.RefugioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefugioRepository extends JpaRepository<RefugioEntity, Integer> {
}
