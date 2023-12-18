package vidda.botchatgpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vidda.botchatgpt.dto.GptRequest;
import vidda.botchatgpt.dto.GptResponse;

@RestController
@RequestMapping("/bot")
public class Botcontroller {
    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String url;
    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        GptRequest request = new GptRequest(model, prompt);

        GptResponse response = template.postForObject(url, request, GptResponse.class);

        return response.getChoice().get(0).getMessage().getContent();
    }
}
