package mascotas.perdidas.data.repository;

import mascotas.perdidas.data.entity.MascotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MascotaRepository extends JpaRepository <MascotaEntity, Integer> {
    public List<MascotaEntity> getData(Map<String, Integer> conditions);

}
