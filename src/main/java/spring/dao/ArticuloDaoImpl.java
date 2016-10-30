package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.model.Articulo;

@Transactional
@Repository
public class ArticuloDaoImpl implements ArticuloDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Articulo articulo) {
		getSession().save(articulo);
	}

	@Override
	public void update(Articulo articulo) {
		getSession().update(articulo);
	}

	@Override
	public void delete(Articulo articulo) {
		getSession().delete(articulo);
	}

	@Override
	public List<Articulo> getAll() {
		Query query = getSession().createQuery("from Articulo");
		return query.list();
	}

	@Override
	public List<Articulo> getByName(String nombre) {
		Criteria criteria = getSession().createCriteria(Articulo.class)
				.add(Restrictions.like("nombre", "%"+nombre+"%"));
		return criteria.list();
	}
	
	@Override
	public List<Articulo> getByCodigo(String codigo) {

		Criteria criteria = getSession().createCriteria(Articulo.class).add(Restrictions.eq("codigo", codigo));
		return criteria.list();
	}

	@Override
	public Articulo getById(int id) {
		Criteria criteria = getSession().createCriteria(Articulo.class).add(Restrictions.eq("id", id));
		return (Articulo) criteria.uniqueResult();
	}

}
