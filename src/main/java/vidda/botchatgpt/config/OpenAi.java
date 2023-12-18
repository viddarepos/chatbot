package vidda.botchatgpt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAi {
    @Value("${openai.api.key}")
    private String openaiApiKey;

    @Bean
    public RestTemplate template() {
        RestTemplate template = new RestTemplate();
        template.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer + " + openaiApiKey);
            return execution.execute(request, body);
        });

        return template;
    }
}
