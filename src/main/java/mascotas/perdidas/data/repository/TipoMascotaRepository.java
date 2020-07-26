package mascotas.perdidas.data.repository;

import mascotas.perdidas.data.entity.TipoMascotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMascotaRepository extends JpaRepository<TipoMascotaEntity, Integer> {
}
