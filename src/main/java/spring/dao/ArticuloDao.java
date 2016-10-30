package spring.dao;

import java.util.List;

import spring.model.Articulo;

public interface ArticuloDao {
  

  public void save(Articulo articulo);
   
  
  public void delete(Articulo articulo);
    
  
  public List<Articulo> getAll();
  
  public List<Articulo> getByCodigo(String codigo);
    

  public Articulo getById(int id);
   

  public void update(Articulo articulo);


  public List<Articulo> getByName(String nombre);
    

} // class UserDao
