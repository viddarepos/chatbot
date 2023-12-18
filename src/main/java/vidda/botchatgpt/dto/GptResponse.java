package vidda.botchatgpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GptResponse {

    private List<Izbori> choice;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Izbori {
        private int index;
        private Message message;
    }
}
