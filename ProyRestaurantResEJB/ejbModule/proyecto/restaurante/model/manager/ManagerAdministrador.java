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
	
	@PersistenceContext(unitName="restauranteDS")
	private EntityManager em;
	
    public ManagerAdministrador() {
    }

    //MANEJO DE ROL 
    public List<CatRol> findAllRol(){
    	List<CatRol> lista=em.createQuery("select o from CatRol o").getResultList();
    	return lista;
    }
    
    public CatRol insertRol(CatRol rolnuevo) {
    	CatRol rol= new CatRol();
    	rol.setDescripcion(rolnuevo.getDescripcion());
    	em.persist(rol);
    	return rol;
    }
    
    public void eliminarRol(int idRol) {
    	CatRol rol =(CatRol)em.find(CatRol.class, idRol);
    	em.remove(rol);
    }
    
    public CatRol findRolById(int idRol) {
    	CatRol rol = (CatRol)em.find(CatRol.class, idRol);
    	return rol;
    }
    	   
    public CatRol actualizarRol(CatRol rol) {
    	CatRol rolActual = findRolById(rol.getIdRol());
    	rolActual.setDescripcion(rol.getDescripcion());
    	em.merge(rolActual);
    	return rolActual;
    }
    
  //MANEJO MESAS
    public List<CatMesa> findAllMesa(){
    	List<CatMesa> listaMesa = em.createQuery("select o from CatMesa o").getResultList();
    	return listaMesa;
    }
    
    public CatMesa insertMesa(CatMesa mesaNueva) {
    	CatMesa mesa = new CatMesa();
    	mesa.setNumMesa(mesaNueva.getNumMesa());
    	mesa.setNumSillas(mesaNueva.getNumSillas());
    	em.persist(mesa);
    	return mesa;
    }
    
    public void eliminarMesa(int idMesa) {
    	CatMesa mesa = (CatMesa)em.find(CatMesa.class, idMesa);
    	em.remove(mesa);
    }
    
    public CatMesa findMesaById(int idMesa) {
    	CatMesa mesa = (CatMesa)em.find(CatMesa.class, idMesa);
    	return mesa;
    }
      
    public CatMesa actualizarMesa(CatMesa mesa) {
    	CatMesa mesaActual = findMesaById(mesa.getIdMesa());
    	mesaActual.setNumMesa(mesa.getNumMesa());
    	mesaActual.setNumSillas(mesa.getNumSillas());
    	em.merge(mesaActual);
    	return mesaActual;
    }
    
  //MANEJO PLATO
    public List<CatPlato> findAllPlato(){
    	List<CatPlato> listaPlatos = em.createQuery("select o from CatPlato o").getResultList();
    	return listaPlatos; 
    }
    
    public CatPlato insertPlato(CatPlato platoNuevo) {
    	CatPlato plato = new CatPlato();
    	plato.setNombrePlato(platoNuevo.getNombrePlato());
    	plato.setDescripionPlato(platoNuevo.getDescripionPlato());
    	plato.setPrecioPlato(platoNuevo.getPrecioPlato());
    	plato.setTipo(platoNuevo.getTipo());
    	em.persist(plato);
    	return plato;
    }
    
    public void eliminarPlato(int idPlato) {
    	CatPlato plato = (CatPlato)em.find(CatPlato.class, idPlato);
    	em.remove(plato);
    }
    
    public CatPlato findPlatoById(int idPlato) {
    	CatPlato plato = (CatPlato)em.find(CatPlato.class, idPlato);
    	return plato;
    }
       
    public CatPlato actualizarPlato(CatPlato plato) {
    	CatPlato platoActual = findPlatoById(plato.getIdPlato());
    	platoActual.setNombrePlato(plato.getNombrePlato());
    	platoActual.setDescripionPlato(plato.getDescripionPlato());
    	platoActual.setPrecioPlato(plato.getPrecioPlato());
    	platoActual.setTipo(plato.getTipo());
    	em.merge(platoActual);
    	return platoActual;
    }
         
    //MANEJO EMPLEADOS
    public List<CatUsuario> findAllUsEmpleado(){
    	List<CatUsuario> listaEmpleados = em.createQuery("select o from CatUsuario o WHERE o.catRol.descripcion = 'Empleado' "
    			+ "ORDER BY o.apellidoUs").getResultList();
    	return listaEmpleados;
    }
    
    public CatUsuario insertUsEmpleado(CatUsuario empleadoNuevo, int idRol) {
    	CatUsuario usEmpleado = new CatUsuario();
    	usEmpleado.setUsername(empleadoNuevo.getUsername());
    	usEmpleado.setPassword(empleadoNuevo.getPassword());
    	usEmpleado.setNombreUs(empleadoNuevo.getNombreUs());
    	usEmpleado.setApellidoUs(empleadoNuevo.getApellidoUs());
    	usEmpleado.setFechanacUs(empleadoNuevo.getFechanacUs());
    	usEmpleado.setCiudadUs(empleadoNuevo.getCiudadUs());
    	usEmpleado.setTelefonoUs(empleadoNuevo.getTelefonoUs());
    	usEmpleado.setGeneroUs(empleadoNuevo.getGeneroUs());
    	usEmpleado.setDireccionUs(empleadoNuevo.getDireccionUs());
    	usEmpleado.setEmailUs(empleadoNuevo.getEmailUs());
    	//dad object
    	CatRol rol = (CatRol)em.find(CatRol.class, idRol);
    	usEmpleado.setCatRol(rol);
    	em.persist(usEmpleado);
    	return usEmpleado;
    }
    
    public void eliminarUsEmpleado(int idUs) {
    	CatUsuario usEmpleado=(CatUsuario)em.find(CatUsuario.class, idUs);
    	em.remove(usEmpleado);
    }
    
    public CatUsuario findUsEmpleadoById(int idUs) {
    	CatUsuario usEmpleado = (CatUsuario)em.find(CatUsuario.class, idUs);
    	return usEmpleado;
    }
      
    public CatUsuario actualizarUsEmpleado(CatUsuario empleado, int idRol) {
    	CatUsuario empleadoActual = findUsEmpleadoById(empleado.getIdUs());
    	empleadoActual.setUsername(empleado.getUsername());
    	empleadoActual.setPassword(empleado.getPassword());
    	empleadoActual.setNombreUs(empleado.getNombreUs());
    	empleadoActual.setApellidoUs(empleado.getApellidoUs());
    	empleadoActual.setFechanacUs(empleado.getFechanacUs());
    	empleadoActual.setCiudadUs(empleado.getCiudadUs());
    	empleadoActual.setTelefonoUs(empleado.getTelefonoUs());
    	empleadoActual.setGeneroUs(empleado.getGeneroUs());
    	empleadoActual.setDireccionUs(empleado.getDireccionUs());
    	empleadoActual.setEmailUs(empleado.getEmailUs());
    	//dad object
    	CatRol rol = (CatRol)em.find(CatRol.class, idRol);
    	empleadoActual.setCatRol(rol);
    	em.merge(empleadoActual);
    	return empleadoActual;
    }
        
    //MANEJO CLIENTES
    public List<CatUsuario> findAllUsClientes(){
    	List<CatUsuario> listaCliente = em.createQuery("select o from CatUsuario o WHERE o.catRol.descripcion = 'Cliente'").getResultList();
    	return listaCliente;
    }
}
