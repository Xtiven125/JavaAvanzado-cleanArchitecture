package co.com.bancolombia.api;
import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.usecase.animalescasos.AnimalesCasosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final AnimalesCasosUseCase animalesCasosUseCase;

    @GetMapping(path = "/path")
    public String commandName() {
        return "Hello World";
    }
    @GetMapping(path = "/animales/{id}")
    public Animales read(@PathVariable String id) {
        return animalesCasosUseCase.read(id);
    }
    @PostMapping(path = "/animales")
    public void create(@RequestBody Animales animales) {
        animalesCasosUseCase.create(animales);
    }
    @GetMapping(path = "/animales")
    public List<Animales> getAll() {
        return animalesCasosUseCase.getAll();
    }
    @PutMapping(path = "/animales/{id}")
    public void update(@PathVariable String id, @RequestBody Animales animales) {
        try {
            animalesCasosUseCase.update(id, animales);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    @DeleteMapping(path = "/animales/{id}")
    public void delete(@PathVariable String id) {
        animalesCasosUseCase.delete(id);
    }

}
