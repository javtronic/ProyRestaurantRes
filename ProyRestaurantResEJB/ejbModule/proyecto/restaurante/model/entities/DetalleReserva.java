package proyecto.restaurante.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_reservas database table.
 * 
 */
@Entity
@Table(name="detalle_reservas")
@NamedQuery(name="DetalleReserva.findAll", query="SELECT d FROM DetalleReserva d")
public class DetalleReserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLE_RESERVAS_IDDETARES_GENERATOR", sequenceName="SEQ_DETALLE_RESERVAS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLE_RESERVAS_IDDETARES_GENERATOR")
	@Column(name="id_deta_res", unique=true, nullable=false)
	private Integer idDetaRes;

	//bi-directional many-to-one association to CatPlato
	@ManyToOne
	@JoinColumn(name="id_plato")
	private CatPlato catPlato;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="id_reserva")
	private Reserva reserva;

	public DetalleReserva() {
	}

	public Integer getIdDetaRes() {
		return this.idDetaRes;
	}

	public void setIdDetaRes(Integer idDetaRes) {
		this.idDetaRes = idDetaRes;
	}

	public CatPlato getCatPlato() {
		return this.catPlato;
	}

	public void setCatPlato(CatPlato catPlato) {
		this.catPlato = catPlato;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}