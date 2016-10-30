package spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import spring.model.Articulo;

@RestController
public class MainController {

  @RequestMapping(value="/", produces = "application/json")
  @ResponseBody
  public String index() {
	  Articulo a = new Articulo("444", "PASTA",580);
	  Articulo a2 = new Articulo("54534", "COA",60);
	  List<Articulo> list = new ArrayList<>();
	  list.add(a);
	  list.add(a2);
	  
	  Map<String, Object> map = new HashMap<String,Object>();
	  
//	  JSONObject json = new JSONObject(a);
	  Gson gson = new Gson();
	  String json = gson.toJson(list);
	  return json;
  	}

}
