package pl.odrobinska.projekt;

import java.util.List;
import java.util.Optional;

public class KitchenRepository {
    List<Kitchen> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Kitchen", Kitchen.class).list();
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
     Optional<Kitchen> findById(Integer id){
          var session = HibernateUtil.getSessionFactory().openSession();
          var transaction = session.beginTransaction();
          var result = session.get(Kitchen.class, id);
          transaction.commit();
          session.close();
          return Optional.ofNullable(result);
    }

    Kitchen addKitchenElement(Kitchen newKitchenElement){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        session.persist(newKitchenElement);
        transaction.commit();
        session.close();
        return newKitchenElement;
    }
}
