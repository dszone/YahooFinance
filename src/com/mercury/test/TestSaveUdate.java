package com.mercury.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.Game;
import com.mercury.beans.Player;
import com.mercury.util.HibernateUtil;

public class TestSaveUdate {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		
		Transaction tx = session.beginTransaction();
		Game football = new Game("FootBall", 001);
		Game basketball = new Game("BasketBall",002);
		Player p1 = new Player("Tom", 001, football);
		Player p2 = new Player("Charly",002,basketball);
		Player p3 = new Player("Kate",003,basketball);
		session.saveOrUpdate(football);
		session.saveOrUpdate(basketball);
		session.saveOrUpdate(p1);
		session.saveOrUpdate(p2);
		session.saveOrUpdate(p3);
	
		tx.commit();
		String hql = "from Player";
		List<Player> list = session.createQuery(hql).list();
		for (Player p : list){
			System.out.println(p);
		}
		Game tennis = new Game("Tennis",003); 
		tx.begin();
		p2.setGame(tennis);
		session.saveOrUpdate(p2);
		tx.commit();
		list = session.createQuery(hql).list();
		for (Player p : list){
			System.out.println(p);
		}
		tx.begin();
		session.delete(p2);
		tx.commit();
		list = session.createQuery(hql).list();
		for (Player p : list){
			System.out.println(p);
		}
		String hql2="from Game";
		List<Game> list2 = session.createQuery(hql2).list();
		for (Game g : list2){
			System.out.println(g);
		}
		HibernateUtil.closeSession();
		
		
		
		
	}

}
