package pl.odrobinska.projekt;

import java.util.Optional;

public class Service<T extends Place> {
    // TODO: 2021-02-02 zmienic na repository
    private Hall hall;
    private T place;
    private PlaceRepository placeRepository;

    public Service(T place) {
        this.place = place;
    }

    T prepareData(){
        if(place instanceof Kitchen){
            ((Kitchen) place).setType(Optional.ofNullable(((Kitchen) place).getType()).orElse(Type.SMALL));
        }
 //       place.setAuthor(Optional.ofNullable(place.getAuthor()).orElse("Anonymous"));
        if (Optional.ofNullable(place.getAuthor()).orElse("").equals("")){
            place.setAuthor("Anonymous");
        }
        return place;
    }
    /*
    T prepareData(Kitchen kitchen){
        
    }
    */

}
