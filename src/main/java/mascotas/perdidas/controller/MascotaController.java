package mascotas.perdidas.controller;

import mascotas.perdidas.data.dto.MascotaDto;
import mascotas.perdidas.data.entity.*;
import mascotas.perdidas.data.repository.*;
import mascotas.perdidas.service.FirebaseInitializer;
import mascotas.perdidas.service.MascotaService;
import mascotas.perdidas.service.ObtenerMascotasDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;


@Controller
@RequestMapping("")
public class MascotaController {

    private MascotaRepository mascotaRepository;
    private PartidoRepository partidoRepository;
    private LocalidadRepository localidadRepository;
    private ColorRepository colorRepository;
    private TipoMascotaRepository tipoMascotaRepository;
    private RazaRepository razaRepository;

    @Autowired
    private ObtenerMascotasDtoService obtenerMascotasDtoService;

    @Autowired
    @Qualifier("subirMascotaService")
    private MascotaService mascotaService;


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
    public ModelAndView mostrarInicio() throws ExecutionException, InterruptedException {
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
        data.put("partido", mascotaDto.getPartido());
        data.put("localidad", mascotaDto.getLocalidad());
        data.put("color1", mascotaDto.getIdColor1());
        data.put("color2", mascotaDto.getColor2());
        data.put("idTipoMascota", mascotaDto.getIdTipoMascota());
        data.put("raza", mascotaDto.getRaza());
        List<MascotaEntity> mascotaEntity = mascotaRepository.getData(data);

         obtenerMascotasDtoService.getMascotas(mascotaEntity);

       modelAndView.addObject("mascotas", obtenerMascotasDtoService.getMascotas(mascotaEntity));
       modelAndView.addObject("codigo", "");
       return modelAndView;

    }

    @GetMapping("/ver-mascotas")
    public ModelAndView mostrarTodasLasMascotas(){
        ModelAndView modelAndView = new ModelAndView("mascotas/ver-mascotas-perdidas");

        List<MascotaEntity> mascotaEntity = mascotaRepository.findAll();


        modelAndView.addObject("mascotas", obtenerMascotasDtoService.getMascotas(mascotaEntity));
        modelAndView.addObject("codigo", "");
        return modelAndView;
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
    public ModelAndView guardarMascotas(@ModelAttribute MascotaDto mascotaDto,
                                  BindingResult bindingResult,
                                  @RequestParam("file") MultipartFile file,
                                  RedirectAttributes attributes) throws ParseException, IOException {

        String fileName = mascotaDto.getNombre();

        if(bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }
        MascotaEntity mascotaEntity = new MascotaEntity();

        ModelAndView modelAndView = new ModelAndView("mascotas/mascota-subida");

        if( mascotaService.validarYConvertirMascotaDtoAMascotaEntity(mascotaEntity, mascotaDto, file))
            modelAndView.addObject("codigo", mascotaEntity.getToken());
        else
            return new ModelAndView("error");

        return modelAndView;
    }


    @GetMapping("/nosotros")
    public ModelAndView mostrarNosotros(){
        ModelAndView modelAndView = new ModelAndView("mascotas/nosotros");
        return modelAndView;
    }


    @GetMapping("/editar-mascota/{id_mascota}")
    public ModelAndView mostrarFormularioEditarMascota(@PathVariable("id_mascota") Integer idMascota,
                                                       @ModelAttribute ("codigo") String codigo){

        Optional<MascotaEntity> maybeMascotaEntity =  mascotaRepository.findById(idMascota);

        if(!maybeMascotaEntity.isPresent()){

            return new ModelAndView("error");
        }

        MascotaEntity mascotaEntity = maybeMascotaEntity.get();


        if(codigo.equals(mascotaEntity.getToken()) == false){
            ModelAndView mav =  new ModelAndView("error");
            mav.addObject("mensaje", "el código ingresado es incorrecto");
            return mav;

        }

        ModelAndView modelAndView = new ModelAndView("mascotas/editar-mascota");

        MascotaDto mascotaDto = new MascotaDto();
        mascotaDto.setCodigo(mascotaEntity.getToken());
        mascotaDto.setId(mascotaEntity.getId());

        modelAndView.addObject("colores", colorRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("tiposMascotas",tipoMascotaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("razas", razaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));

        modelAndView.addObject("mascota", mascotaDto);

        return modelAndView;

    }

    @PostMapping("/editar-mascota/{id_mascota}")
    public String editarMascota(@PathVariable("id_mascota") Integer idMascota,
            @ModelAttribute MascotaDto mascotaDto){

        Optional<MascotaEntity> maybeMascotaEntity = mascotaRepository.findById(idMascota);

        if(!maybeMascotaEntity.isPresent()){
            return "redirect:/error";
        }

        MascotaEntity mascotaEntity = maybeMascotaEntity.get();

        if (mascotaDto.getNombre()!=null)
            mascotaEntity.setNombre(mascotaDto.getNombre());

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

        if (mascotaDto.getFacebook()!=null)
            mascotaEntity.setFace(mascotaDto.getFacebook());
        if (mascotaDto.getMail()!=null)
            mascotaEntity.setEmail(mascotaDto.getMail());

        mascotaRepository.save(mascotaEntity);

        return "redirect:/ver-mascotas";

    }

    @PostMapping("/eliminar-mascota/{id_mascota}")
    public String eliminarMascota(@PathVariable("id_mascota") Integer idMascota,
                                                       @ModelAttribute ("codigo-elimina") String codigo){

        Optional<MascotaEntity> maybeMascotaEntity =  mascotaRepository.findById(idMascota);

        if(!maybeMascotaEntity.isPresent()){

            return "redirect:/error";
        }

        MascotaEntity mascotaEntity = maybeMascotaEntity.get();


        if(!codigo.equals(mascotaEntity.getToken())){
            return "redirect:error/el código ingresado es incorrecto";
        }

        mascotaEntity.setContinuaPerdido("N");
        mascotaRepository.save(mascotaEntity);

        return "redirect:/ver-mascotas";

    }

    @GetMapping("/preguntas-frecuentes")
    public ModelAndView preguntasFrecuentes(){

        ModelAndView modelAndView = new ModelAndView("preguntas-frecuentes");
        return modelAndView;
    }

    @GetMapping({"/error/{msj}","/error"})
    public ModelAndView devolverError(@ModelAttribute("mensaje") String mensaje){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject(mensaje);
        return modelAndView;
    }
}
