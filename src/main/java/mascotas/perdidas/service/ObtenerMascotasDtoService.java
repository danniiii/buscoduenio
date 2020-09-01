package mascotas.perdidas.service;


import mascotas.perdidas.data.dto.MascotaDto;
import mascotas.perdidas.data.entity.MascotaEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerMascotasDtoService {

    public List<MascotaDto> getMascotas(List<MascotaEntity> mascotaEntity){

        List<MascotaDto> mascotaDtoSalida = new ArrayList<MascotaDto>();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        for (MascotaEntity entity : mascotaEntity) {

            if (entity.getContinuaPerdido().equals("S")) {

                MascotaDto newMascotaDto = new MascotaDto();
                newMascotaDto.setNombre(entity.getNombre());
                newMascotaDto.setFechaDesaparicion(formatoDelTexto.format(entity.getFechaDesaparicion()));
                newMascotaDto.setNombreColor1(entity.getNombreColor1());
                newMascotaDto.setNombreColor2(entity.getNombreColor2());
                newMascotaDto.setNombreRaza(entity.getNombreRaza());
                newMascotaDto.setNombrePartido(entity.getNombrePartido());
                newMascotaDto.setNombreLocalidad(entity.getNombreLocalidad());
                newMascotaDto.setNombreTipoMascota(entity.getNombreTipoMascota());
                newMascotaDto.setTamanioMascota(entity.getTamanioMascota());
                newMascotaDto.setComentario(entity.getComentario());
                newMascotaDto.setTelefono(entity.getTel());
                newMascotaDto.setMail(entity.getEmail());
                newMascotaDto.setFacebook(entity.getFace());
                newMascotaDto.setUrlImg(entity.getUrlImagen());
                newMascotaDto.setId(entity.getId());
                newMascotaDto.setContinuaPerdido(entity.getContinuaPerdido());
                newMascotaDto.setGenero(entity.getGenero());

                mascotaDtoSalida.add(newMascotaDto);
            }
        }
        return mascotaDtoSalida;
    }
}
