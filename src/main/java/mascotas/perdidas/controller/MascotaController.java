package mascotas.perdidas.controller;

import mascotas.perdidas.data.dto.MascotaDto;
import mascotas.perdidas.data.dto.SugerenciaDto;
import mascotas.perdidas.data.entity.*;
import mascotas.perdidas.data.repository.*;
import mascotas.perdidas.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

@Controller
@RequestMapping("")
public class MascotaController {

    private MascotaRepository mascotaRepository;

    @Autowired
    private PartidoRepository partidoRepository;
    private LocalidadRepository localidadRepository;
    private ColorRepository colorRepository;
    private TipoMascotaRepository tipoMascotaRepository;
    private RazaRepository razaRepository;
    @Autowired
    public EmailService emailService;

    @Autowired
    public MascotaController(MascotaRepository mascotaRepository, PartidoRepository partidoRepository,
                             LocalidadRepository localidadRepository, ColorRepository colorRepository,
                             TipoMascotaRepository tipoMascotaRepository, RazaRepository razaRepository){

        this.mascotaRepository = mascotaRepository;
        this.partidoRepository = partidoRepository;
        this.localidadRepository = localidadRepository;
        this.colorRepository = colorRepository;
        this.tipoMascotaRepository = tipoMascotaRepository;
        this.razaRepository = razaRepository;
    }

    @GetMapping({"","/"})
    public ModelAndView mostrarInicio(){
        ModelAndView modelAndView = new ModelAndView("mascotas/index");
        modelAndView.addObject("partidos", partidoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("localidades", localidadRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("colores", colorRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("tiposMascotas",tipoMascotaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("razas", razaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("mascota", new MascotaDto());

        return modelAndView;
    }

   @PostMapping("/ver-mascotas")
   public ModelAndView buscarMascotasPerdidas( @ModelAttribute MascotaDto mascotaDto){
        ModelAndView modelAndView = new ModelAndView("mascotas/ver-mascotas-perdidas");
        Map<String, Integer> data = new HashMap<String, Integer>();
        data.put("localidad", mascotaDto.getLocalidad());
        data.put("color1", mascotaDto.getIdColor1());
        data.put("color2", mascotaDto.getColor2());
        data.put("idTipoMascota", mascotaDto.getIdTipoMascota());
        data.put("raza", mascotaDto.getRaza());
        List<MascotaEntity> mascotaEntity = mascotaRepository.getData(data);

        List<MascotaDto> mascotaDtoSalida = new ArrayList<MascotaDto>();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
       for (MascotaEntity entity : mascotaEntity) {

           MascotaDto newMascotaDto = new MascotaDto();
           newMascotaDto.setNombre(entity.getNombre());
           newMascotaDto.setFechaDesaparicion(formatoDelTexto.format(entity.getFechaDesaparicion()));
           newMascotaDto.setNombreColor1(entity.getNombreColor1());
           newMascotaDto.setNombreTipoMascota(entity.getNombreTipoMascota());
           newMascotaDto.setTamanioMascota(entity.getTamanioMascota());
           newMascotaDto.setComentario(entity.getComentario());
           newMascotaDto.setTelefono(entity.getTel());

           mascotaDtoSalida.add(newMascotaDto);
       }

        modelAndView.addObject("mascotas", mascotaDtoSalida);
       return modelAndView;

    }

    @GetMapping("/ver-mascotas")
    public ModelAndView mostrarTodasLasMascotas(){
        ModelAndView modelAndView = new ModelAndView("mascotas/ver-mascotas-perdidas");
        modelAndView.addObject("mascotas", mascotaRepository.findAll());
        return  modelAndView;
    }

    @GetMapping("/subir-mascota")
    public ModelAndView mostrarFormularioMascotas(){
        ModelAndView modelAndView = new ModelAndView("mascotas/subir-mascota-perdida");
        modelAndView.addObject("partidos", partidoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("localidades", localidadRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("colores", colorRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("tiposMascotas",tipoMascotaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("razas", razaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("mascota", new MascotaDto());

        return modelAndView;
    }

    @PostMapping("/subir-mascota")
    public String guardarMascotas(@ModelAttribute MascotaDto mascotaDto, BindingResult bindingResult) throws ParseException {

        if(bindingResult.hasErrors()){
            return "Error";
        }
        MascotaEntity mascotaEntity = new MascotaEntity();

        if (mascotaDto.getNombre()!=null)
            mascotaEntity.setNombre(mascotaDto.getNombre());

        if (mascotaDto.getFechaDesaparicion()!=null){
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            mascotaEntity.setFechaDesaparicion(formatoDelTexto.parse(mascotaDto.getFechaDesaparicion()));
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
            mascotaEntity.setNombreColor1(colorEntity2.getNombre());
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

        mascotaRepository.save(mascotaEntity);

        return "redirect:/ver-mascotas";
    }

    @GetMapping("/sugerencias")
    public ModelAndView mostrarFormularioSugerencias(){
        ModelAndView modelAndView = new ModelAndView("mascotas/sugerencias");
        modelAndView.addObject("sugerencia", new SugerenciaDto());
        return modelAndView;
    }

    @PostMapping("/enviar-sugerencia")
    public String enviarSugerencia(@ModelAttribute SugerenciaDto sugerenciaDto,
                                         BindingResult bindingResult){
            if(bindingResult.hasErrors()){
                return  "ERROR AL ENVIAR MAIL";
            }
            String cuerpo = "Nombre: " + sugerenciaDto.getNombre() + '\t' +
                            "Apellido: " + sugerenciaDto.getApellido() + "\n" +
                            "Mail: " + sugerenciaDto.getMail() + "\n\n" +
                            sugerenciaDto.getSugerencia();
            emailService.sendSimpleMessage("danielborge.progra@gmail.com",
                                            "Mensaje de busco dueño",
                                            cuerpo);
            return "redirect:/";
    }

    @GetMapping("/nosotros")
    public ModelAndView mostrarNosotros(){
        ModelAndView modelAndView = new ModelAndView("mascotas/nosotros");
        return modelAndView;
    }
}
