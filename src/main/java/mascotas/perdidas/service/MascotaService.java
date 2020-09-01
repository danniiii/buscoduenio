package mascotas.perdidas.service;

import mascotas.perdidas.data.dto.MascotaDto;
import mascotas.perdidas.data.entity.MascotaEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public interface MascotaService {

    public boolean validarYConvertirMascotaDtoAMascotaEntity(MascotaEntity mascotaEntity, MascotaDto mascotaDto, MultipartFile file) throws ParseException, IOException;
}
