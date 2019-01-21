package proyecto.restaurante.model.manager;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import proyecto.restaurante.model.entities.CatMesa;
import proyecto.restaurante.model.entities.CatPlato;
import proyecto.restaurante.model.entities.CatRol;
import proyecto.restaurante.model.entities.CatUsuario;

/**
 * Session Bean implementation class ManagerAdministrador
 */
@Stateless
@LocalBean
public class ManagerAdministrador {

    /**
     * Default constructor. 
     */	
	
	@PersistenceContext(unitName="restauranteDS")
	private EntityManager em;
	
    public ManagerAdministrador() {
    }

    //MANEJO DE ROL 
    public CatRol findRolById(int idRol) {
    	CatRol rol = (CatRol)em.find(CatRol.class, idRol);
    	return rol;
    }
    
    public List<CatRol> findAllRol(){
    	List<CatRol> lista=em.createQuery("select o from CatRol o").getResultList();
    	return lista;
    }
    
    public CatRol insertRol(int idRol,String descripcion) {
    	CatRol rol= new CatRol();
    	rol.setIdRol(idRol);
    	rol.setDescripcion(descripcion);
    	em.persist(rol);
    	return rol;
    }
  
    //public CatUsuario actualizarRol() {}
    
    public void eliminarRol(int idRol) {
    	CatRol rol =(CatRol)em.find(CatRol.class, idRol);
    	em.remove(rol);
    }
    
    //MANEJO EMPLEADOS
    public CatUsuario findUsEmpleadoById(int idUs) {
    	CatUsuario usEmpleado = (CatUsuario)em.find(CatUsuario.class, idUs);
    	return usEmpleado;
    }
    
    public CatUsuario insertUsEmpleado(String apellidoUs, String ciudadUs, String direccionUs, String emailUs, Date fechanacUs, String generoUs,
    		String nombreUs, String password, String telefonoUs, String username, int idRol) {
    	CatUsuario usEmpleado = new CatUsuario();
    	usEmpleado.setCatRol(findRolById(idRol));
    	usEmpleado.setUsername(username);
    	usEmpleado.setPassword(password);
    	usEmpleado.setNombreUs(nombreUs);
    	usEmpleado.setApellidoUs(apellidoUs);
    	usEmpleado.setFechanacUs(fechanacUs);
    	usEmpleado.setCiudadUs(ciudadUs);
    	usEmpleado.setTelefonoUs(telefonoUs);
    	usEmpleado.setGeneroUs(generoUs);
    	usEmpleado.setDireccionUs(direccionUs);
    	usEmpleado.setEmailUs(emailUs);
    	em.persist(usEmpleado);
    	return usEmpleado;
    }
    
    //public CatUsuario actualizarUsEmpleado() {}
    
    public void eliminarUsEmpleado(int idUs) {
    	CatUsuario usEmpleado=(CatUsuario)em.find(CatUsuario.class, idUs);
    	em.remove(usEmpleado);
    }
    
    public List<CatUsuario> findAllUsEmpleado(){
    	List<CatUsuario> listaEmpleados = em.createQuery("select o from CatUsuarios o ORDER BY o.apellidoUs").getResultList();
    	return listaEmpleados;
    }
    
    
    //MANEJO PLATO
    public CatPlato findPlatoById(int idPlato) {
    	CatPlato plato = (CatPlato)em.find(CatPlato.class, idPlato);
    	return plato;
    }
    
    public CatPlato insertPlato(String descripionPlato, String nombrePlato, double precioPlato, String tipo) {
    	CatPlato plato = new CatPlato();
    	plato.setNombrePlato(nombrePlato);
    	plato.setDescripionPlato(descripionPlato);
    	plato.setPrecioPlato(precioPlato);
    	plato.setTipo(tipo);
    	em.persist(plato);
    	return plato;
    }
    
    //public CatPlato actualizarPlato() {}
    
    public void eliminarPlato(int idPlato) {
    	CatPlato plato = (CatPlato)em.find(CatPlato.class, idPlato);
    	em.remove(plato);
    }
    
    public List<CatPlato> findAllPlato(){
    	List<CatPlato> listaPlatos = em.createQuery("select o from CatPlato o").getResultList();
    	return listaPlatos; 
    }
    
    //MANEJO MESAS
    public CatMesa findMesaById(int idMesa) {
    	CatMesa mesa = (CatMesa)em.find(CatMesa.class, idMesa);
    	return mesa;
    }
    
    public CatMesa insertMesa(Integer numMesa, Integer numSillas) {
    	CatMesa mesa = new CatMesa();
    	mesa.setNumMesa(numMesa);
    	mesa.setNumSillas(numSillas);
    	em.persist(mesa);
    	return mesa;
    }
    
    //public CatMesa actualizarMesa() {}
    
    public void eliminarMesa(int idMesa) {
    	CatMesa mesa = (CatMesa)em.find(CatMesa.class, idMesa);
    	em.remove(mesa);
    }
    
    public List<CatMesa> findAllMesa(){
    	List<CatMesa> listaMesa = em.createQuery("select o from CatMesa o").getResultList();
    	return listaMesa;
    }
    
    //MANEJO CLIENTES
    public List<CatUsuario> findAllUsClientes(){
    	List<CatUsuario> listaCliente = em.createQuery("select o from CatUsuario o ORDER BY o.apellidoUs").getResultList();
    	return listaCliente;
    }
}
