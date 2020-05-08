package com.aula114.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import com.aula114.model.FraseCelebre;

@ManagedBean
@SessionScoped

public class ViewManager implements Serializable {

	private Set <String> listaCategorias;
	private List <FraseCelebre> listaFrasesCategoria;
	private String categoriaSeleccionada = null;
	private FraseCelebre fselect;
        private String autorSelect;
        private String unNombre;
	@ManagedProperty("#{fraseService}")
	private ServiceFrase service;

	@PostConstruct
	public void init() {
		listaCategorias = service.mostrarCategorias();
	}
	
	public List<String> getFrasesAutor() {
                List<String> lista = new ArrayList<String>();
                // a obtener de la base de datos...
                // cada fila obtenida (esto será el resultado de una sentencia 'select') se pondrá
                // como un elemento de la lista 'lista'.
                // La lista 'lista' es de String, ya que se trata de una lista del contenido alojado
                // en la base de datos como 'descripcion' en la tabla 'frases'.
                System.out.println("EL Autor seleccionado es: " + unNombre);
                lista = service.mostrarFrasesPorAutor(unNombre);
                return lista; // en este momento se renderiza una lista sin elementos.
        }
        public String getUnNombre(){
           return unNombre;
        }
        public void setUnNombre(String unNombre){
           this.unNombre = unNombre;
        }
        public String getAutorSelect(){
           return autorSelect;
        }
	public FraseCelebre getFselect() {
                return fselect;
        }
	public void setFselect(FraseCelebre fselect) {
                this.fselect = fselect;
        }
	public void setCategoriaSeleccionada(String categS) {
                categoriaSeleccionada = categS;
		listaFrasesCategoria = service.mostrarFrasesPorCategoria(categoriaSeleccionada);
        }
	public String getCategoriaSeleccionada() {
            return categoriaSeleccionada;
        }
/*
	public String mas(String autorName){
          System.out.println("**** " + autorName + " ****");
          this.autorSelect = autorName;
          return "mostrarUno";
        } 
*/
	public String add(){
                System.out.println("///////////////////");
		listaFrasesCategoria = service.mostrarFrasesPorCategoria(categoriaSeleccionada);
                System.out.println("///////fin////////////");
		return null;
	}

	public ServiceFrase getService() {
		return service;
	}

	public void setService(ServiceFrase service) {
		this.service = service;
	}

	public Set<String> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(Set<String> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public List<FraseCelebre> getListaFrasesCategoria() {
		return listaFrasesCategoria;
	}

	public void setListaFrasesCategoria(List<FraseCelebre> listaFrasesCategoria) {
		this.listaFrasesCategoria = listaFrasesCategoria;
	}
        public void cateChange(final AjaxBehaviorEvent event)  {
        }
}
