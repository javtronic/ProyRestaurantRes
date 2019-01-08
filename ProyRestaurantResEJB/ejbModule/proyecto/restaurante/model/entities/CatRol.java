package proyecto.restaurante.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_rol database table.
 * 
 */
@Entity
@Table(name="cat_rol")
@NamedQuery(name="CatRol.findAll", query="SELECT c FROM CatRol c")
public class CatRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAT_ROL_IDROL_GENERATOR", sequenceName="SEQ_CAT_ROL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAT_ROL_IDROL_GENERATOR")
	@Column(name="id_rol", unique=true, nullable=false)
	private Integer idRol;

	@Column(length=200)
	private String descripcion;

	//bi-directional many-to-one association to CatUsuario
	@OneToMany(mappedBy="catRol")
	private List<CatUsuario> catUsuarios;

	public CatRol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CatUsuario> getCatUsuarios() {
		return this.catUsuarios;
	}

	public void setCatUsuarios(List<CatUsuario> catUsuarios) {
		this.catUsuarios = catUsuarios;
	}

	public CatUsuario addCatUsuario(CatUsuario catUsuario) {
		getCatUsuarios().add(catUsuario);
		catUsuario.setCatRol(this);

		return catUsuario;
	}

	public CatUsuario removeCatUsuario(CatUsuario catUsuario) {
		getCatUsuarios().remove(catUsuario);
		catUsuario.setCatRol(null);

		return catUsuario;
	}

}