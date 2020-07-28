package mascotas.perdidas.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {

    private String pathArchivo = ".//src//main//resources//static//files//";

    public boolean saveFile (MultipartFile file, String fileName) throws IOException {

        if(!file.isEmpty()){
            //sacar extensión de archivo
            String extension = file.getContentType().split("/")[1];
            byte [] bytes = file.getBytes();
            Path path = Paths.get(pathArchivo + fileName + "." + extension);
            Files.write(path,bytes);
            return true;
         }

        return false;
    }
}
