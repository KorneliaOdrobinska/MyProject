package pl.odrobinska.projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BedroomRepository {
    List<Bedroom> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Bedroom", Bedroom.class).list();
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
     Optional<Bedroom> findById(Integer id){
          var session = HibernateUtil.getSessionFactory().openSession();
          var transaction = session.beginTransaction();
          var result = session.get(Bedroom.class, id);
          transaction.commit();
          session.close();
          return Optional.ofNullable(result);
    }
}
