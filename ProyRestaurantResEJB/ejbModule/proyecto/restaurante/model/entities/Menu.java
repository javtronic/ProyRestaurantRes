package proyecto.restaurante.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENU_IDMENU_GENERATOR", sequenceName="SEQ_MENU", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENU_IDMENU_GENERATOR")
	@Column(name="id_menu", unique=true, nullable=false)
	private Integer idMenu;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_menu")
	private Date fechaMenu;

	@Column(name="nombre_menu", length=100)
	private String nombreMenu;

	//bi-directional many-to-one association to DetalleMenu
	@OneToMany(mappedBy="menu")
	private List<DetalleMenu> detalleMenus;

	public Menu() {
	}

	public Integer getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public Date getFechaMenu() {
		return this.fechaMenu;
	}

	public void setFechaMenu(Date fechaMenu) {
		this.fechaMenu = fechaMenu;
	}

	public String getNombreMenu() {
		return this.nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public List<DetalleMenu> getDetalleMenus() {
		return this.detalleMenus;
	}

	public void setDetalleMenus(List<DetalleMenu> detalleMenus) {
		this.detalleMenus = detalleMenus;
	}

	public DetalleMenu addDetalleMenus(DetalleMenu detalleMenus) {
		getDetalleMenus().add(detalleMenus);
		detalleMenus.setMenu(this);

		return detalleMenus;
	}

	public DetalleMenu removeDetalleMenus(DetalleMenu detalleMenus) {
		getDetalleMenus().remove(detalleMenus);
		detalleMenus.setMenu(null);

		return detalleMenus;
	}

}