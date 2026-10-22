package app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int ano;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="marca_id")
	private Marca marca;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="carro_proprietario",
		joinColumns = @JoinColumn(name="proprietario_id")
	)
	private List<Proprietario> proprietarios;
	
}
