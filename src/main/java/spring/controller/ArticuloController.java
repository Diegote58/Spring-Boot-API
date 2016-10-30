package spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import spring.model.Articulo;
import spring.service.ArticuloService;

@RestController
@RequestMapping(value="/articulo")
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;
	

	  @RequestMapping(value="/save",method=RequestMethod.POST)
	  @ResponseBody
	  public String create(@FormParam("codigo") String codigo,
				@FormParam("nombre") String nombre,@FormParam("precio") double precio) {
	    try {
	    	Articulo articulo = new Articulo(codigo,nombre,precio);
	    	//articulo.setId(id);
	    	System.out.println("ARTICULO: " + articulo.toString());
	      articuloService.saveOrUpdate(articulo);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "Articulo succesfully saved! ";
	  }

	  @RequestMapping(value="/update")
	  @ResponseBody
	  public String update(Articulo articulo) {
	    try {
	      articuloService.saveOrUpdate(articulo);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "Articulo succesfully Updated!";
	  }
	  
	  @RequestMapping(value="/getArticuloByCode",method = RequestMethod.GET)
	  @ResponseBody
	  public String getByCode(String codigo) {
	   
	    try {
	    	System.out.println("asdfg: "+codigo);
	    	Gson gson = new Gson();
	    	List<Articulo> art = articuloService.findByCode(codigo);
			/*Map<String, Object> map = new HashMap<>();
			for (int i = 0; i < art.size(); i++) {
				map.put("nombre", art.get(i).getNombre());
				map.put("precio", art.get(i).getPrecio());
			}*/
	    	String json = gson.toJson(art);
	     return json;
	     
	    }
	    catch(Exception ex) {
	    	System.out.println("NULL");
	      return null;
	    }
	    
	  }
	  
	  @RequestMapping(value="/getArticuloById",method = RequestMethod.GET)
	  @ResponseBody
	  public String getByID(int id) {
	   
	    try {
	    	System.out.println("asdfg: "+id);
	    	Gson gson = new Gson();
	    	String json = gson.toJson(articuloService.findById(id));
	     return json;
	     
	    }
	    catch(Exception ex) {
	    	System.out.println("NULL");
	      return null;
	    }
	    
	  }
	  
	  @RequestMapping(value="/listar")
	  @ResponseBody
	  public String ListAll(){
		  Gson gson = new Gson();
		  String json = gson.toJson(articuloService.List());
		  return json;
	  }
	  
	  @RequestMapping(value="/getArticuloByName")
	  @ResponseBody
	  public String Listar(String nombre){
		  Gson gson = new Gson();
		  String json = gson.toJson(articuloService.ListByName(nombre));
		  return json;
	  }
}
