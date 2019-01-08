package proyecto.restaurante.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_plato database table.
 * 
 */
@Entity
@Table(name="cat_plato")
@NamedQuery(name="CatPlato.findAll", query="SELECT c FROM CatPlato c")
public class CatPlato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAT_PLATO_IDPLATO_GENERATOR", sequenceName="SEQ_CAT_PLATO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAT_PLATO_IDPLATO_GENERATOR")
	@Column(name="id_plato", unique=true, nullable=false)
	private Integer idPlato;

	@Column(name="descripion_plato", length=200)
	private String descripionPlato;

	@Column(name="nombre_plato", length=50)
	private String nombrePlato;

	@Column(name="precio_plato")
	private double precioPlato;

	@Column(length=50)
	private String tipo;

	//bi-directional many-to-one association to DetalleMenu
	@OneToMany(mappedBy="catPlato")
	private List<DetalleMenu> detalleMenus;

	//bi-directional many-to-one association to DetalleReserva
	@OneToMany(mappedBy="catPlato")
	private List<DetalleReserva> detalleReservas;

	public CatPlato() {
	}

	public Integer getIdPlato() {
		return this.idPlato;
	}

	public void setIdPlato(Integer idPlato) {
		this.idPlato = idPlato;
	}

	public String getDescripionPlato() {
		return this.descripionPlato;
	}

	public void setDescripionPlato(String descripionPlato) {
		this.descripionPlato = descripionPlato;
	}

	public String getNombrePlato() {
		return this.nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public double getPrecioPlato() {
		return this.precioPlato;
	}

	public void setPrecioPlato(double precioPlato) {
		this.precioPlato = precioPlato;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<DetalleMenu> getDetalleMenus() {
		return this.detalleMenus;
	}

	public void setDetalleMenus(List<DetalleMenu> detalleMenus) {
		this.detalleMenus = detalleMenus;
	}

	public DetalleMenu addDetalleMenus(DetalleMenu detalleMenus) {
		getDetalleMenus().add(detalleMenus);
		detalleMenus.setCatPlato(this);

		return detalleMenus;
	}

	public DetalleMenu removeDetalleMenus(DetalleMenu detalleMenus) {
		getDetalleMenus().remove(detalleMenus);
		detalleMenus.setCatPlato(null);

		return detalleMenus;
	}

	public List<DetalleReserva> getDetalleReservas() {
		return this.detalleReservas;
	}

	public void setDetalleReservas(List<DetalleReserva> detalleReservas) {
		this.detalleReservas = detalleReservas;
	}

	public DetalleReserva addDetalleReserva(DetalleReserva detalleReserva) {
		getDetalleReservas().add(detalleReserva);
		detalleReserva.setCatPlato(this);

		return detalleReserva;
	}

	public DetalleReserva removeDetalleReserva(DetalleReserva detalleReserva) {
		getDetalleReservas().remove(detalleReserva);
		detalleReserva.setCatPlato(null);

		return detalleReserva;
	}

}