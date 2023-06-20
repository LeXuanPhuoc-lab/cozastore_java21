package cybersoft.example.cozastore_java21.controller;

import cybersoft.example.cozastore_java21.exception.CustomFileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/demo")
public class DemoUploadFileController {

    // Path chua toan bo ham ho tro san lien quan den duong dan
    @Value("${path.root}")
    private String spath;

    //private FileStorageService fileStorageService = new FileStorageServiceImpl(Paths.get(spath));

    @PostMapping("/uploadfile")
    public ResponseEntity<?> uploadFile(
            @RequestParam MultipartFile file
            ){

        // convert directory String into Path Class supported by Java
        // define directory
        Path rootPath = Paths.get(spath);

            try {
                if(!Files.exists(rootPath)) {
                    // create new if directory doesn't exist
                    Files.createDirectories(rootPath);
                }

                //  /Users/USER/Desktop/image21
                // resolve <=> /
                // file.getOriginalFilename(): lay ten file va dinh dang

                String filename = file.getOriginalFilename();
                Files.copy(file.getInputStream(),
                        rootPath.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Loi " + e.getLocalizedMessage());
            }
        return new ResponseEntity<>("", HttpStatus.OK);
    }

//    @PostMapping("/downloadFile")
//    public ResponseEntity<?> downloadFile(@RequestParam String fileName) {
//        Resource file = fileStorageService.load(fileName);
//        return new ResponseEntity<>(file, HttpStatus.OK);
//    }
    @GetMapping("{filename}")
    public ResponseEntity<?> loadFile(@PathVariable String filename){
        Resource resource = null;
        try {
            // root directory image in server
            Path rootPath = Paths.get(spath);
            resource = new UrlResource(rootPath.resolve(filename).toUri());

            if(resource.exists()){
                // neu ton tai cho phep ho download
//                return new ResponseEntity<>(resource, HttpStatus.OK);
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
            }else{
                // khi nem exception thi code se dung
                throw new CustomFileNotFoundException(200,"File Not Found");
            }
        } catch (MalformedURLException e) {
            throw new CustomFileNotFoundException(200,"File Not Found");
        }
    }
}
