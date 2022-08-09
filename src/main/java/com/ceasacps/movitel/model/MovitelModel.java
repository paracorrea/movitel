package com.ceasacps.movitel.model;



	
	import java.sql.Time;
	import java.util.Date;
	import java.util.Objects;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "Movitel")
	public class MovitelModel {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private Long id_movitel;
		private Date data;
		private String numero;
		private String local;
		private String estado;
		private Time duracao;
		private Double valor;
		
		public MovitelModel() {}
		
		public MovitelModel(Long id, Long id_movitel, Date data, String numero, String local, String estado, Time duracao,
				Double valor) {
			super();
			this.id = id;
			this.id_movitel = id_movitel;
			this.data = data;
			this.numero = numero;
			this.local = local;
			this.estado = estado;
			this.duracao = duracao;
			this.valor = valor;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId_movitel() {
			return id_movitel;
		}

		public void setId_movitel(Long id_movitel) {
			this.id_movitel = id_movitel;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public Time getDuracao() {
			return duracao;
		}

		public void setDuracao(Time duracao) {
			this.duracao = duracao;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MovitelModel other = (MovitelModel) obj;
			return Objects.equals(id, other.id);
		}
		
		

}
