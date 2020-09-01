package mascotas.perdidas.service.serviceImpl;

import mascotas.perdidas.data.dto.MascotaDto;
import mascotas.perdidas.data.entity.*;
import mascotas.perdidas.data.repository.*;
import mascotas.perdidas.service.FirebaseInitializer;
import mascotas.perdidas.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service("subirMascotaService")
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    FirebaseInitializer firebaseInitializer;

    private MascotaRepository mascotaRepository;
    private PartidoRepository partidoRepository;
    private LocalidadRepository localidadRepository;
    private ColorRepository colorRepository;
    private TipoMascotaRepository tipoMascotaRepository;
    private RazaRepository razaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository, PartidoRepository partidoRepository,
                             LocalidadRepository localidadRepository, ColorRepository colorRepository,
                             TipoMascotaRepository tipoMascotaRepository, RazaRepository razaRepository){

        this.mascotaRepository = mascotaRepository;
        this.partidoRepository = partidoRepository;
        this.localidadRepository = localidadRepository;
        this.colorRepository = colorRepository;
        this.tipoMascotaRepository = tipoMascotaRepository;
        this.razaRepository = razaRepository;
    }


    @Override
    public boolean validarYConvertirMascotaDtoAMascotaEntity(MascotaEntity mascotaEntity,
                                                             MascotaDto mascotaDto,
                                                             MultipartFile file) throws IOException, ParseException {
        String fileName = mascotaDto.getNombre();


        if (mascotaDto.getNombre()!=null)
            mascotaEntity.setNombre(mascotaDto.getNombre());


        if (mascotaDto.getFechaDesaparicion()!=null){
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            mascotaEntity.setFechaDesaparicion(formatoDelTexto.parse(mascotaDto.getFechaDesaparicion()));
            fileName += LocalDateTime.now().getYear() + LocalDateTime.now().getMonth().toString() + LocalDateTime.now().getDayOfMonth();
        }

        if (mascotaDto.getIdTipoMascota()!=null){
            mascotaEntity.setIdTipoMascota(mascotaDto.getIdTipoMascota());
            Optional<TipoMascotaEntity> maybeTipoMascotaEntity = tipoMascotaRepository.findById(mascotaDto.getIdTipoMascota());
            TipoMascotaEntity tipoMascotaEntity = maybeTipoMascotaEntity.get();
            mascotaEntity.setNombreTipoMascota(tipoMascotaEntity.getNombre());
        }

        if (mascotaDto.getIdColor1()!=null){
            mascotaEntity.setColor1(mascotaDto.getIdColor1());
            Optional<ColorEntity> maybeColorEntity1 = colorRepository.findById(mascotaDto.getIdColor1());
            ColorEntity colorEntity1 = maybeColorEntity1.get();
            mascotaEntity.setNombreColor1(colorEntity1.getNombre());
        }

        if (mascotaDto.getColor2()!=null){
            mascotaEntity.setColor2(mascotaDto.getColor2());
            Optional<ColorEntity> maybeColorEntity2 = colorRepository.findById(mascotaDto.getColor2());
            ColorEntity colorEntity2 = maybeColorEntity2.get();
            mascotaEntity.setNombreColor2(colorEntity2.getNombre());
        }


        if (mascotaDto.getTamanioMascota()!=null)
            mascotaEntity.setTamanioMascota(mascotaDto.getTamanioMascota());


        if (mascotaDto.getRaza()!=null){
            mascotaEntity.setRaza(mascotaDto.getRaza());
            Optional<RazaEntity> maybeRazaEntity = razaRepository.findById(mascotaDto.getRaza());
            RazaEntity razaEntity = maybeRazaEntity.get();
            mascotaEntity.setNombreRaza(razaEntity.getNombre());
        }


        if (mascotaDto.getPartido()!=null){
            mascotaEntity.setPartido(mascotaDto.getPartido());
            Optional<PartidoEntity> maybePartidoEntity = partidoRepository.findById(mascotaDto.getPartido());
            PartidoEntity partidoEntity = maybePartidoEntity.get();
            mascotaEntity.setNombrePartido(partidoEntity.getNombre());
        }


        if (mascotaDto.getLocalidad()!=null){
            mascotaEntity.setLocalidad(mascotaDto.getLocalidad());
            Optional<LocalidadEntity> maybeLocalidadEntity = localidadRepository.findById(mascotaDto.getLocalidad());
            LocalidadEntity localidadEntity = maybeLocalidadEntity.get();
            mascotaEntity.setNombreLocalidad(localidadEntity.getNombre());
        }


        mascotaEntity.setComentario(mascotaDto.getComentario());
        mascotaEntity.setContinuaPerdido("S");
        mascotaEntity.setTel(mascotaDto.getTelefono());
        mascotaEntity.setFace(mascotaDto.getFacebook());
        mascotaEntity.setEmail(mascotaDto.getMail());
        mascotaEntity.setToken(generarToken());
        mascotaEntity.setGenero(mascotaDto.getGenero());

        mascotaEntity.setUrlImagen(firebaseInitializer.uploadFile(file));

        try {
            mascotaRepository.save(mascotaEntity);
            return true;

        } catch (Exception e){
            return false;
        }
    }


    private String generarToken(){
        // Los caracteres de interés en un array de char.
        char [] chars = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

        // Longitud del array de char.
        int charsLength = chars.length;

        // Instanciamos la clase Random
        Random random = new Random();

        // Un StringBuffer para componer la cadena aleatoria de forma eficiente

        StringBuffer buffer = new StringBuffer();

        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i=0;i<10;i++){

            // Añadimos al buffer un caracter al azar del array
            buffer.append(chars[random.nextInt(charsLength)]);
        }

        return buffer.toString();
    }
}
