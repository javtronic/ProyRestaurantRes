package proyecto.restaurante.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cat_usuarios database table.
 * 
 */
@Entity
@Table(name="cat_usuarios")
@NamedQuery(name="CatUsuario.findAll", query="SELECT c FROM CatUsuario c")
public class CatUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAT_USUARIOS_IDUS_GENERATOR", sequenceName="SEQ_CAT_USUARIOS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAT_USUARIOS_IDUS_GENERATOR")
	@Column(name="id_us", unique=true, nullable=false)
	private Integer idUs;

	@Column(name="apellido_us", length=70)
	private String apellidoUs;

	@Column(name="ciudad_us", length=70)
	private String ciudadUs;

	@Column(name="direccion_us", length=100)
	private String direccionUs;

	@Column(name="email_us", length=70)
	private String emailUs;

	@Temporal(TemporalType.DATE)
	@Column(name="fechanac_us")
	private Date fechanacUs;

	@Column(name="genero_us", length=20)
	private String generoUs;

	@Column(name="nombre_us", length=70)
	private String nombreUs;

	@Column(length=200)
	private String password;

	@Column(name="telefono_us", length=20)
	private String telefonoUs;

	@Column(length=20)
	private String username;

	//bi-directional many-to-one association to CatRol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private CatRol catRol;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="catUsuario")
	private List<Reserva> reservas;

	public CatUsuario() {
	}

	public Integer getIdUs() {
		return this.idUs;
	}

	public void setIdUs(Integer idUs) {
		this.idUs = idUs;
	}

	public String getApellidoUs() {
		return this.apellidoUs;
	}

	public void setApellidoUs(String apellidoUs) {
		this.apellidoUs = apellidoUs;
	}

	public String getCiudadUs() {
		return this.ciudadUs;
	}

	public void setCiudadUs(String ciudadUs) {
		this.ciudadUs = ciudadUs;
	}

	public String getDireccionUs() {
		return this.direccionUs;
	}

	public void setDireccionUs(String direccionUs) {
		this.direccionUs = direccionUs;
	}

	public String getEmailUs() {
		return this.emailUs;
	}

	public void setEmailUs(String emailUs) {
		this.emailUs = emailUs;
	}

	public Date getFechanacUs() {
		return this.fechanacUs;
	}

	public void setFechanacUs(Date fechanacUs) {
		this.fechanacUs = fechanacUs;
	}

	public String getGeneroUs() {
		return this.generoUs;
	}

	public void setGeneroUs(String generoUs) {
		this.generoUs = generoUs;
	}

	public String getNombreUs() {
		return this.nombreUs;
	}

	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefonoUs() {
		return this.telefonoUs;
	}

	public void setTelefonoUs(String telefonoUs) {
		this.telefonoUs = telefonoUs;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CatRol getCatRol() {
		return this.catRol;
	}

	public void setCatRol(CatRol catRol) {
		this.catRol = catRol;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setCatUsuario(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCatUsuario(null);

		return reserva;
	}

}