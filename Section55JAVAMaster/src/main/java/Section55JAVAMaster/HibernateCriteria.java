package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class HibernateCriteria {
    public static void main(String[] args) {

        EntityManager em= JpaUtil.getEntityManager();

        CriteriaBuilder criteria=em.getCriteriaBuilder();
        CriteriaQuery<Client> query=criteria.createQuery(Client.class);
        Root<Client> from=query.from(Client.class);
        query.select(from);
        List<Client>clients=em.createQuery(query).getResultList();

        clients.forEach(c-> System.out.println(c.getName()));

        System.out.println("=========list where equals========");

        query=criteria.createQuery(Client.class);
        from=query.from(Client.class);
        ParameterExpression<String> nameP=criteria.parameter(String.class,"name");
        query.select(from).where(criteria.equal(from.get("name"),nameP));
        clients=em.createQuery(query).setParameter("name","user1").getResultList();
        clients.forEach(System.out::println);

        System.out.println("=========where like find client by payment method========");

        query= criteria.createQuery(Client.class);
        from=query.from(Client.class);
        query.select(from).where(criteria.like(from.get("paymentMethod"),"%as%"));
        clients=em.createQuery(query).getResultList();
        clients.forEach(System.out::println);

        System.out.println("=========where between find client by id range========");

        query= criteria.createQuery(Client.class);
        from=query.from(Client.class);
        query.select(from).where(criteria.between(from.get("id"),3L,6L));
        clients=em.createQuery(query).getResultList();
        clients.forEach(System.out::println);


        em.close();

    }
}
