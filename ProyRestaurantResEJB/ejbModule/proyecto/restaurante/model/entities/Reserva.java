package proyecto.restaurante.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@Table(name="reserva")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESERVA_IDRESERVA_GENERATOR", sequenceName="SEQ_RESERVA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESERVA_IDRESERVA_GENERATOR")
	@Column(name="id_reserva", unique=true, nullable=false)
	private Integer idReserva;

	@Column(name="cantidad_bebidas")
	private Integer cantidadBebidas;

	@Column(name="cantidad_platos")
	private Integer cantidadPlatos;

	@Column(name="detalle_res", length=70)
	private String detalleRes;

	@Column(length=30)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_res")
	private Date fechaRes;

	@Column(name="hora_res")
	private Time horaRes;

	@Column(length=200)
	private String observacion;

	//bi-directional many-to-one association to DetalleReserva
	@OneToMany(mappedBy="reserva")
	private List<DetalleReserva> detalleReservas;

	//bi-directional many-to-one association to CatMesa
	@ManyToOne
	@JoinColumn(name="id_mesa")
	private CatMesa catMesa;

	//bi-directional many-to-one association to CatUsuario
	@ManyToOne
	@JoinColumn(name="id_us")
	private CatUsuario catUsuario;

	public Reserva() {
	}

	public Integer getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Integer getCantidadBebidas() {
		return this.cantidadBebidas;
	}

	public void setCantidadBebidas(Integer cantidadBebidas) {
		this.cantidadBebidas = cantidadBebidas;
	}

	public Integer getCantidadPlatos() {
		return this.cantidadPlatos;
	}

	public void setCantidadPlatos(Integer cantidadPlatos) {
		this.cantidadPlatos = cantidadPlatos;
	}

	public String getDetalleRes() {
		return this.detalleRes;
	}

	public void setDetalleRes(String detalleRes) {
		this.detalleRes = detalleRes;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRes() {
		return this.fechaRes;
	}

	public void setFechaRes(Date fechaRes) {
		this.fechaRes = fechaRes;
	}

	public Time getHoraRes() {
		return this.horaRes;
	}

	public void setHoraRes(Time horaRes) {
		this.horaRes = horaRes;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<DetalleReserva> getDetalleReservas() {
		return this.detalleReservas;
	}

	public void setDetalleReservas(List<DetalleReserva> detalleReservas) {
		this.detalleReservas = detalleReservas;
	}

	public DetalleReserva addDetalleReserva(DetalleReserva detalleReserva) {
		getDetalleReservas().add(detalleReserva);
		detalleReserva.setReserva(this);

		return detalleReserva;
	}

	public DetalleReserva removeDetalleReserva(DetalleReserva detalleReserva) {
		getDetalleReservas().remove(detalleReserva);
		detalleReserva.setReserva(null);

		return detalleReserva;
	}

	public CatMesa getCatMesa() {
		return this.catMesa;
	}

	public void setCatMesa(CatMesa catMesa) {
		this.catMesa = catMesa;
	}

	public CatUsuario getCatUsuario() {
		return this.catUsuario;
	}

	public void setCatUsuario(CatUsuario catUsuario) {
		this.catUsuario = catUsuario;
	}

}