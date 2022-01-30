package dysio9.openfeign.intro;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.SplittableRandom;

import static java.lang.Thread.sleep;
import static org.springframework.http.HttpStatus.I_AM_A_TEAPOT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {
    private final Client client;
    private final SplittableRandom random = new SplittableRandom();

    @GetMapping({"/getChuckJoke/sleep/{ms}", "/getChuckJoke"})
    public String getRandom(@PathVariable Optional<Long> ms) {
        log.info("Request was received with delay: " + ms.orElse(0L));
        try {
            sleep(ms.orElse(0L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return client.getRandomJoke().getValue();
    }

    @GetMapping({"/getChuckJoke/failureProbability/{percent}", "/getChuckJoke/failureProbability"})
    public String getRandomWithFailure(@PathVariable Optional<Integer> percent) {
        log.info("Request was received with failure probability: " + percent.orElse(50) + "%");

        boolean isFailure = random.nextInt(1, 101) <= percent.orElse(50);
        if (isFailure) {
            throw new NoSuchElementException("Chuck Norris joke service is unavailable");
        }
        return client.getRandomJoke().getValue();
    }
}
