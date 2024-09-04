package edu.wgu.d387_sample_code.translation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/pres-times")
public class TimeZoneController {

    @GetMapping()
    public ResponseEntity<String> getPresentation() {
        String presentation = "Attention, there will be a live presentation held at the Landon Hotel, starting at " + ConvertTimeZone.convertTime();
        return new ResponseEntity<String>(presentation, HttpStatus.OK);
    }
}
