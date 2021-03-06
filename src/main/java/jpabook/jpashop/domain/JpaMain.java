package jpabook.jpashop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author : Eunmo Hong
 * @since : 2020/11/01
 */

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			Order order = new Order();
			order.addOrderItem(new OrderItem());

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}

		emf.close();
	}
}
