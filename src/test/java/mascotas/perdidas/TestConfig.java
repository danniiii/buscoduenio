package mascotas.perdidas;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

//@ExtendWith(SpringExtension.class)
@SpringBootTest
//@TestPropertySource(locations = "classpath:test.properties")
@AutoConfigureMockMvc
public @interface TestConfig {

}
