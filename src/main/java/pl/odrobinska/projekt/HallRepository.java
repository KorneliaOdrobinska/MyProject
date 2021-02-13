package pl.odrobinska.projekt;

import java.util.List;
import java.util.Optional;

public class HallRepository {
    List<Hall> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Hall", Hall.class).list();
        transaction.commit();
        session.close();
        return result;
    }

  /*  Optional<Bedroom> findById(Integer id){
        // TODO zastosowac wyrazenia lambda
            Bedroom tempItem = null;
            for(Bedroom item: bedroomElements){
                if (item.getId() == id){
                    tempItem = item;
                }
            }
            return Optional.ofNullable(tempItem);
        }

   */
     Optional<Hall> findById(Integer id){
          var session = HibernateUtil.getSessionFactory().openSession();
          var transaction = session.beginTransaction();
          var result = session.get(Hall.class, id);
          transaction.commit();
          session.close();
          return Optional.ofNullable(result);
    }

    Hall addHallElement(Hall newHallElement){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        session.persist(newHallElement);
        transaction.commit();
        session.close();
        return newHallElement;
    }
}
