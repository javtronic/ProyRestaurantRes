package proyecto.restaurante.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_menu database table.
 * 
 */
@Entity
@Table(name="detalle_menu")
@NamedQuery(name="DetalleMenu.findAll", query="SELECT d FROM DetalleMenu d")
public class DetalleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLE_MENU_IDDETMENU_GENERATOR", sequenceName="SEQ_DETALLE_MENU", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLE_MENU_IDDETMENU_GENERATOR")
	@Column(name="id_det_menu", unique=true, nullable=false)
	private Integer idDetMenu;

	//bi-directional many-to-one association to CatPlato
	@ManyToOne
	@JoinColumn(name="id_plato")
	private CatPlato catPlato;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="id_menu")
	private Menu menu;

	public DetalleMenu() {
	}

	public Integer getIdDetMenu() {
		return this.idDetMenu;
	}

	public void setIdDetMenu(Integer idDetMenu) {
		this.idDetMenu = idDetMenu;
	}

	public CatPlato getCatPlato() {
		return this.catPlato;
	}

	public void setCatPlato(CatPlato catPlato) {
		this.catPlato = catPlato;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}