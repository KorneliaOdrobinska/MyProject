package pl.odrobinska.projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaceRepository<T extends Place> {
    private List<T> placeElements;

    // TODO zastosowac wyrazenia lambda
    Optional<T> findById(Integer id){
        T tempItem = null;
        for(T item: placeElements){
            if (item.getId() == id){
                tempItem = item;
            }
        }
        return Optional.ofNullable(tempItem);
    }
    // TODO wybieranie wpisow z odpowiedniej tabeli
   /*
    List<Optional<T>> findByPlace(String place){
        // place - np. tabela Kitchen
        // return - wszystkie wpisy z tabeli Kitchen (place)
    }

    */
}
