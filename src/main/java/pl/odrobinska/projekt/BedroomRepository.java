package pl.odrobinska.projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BedroomRepository {
    private List<Bedroom> bedroomElements;

    public BedroomRepository() {
        bedroomElements = new ArrayList<>();
        bedroomElements.add(new Bedroom(1,"Wallpaper", "https://images.app.goo.gl/rWpgb9RpfndsmfHj8","Blue triangles","Kornelia"));
        bedroomElements.add(new Bedroom(2,"Lamps", "https://images.app.goo.gl/QhthngoqDfmiSW7v9","Hanging lamps","Kornelia"));
    }

    Optional<Bedroom> findById(Integer id){
        // TODO zastosowac wyrazenia lambda
            Bedroom tempItem = null;
            for(Bedroom item: bedroomElements){
                if (item.getId() == id){
                    tempItem = item;
                }
            }
            return Optional.ofNullable(tempItem);
        }
    }
