package proyecto.restaurante.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_mesa database table.
 * 
 */
@Entity
@Table(name="cat_mesa")
@NamedQuery(name="CatMesa.findAll", query="SELECT c FROM CatMesa c")
public class CatMesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAT_MESA_IDMESA_GENERATOR", sequenceName="SEQ_CAT_MESA", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAT_MESA_IDMESA_GENERATOR")
	@Column(name="id_mesa", unique=true, nullable=false)
	private Integer idMesa;

	@Column(name="num_mesa")
	private Integer numMesa;

	@Column(name="num_sillas")
	private Integer numSillas;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="catMesa")
	private List<Reserva> reservas;

	public CatMesa() {
	}

	public Integer getIdMesa() {
		return this.idMesa;
	}

	public void setIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
	}

	public Integer getNumMesa() {
		return this.numMesa;
	}

	public void setNumMesa(Integer numMesa) {
		this.numMesa = numMesa;
	}

	public Integer getNumSillas() {
		return this.numSillas;
	}

	public void setNumSillas(Integer numSillas) {
		this.numSillas = numSillas;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setCatMesa(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCatMesa(null);

		return reserva;
	}

}