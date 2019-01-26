	package proyecto.restautante.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import proyecto.restaurante.model.entities.CatMesa;
import proyecto.restaurante.model.entities.CatPlato;
import proyecto.restaurante.model.entities.CatRol;
import proyecto.restaurante.model.entities.CatUsuario;
import proyecto.restaurante.model.manager.ManagerAdministrador;
import proyecto.restautante.view.util.JSFutil;

@ManagedBean
@SessionScoped
public class BeanAdministrador {
	
	@EJB
	private ManagerAdministrador ma;
	
	//Atributos Rol
	private int idRol;
	private CatRol catRol;
	
	//Atributos Usuario
	private int idUs;
	private CatUsuario catUsuario;
	
	//Atributos Platos
	private int idPlato;
	private CatPlato catPlato;
	
	//Atributos Mesas
	private int idMesa;
	private CatMesa catMesa;
	
	//Listas de Catalogos
	private List<CatRol> listaRol;
	private List<CatUsuario> listaEmpleados;
	private List<CatPlato> listaPlatos;
	private List<CatMesa> listaMesa;
	private List<CatUsuario> listaCliente;
	
	/*PostConstructor*/
	@PostConstruct
	public void inicializar() {
		catRol = new CatRol();
		listaRol = ma.findAllRol();
		catUsuario = new CatUsuario();
		listaEmpleados = ma.findAllUsEmpleado();
		catPlato = new CatPlato();
		listaPlatos = ma.findAllPlato();
		catMesa = new CatMesa();
		listaMesa = ma.findAllMesa();
		listaCliente =ma.findAllUsClientes();
	}
	
	/*Metodos Rol*/
	public void actionListenerGuardarRol() {
		ma.insertRol(catRol);
		catRol = new CatRol();
		listaRol = ma.findAllRol();
		JSFutil.crearMensajeInfo("Se ha guardado el Rol");
	}
	
	public void actionListenerEliminarRol(CatRol catRoleliminar) {
		ma.eliminarRol(catRoleliminar.getIdRol());
		listaRol = ma.findAllRol();
		JSFutil.crearMensajeWarning("Se ha eliminado el Rol");
	}
	
	public void actionListenerSeleccionarRol(CatRol rolSeleccionado) {
		catRol=rolSeleccionado;
	}
	
	public void actionListenerActualizarRol() {
		ma.actualizarRol(catRol);
		listaRol = ma.findAllRol();
		JSFutil.crearMensajeInfo("Se ha Actualizado el Rol");
		catRol = new CatRol();
	}
	
	/*Metodos Mesa*/
	public void actionListenerGuardarMesa() {
		ma.insertMesa(catMesa);
		catMesa = new CatMesa();
		listaMesa = ma.findAllMesa();
		JSFutil.crearMensajeInfo("Se ha guardado la Mesa");
	}
	
	public void actionListenerEliminarMesa(CatMesa catMesaEliminar) {
		ma.eliminarMesa(catMesaEliminar.getIdMesa());
		listaMesa = ma.findAllMesa();
		JSFutil.crearMensajeWarning("Se ha eliminado la Mesa");
	}
	
	public void actionListenerSeleccionarMesa(CatMesa mesaSeleccionada) {
		catMesa = mesaSeleccionada;
	}
	
	public void actionListenerActualizarMesa() {
		ma.actualizarMesa(catMesa);
		listaMesa = ma.findAllMesa();
		JSFutil.crearMensajeInfo("Se ha guardado la Mesa");
		catMesa = new CatMesa();
	}
	
	/*Metodos Plato*/
	public void actionListenerGuardarPlato() {
		ma.insertPlato(catPlato);
		catPlato = new CatPlato();
		listaPlatos = ma.findAllPlato();
		JSFutil.crearMensajeInfo("Se ha guardado el Plato");
	}
	
	public void actionListenerEliminarPlato(CatPlato catPlatoEliminar) {
		ma.eliminarPlato(catPlatoEliminar.getIdPlato());
		listaPlatos = ma.findAllPlato();
		JSFutil.crearMensajeWarning("Se ha eliminado el Plato");
	}
	
	public void actionListenerSeleccionarPlato(CatPlato platoSeleccionado) {
		catPlato = platoSeleccionado;
	}
	
	public void actionListenerActualizarPlato() {
		ma.actualizarPlato(catPlato);
		listaPlatos = ma.findAllPlato();
		JSFutil.crearMensajeInfo("Se ha Actualizado el Plato");
		catPlato = new CatPlato();
	}
	
	/*Metodos Empleado*/
	
	
	/*Metodos Clientes*/
	
	/*Getter and Setter*/

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public CatRol getCatRol() {
		return catRol;
	}

	public void setCatRol(CatRol catRol) {
		this.catRol = catRol;
	}

	public int getIdUs() {
		return idUs;
	}

	public void setIdUs(int idUs) {
		this.idUs = idUs;
	}

	public CatUsuario getCatUsuario() {
		return catUsuario;
	}

	public void setCatUsuario(CatUsuario catUsuario) {
		this.catUsuario = catUsuario;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public CatPlato getCatPlato() {
		return catPlato;
	}

	public void setCatPlato(CatPlato catPlato) {
		this.catPlato = catPlato;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public CatMesa getCatMesa() {
		return catMesa;
	}

	public void setCatMesa(CatMesa catMesa) {
		this.catMesa = catMesa;
	}

	public List<CatRol> getListaRol() {
		return listaRol;
	}

	public void setListaRol(List<CatRol> listaRol) {
		this.listaRol = listaRol;
	}

	public List<CatUsuario> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<CatUsuario> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public List<CatPlato> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(List<CatPlato> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	public List<CatMesa> getListaMesa() {
		return listaMesa;
	}

	public void setListaMesa(List<CatMesa> listaMesa) {
		this.listaMesa = listaMesa;
	}

	public List<CatUsuario> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<CatUsuario> listaCliente) {
		this.listaCliente = listaCliente;
	}	
}
