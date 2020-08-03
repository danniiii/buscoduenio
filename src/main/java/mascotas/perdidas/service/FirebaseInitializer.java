package mascotas.perdidas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;



import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Objects;

@Service
public class FirebaseInitializer {

    StorageOptions storageOptions;
    private final Environment environment;
    private String projectId;


    public FirebaseInitializer(Environment environment) {
        this.environment = environment;
    }


    @PostConstruct
    private void initDb() throws Exception {

        projectId = environment.getRequiredProperty("FIREBASE_PROJECT_ID");


/*        InputStream serviceAccount = this.getClass().getClassLoader()
                .getResourceAsStream("./primeroproyecto-65f07-firebase-adminsdk-lt6ka-439d080bc7.json");*/

        InputStream firebaseCredential = createFirebaseCredential();

        storageOptions = StorageOptions.newBuilder()
                .setProjectId(projectId)
                .setCredentials(GoogleCredentials.fromStream(firebaseCredential))
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

    private InputStream createFirebaseCredential() throws Exception {
        FirebaseCredential firebaseCredential = new FirebaseCredential();
        //private key
        String privateKey = environment.getRequiredProperty("FIREBASE_PRIVATE_KEY");//.replace("\\n", "\n");

        firebaseCredential.setType(environment.getRequiredProperty("FIREBASE_TYPE"));
        firebaseCredential.setProject_id(projectId);
        firebaseCredential.setPrivate_key_id(environment.getProperty("FIREBASE_PRIVATE_KEY_ID"));
        firebaseCredential.setPrivate_key(privateKey);
        firebaseCredential.setClient_email(environment.getRequiredProperty("FIREBASE_CLIENT_EMAIL"));
        firebaseCredential.setClient_id(environment.getRequiredProperty("FIREBASE_CLIENT_ID"));
        firebaseCredential.setAuth_uri(environment.getRequiredProperty("FIREBASE_AUTH_URI"));
        firebaseCredential.setToken_uri(environment.getRequiredProperty("FIREBASE_TOKEN_URI"));
        firebaseCredential.setAuth_provider_x509_cert_url(environment.getRequiredProperty("FIREBASE_AUTH_PROVIDER_X509_CERT_URL"));
        firebaseCredential.setClient_x509_cert_url(environment.getRequiredProperty("FIREBASE_CLIENT_X509_CERT_URL"));



        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(firebaseCredential);

        System.out.println("bucket name====" + jsonString);
        //convert jsonString string to InputStream using Apache Commons
        return IOUtils.toInputStream(jsonString, "UTF-8");

    }

}
