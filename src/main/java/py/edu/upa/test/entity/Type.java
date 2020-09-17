package py.edu.upa.test.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="type", schema="public")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "type_id_seq", sequenceName = "type_id_seq", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "type_id_seq")
	private Integer id;
	
	private String name;
	
	private String description;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	public Type() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}	
	

}
