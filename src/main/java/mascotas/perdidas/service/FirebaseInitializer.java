package mascotas.perdidas.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Objects;

@Service
public class FirebaseInitializer {

    StorageOptions storageOptions;

    @PostConstruct
    private void initDb() throws IOException {

        InputStream serviceAccount = this.getClass().getClassLoader()
                .getResourceAsStream("./primeroproyecto-65f07-firebase-adminsdk-lt6ka-439d080bc7.json");

        storageOptions = StorageOptions.newBuilder()
                .setProjectId("primeroproyecto-65f07")
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
    }



    public String uploadFile (MultipartFile multipartFile) throws IOException {


        File file = convertMultiPartToFile(multipartFile);
        Path filePath = file.toPath();
        String objectName = generateFileName(multipartFile);

        Storage storage = storageOptions.getService();

        BlobId blobId = BlobId.of("primeroproyecto-65f07.appspot.com", objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        Blob blob = storage.create(blobInfo, Files.readAllBytes(filePath));

        return objectName;

    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + Objects.requireNonNull(multiPart.getOriginalFilename()).replace(" ", "_");
    }

}
