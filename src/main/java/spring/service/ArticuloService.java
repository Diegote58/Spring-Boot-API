package spring.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import spring.dao.ArticuloDao;
import spring.model.Articulo;

@Service
public class ArticuloService {

	@Autowired
	private ArticuloDao articuloDao;

	public void saveOrUpdate(Articulo articulo) {
		try {

			if (articulo.getId() == 0) {
				//articulo.setCreate(new Timestamp(new Date().getTime()));
				//articulo.setUpdate(new Timestamp(new Date().getTime()));
				articuloDao.save(articulo);
			} else {
				//articulo.setUpdate(new Timestamp(new Date().getTime()));
				articuloDao.update(articulo);
			}
		} catch (Exception e) {
			System.out.println("Servicio SaveOrUpdate: " + e.getMessage());
		}
	}
	
	public Articulo findById(int id) {
		try {
			
			return articuloDao.getById(id);
		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
			return null;
		}
		
	}
	public List<Articulo> findByCode(String codigo) {
		try {
			System.out.println("serviceCode: " + codigo);
			return articuloDao.getByCodigo(codigo);
		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
			return null;
		}
		
	}

	public void delete(Articulo articulo) {
		try {
			articuloDao.delete(articulo);
		} catch (Exception e) {
			System.out.println("Servicio Delete" + e.getMessage());
		}
	}
	
	public List<Articulo> List(){
		return articuloDao.getAll();
	}

	public List<Articulo> ListByName(String nombre){
		return articuloDao.getByName(nombre);
	}
}
