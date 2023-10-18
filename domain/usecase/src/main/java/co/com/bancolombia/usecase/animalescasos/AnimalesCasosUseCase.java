package co.com.bancolombia.usecase.animalescasos;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class AnimalesCasosUseCase {
    private AnimalesRepository animalesRepository;
    public void create(Animales animales){animalesRepository.create(animales);}
    public Animales read(String nombre){ return animalesRepository.read(nombre);}
    public Animales update(String nombre, Animales animales) throws Exception {
        animalesRepository.update(nombre, animales);
        return animales;
    }
    public void delete(String nombre) {animalesRepository.delete(nombre);}
    public List<Animales> getAll() {return animalesRepository.getAll();}
}
