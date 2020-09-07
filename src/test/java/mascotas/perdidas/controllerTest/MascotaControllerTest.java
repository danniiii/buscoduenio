package mascotas.perdidas.controllerTest;


import mascotas.perdidas.TestConfig;
import mascotas.perdidas.data.dto.MascotaDto;
import mascotas.perdidas.data.entity.MascotaEntity;
import mascotas.perdidas.service.ObtenerMascotasDtoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@TestConfig
public class MascotaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ObtenerMascotasDtoService obtenerMascotasDtoService;

    @Test
    public void mostrarInicioTest() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(handler().methodName("mostrarInicio"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("mascotas/index"))
                .andExpect(model().attributeExists("partidos","localidades","colores","tiposMascotas","razas","mascota"))
                .andExpect(MockMvcResultMatchers.view().name("mascotas/index"))
                .andDo(print());
    }

    @Test
    public void mostrarTodasLasMascotasTest() throws Exception {

        mockMvc.perform(get("/ver-mascotas"))
                .andExpect(handler().methodName("mostrarTodasLasMascotas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("mascotas/ver-mascotas-perdidas"))
                .andExpect(model().attributeExists("codigo","mascotas"))
                .andDo(print());
    }

    @Test
    public void buscarMascotasPerdidasTest() throws Exception {

        MascotaDto mascotaDto = new MascotaDto();

        mockMvc.perform(post("/ver-mascotas")
                        .requestAttr("mascotaDto", mascotaDto))
                .andExpect(handler().methodName("buscarMascotasPerdidas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("mascotas/ver-mascotas-perdidas"))
                .andExpect(model().attributeExists("codigo","mascotas"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void mostrarNosotrosTest() throws Exception {

        MascotaDto mascotaDto = new MascotaDto();

        mockMvc.perform(get("/nosotros"))
                .andExpect(handler().methodName("mostrarNosotros"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("mascotas/nosotros"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void preguntasFrecuentesTest() throws Exception {

        MascotaDto mascotaDto = new MascotaDto();

        mockMvc.perform(get("/preguntas-frecuentes"))
                .andExpect(handler().methodName("preguntasFrecuentes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("preguntas-frecuentes"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void devolverErrorTest() throws Exception {

        MascotaDto mascotaDto = new MascotaDto();

        mockMvc.perform(get("/error/{msj}", "HOLA"))
                .andExpect(handler().methodName("devolverError"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("error"))
 //               .andExpect(model().attribute("mensaje","HOLA"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
