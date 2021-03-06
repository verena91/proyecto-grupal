package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Type;

@Stateless
public class TypeDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Type> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Type.class);
		
		criteria.add(Restrictions.ilike("description", filter));
		
		return criteria.list();

	}
	
	@SuppressWarnings("unchecked")
	public List<Type> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Type.class);
		
		return criteria.list();

	}
	
	public Type findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Type.class);
		
		criteria.add(Restrictions.eq("id", id));
		
		return (Type) criteria.uniqueResult();

	}
	
	public void insert(Type t){
		entityManager.persist(t);
	}
	
	public void update(Integer id, Type type){
		Type t = findById(id);
		t.setCreationDate(type.getCreationDate());
		t.setDescription(type.getDescription());
		t.setName(type.getName());
		entityManager.merge(t);
	}
	
	public void delete(Integer id){
		Type t = findById(id);
		entityManager.remove(t);
	}
}