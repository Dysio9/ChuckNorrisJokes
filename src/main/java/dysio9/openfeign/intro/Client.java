package dysio9.openfeign.intro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ChuckNorrisJokes",
        url = "https://api.chucknorris.io/jokes")
public interface Client {

    @GetMapping(path = "random")
    public ResponseDto getRandomJoke();
}
