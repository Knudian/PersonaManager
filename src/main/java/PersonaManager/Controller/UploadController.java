package PersonaManager.Controller;

import PersonaManager.Model.MediaFile;
import PersonaManager.Service.Interface.IMediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

/**
 * @link https://www.mkyong.com/spring-mvc/spring-mvc-file-upload-example/
 */
@Controller
public class UploadController {

    private static String UPLOAD_FOLDER = "upload";

    @Autowired
    private IMediaFileService iMediaFileService;

    private String fileUploadedResponse(MediaFile mediaFile){
        JsonObject model = Json.createObjectBuilder()
                .add("name", mediaFile.getFilename())
                .add("id", mediaFile.getId())
                .build();
        return buildResponse(model);
    }

    private String exceptionResponse(Exception e){
        JsonObject model = Json.createObjectBuilder()
                .add("message", e.getMessage())
                .add("stack", e.getStackTrace().toString())
                .build();
        return buildResponse(model);
    }

    private String buildResponse(JsonObject model){
        return model.toString();
    }

    @PostMapping("/upload")
    public String singleFileUpload(
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes
            ){

        if( file.isEmpty() ){
            redirectAttributes.addFlashAttribute(
                    "message", "Please select a file to upload"
            );
            return null;
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "File uploaded");

            MediaFile mediaFile = new MediaFile();
            mediaFile.setFilename(path.toString());
            mediaFile.setUploadTime(new Timestamp(System.currentTimeMillis()));

            iMediaFileService.create(mediaFile);

            return fileUploadedResponse(mediaFile);

        } catch (IOException e) {
            return exceptionResponse(e);
        }

    }
}
