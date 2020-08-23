package mascotas.perdidas.controller;


import mascotas.perdidas.data.dto.RefugioDto;
import mascotas.perdidas.data.entity.LocalidadEntity;
import mascotas.perdidas.data.entity.MascotaEntity;
import mascotas.perdidas.data.entity.PartidoEntity;
import mascotas.perdidas.data.entity.RefugioEntity;
import mascotas.perdidas.data.repository.LocalidadRepository;
import mascotas.perdidas.data.repository.PartidoRepository;
import mascotas.perdidas.data.repository.RefugioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/refugios")
public class RefugioController {

    @Autowired
    private RefugioRepository refugioRepository;
    @Autowired
    private PartidoRepository partidoRepository;
    @Autowired
    private LocalidadRepository localidadRepository;



    @GetMapping({"","/"})
    public ModelAndView mostrarRefugios(){

        ModelAndView modelAndView = new ModelAndView("refugios/index");

        modelAndView.addObject("refugios", refugioRepository.findAll(Sort.by(Sort.Direction.ASC, "nombrePartido")));

        return modelAndView;
    }

    @GetMapping("/subir-refugio")
    public ModelAndView mostrarFormularioSubirRefugio(){
        ModelAndView modelAndView = new ModelAndView("refugios/subir-refugio");

        modelAndView.addObject("refugio", new RefugioDto());
        modelAndView.addObject("partidos", partidoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));
        modelAndView.addObject("localidades", localidadRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre")));

        return modelAndView;
    }

    @PostMapping("/subir-refugio")
    public String subirRefugio(@ModelAttribute RefugioDto refugioDto,
                                     BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            return "Error";
        }
        RefugioEntity refugioEntity = new RefugioEntity();

        refugioEntity.setNombre(refugioDto.getNombre());

        if (refugioDto.getPartido()!=null){
            refugioEntity.setPartido(refugioDto.getPartido());
            Optional<PartidoEntity> maybePartidoEntity = partidoRepository.findById(refugioDto.getPartido());
            PartidoEntity partidoEntity = maybePartidoEntity.get();
            refugioEntity.setNombrePartido(partidoEntity.getNombre());
        }

        if (refugioDto.getLocalidad()!=null){
            refugioEntity.setLocalidad(refugioDto.getLocalidad());
            Optional<LocalidadEntity> maybeLocalidadEntity = localidadRepository.findById(refugioDto.getLocalidad());
            LocalidadEntity localidadEntity = maybeLocalidadEntity.get();
            refugioEntity.setNombreLocalidad(localidadEntity.getNombre());
        }

        refugioEntity.setComentario(refugioDto.getComentario());
        refugioEntity.setTelefono(refugioDto.getTelefono());
        refugioEntity.setFacebook(refugioDto.getFacebook());
        refugioEntity.setInstagram(refugioDto.getInstagram());
        refugioEntity.setMail(refugioDto.getMail());

        refugioRepository.save(refugioEntity);

        return "redirect:/refugios";
    }
}
