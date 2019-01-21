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
public class ControllerAdministrador {
	
	@EJB
	private ManagerAdministrador ma;
	
	//Atributos Rol
	private int idRol;
	private String descripcion;
	//Atributos Usuario
	private int idUs;
	private String username;
	private String password;
	private String nombreUs;
	private String apellidoUs;
	private Date fechanacUs;
	private String ciudadUs;
	private String telefonoUs;
	private String generoUs;
	private String direccionUs;
	private String emailUs;
	
	//Atributos Platos
	private int idPlato;
	private String descripcionPlato;
	private String nombrePlato;
	private double precioPlato;
	private String tipo;
	
	//Atributos Mesas
	private int idMesa;
	private int numMesa;
	private int numSillas;
	
	//Listas de Catalogos
	private List<CatRol> listaRol;
	private List<CatUsuario> listaEmpleados;
	private List<CatPlato> listaPlatos;
	private List<CatMesa> listaMesa;
	private List<CatUsuario> listaCliente;
	
	/*PostConstructor*/
	@PostConstruct
	public void inicializar() {
		listaRol = ma.findAllRol();
		listaEmpleados = ma.findAllUsEmpleado();
		listaPlatos = ma.findAllPlato();
		listaMesa = ma.findAllMesa();
		listaCliente =ma.findAllUsClientes();
	}
	
	/*Metodos Rol*/
	public void actionListenerGuardarRol() {
		ma.insertRol(idRol, descripcion);
		listaRol = ma.findAllRol();
		JSFutil.crearMensajeInfo("Se ha guardado el Rol");
		descripcion = "";
	}
	
	/*Metodos Empleado*/
	/*Metodos Plato*/
	/*Metodos Mesa*/
	/*Metodos Clientes*/
	
	/*Getter and Setter*/
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdUs() {
		return idUs;
	}
	public void setIdUs(int idUs) {
		this.idUs = idUs;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombreUs() {
		return nombreUs;
	}
	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}
	public String getApellidoUs() {
		return apellidoUs;
	}
	public void setApellidoUs(String apellidoUs) {
		this.apellidoUs = apellidoUs;
	}
	public Date getFechanacUs() {
		return fechanacUs;
	}
	public void setFechanacUs(Date fechanacUs) {
		this.fechanacUs = fechanacUs;
	}
	public String getCiudadUs() {
		return ciudadUs;
	}
	public void setCiudadUs(String ciudadUs) {
		this.ciudadUs = ciudadUs;
	}
	public String getTelefonoUs() {
		return telefonoUs;
	}
	public void setTelefonoUs(String telefonoUs) {
		this.telefonoUs = telefonoUs;
	}
	public String getGeneroUs() {
		return generoUs;
	}
	public void setGeneroUs(String generoUs) {
		this.generoUs = generoUs;
	}
	public String getDireccionUs() {
		return direccionUs;
	}
	public void setDireccionUs(String direccionUs) {
		this.direccionUs = direccionUs;
	}
	public String getEmailUs() {
		return emailUs;
	}
	public void setEmailUs(String emailUs) {
		this.emailUs = emailUs;
	}
	public int getIdPlato() {
		return idPlato;
	}
	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}
	public String getDescripcionPlato() {
		return descripcionPlato;
	}
	public void setDescripcionPlato(String descripcionPlato) {
		this.descripcionPlato = descripcionPlato;
	}
	public String getNombrePlato() {
		return nombrePlato;
	}
	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}
	public double getPrecioPlato() {
		return precioPlato;
	}
	public void setPrecioPlato(double precioPlato) {
		this.precioPlato = precioPlato;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getNumMesa() {
		return numMesa;
	}
	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}
	public int getNumSillas() {
		return numSillas;
	}
	public void setNumSillas(int numSillas) {
		this.numSillas = numSillas;
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
