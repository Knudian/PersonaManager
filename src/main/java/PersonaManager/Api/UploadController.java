package PersonaManager.Api;

import PersonaManager.Model.MediaFile;
import PersonaManager.Service.Interface.IMediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
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

@CrossOrigin(origins = "http://localhost:3000")
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

    @RequestMapping(
            value="/upload",
            method = RequestMethod.POST
    )
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap){
        modelMap.addAttribute("file", file);
        return "Obi wan Kenobi was here";
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return new CommonsMultipartResolver();
    }

    @Bean
    public StandardServletMultipartResolver standardServletMultipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
