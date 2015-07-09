package com.mercury.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.Game;
import com.mercury.beans.Player;
import com.mercury.util.HibernateUtil;

public class delete {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();

		String hql = "from Player";
		List<Player> list = session.createQuery(hql).list();
		String hql2 = "from Game";
		List<Game> list2 = session.createQuery(hql2).list();

		Transaction tx = session.beginTransaction();
		if (list.size() != 0) {
			for (Player p : list) {
				session.delete(p);
			}
		}
		tx.commit();
		tx.begin();
		if (list2.size() != 0) {
			for (Game g : list2) {
				session.delete(g);
			}
		}
		tx.commit();
	
		list = session.createQuery(hql).list();

		for (Player p : list) {
			System.out.println(p);
		}

		list2 = session.createQuery(hql2).list();
		for (Game g : list2) {
			System.out.println(g);
		}

		HibernateUtil.closeSession();

	}
}
