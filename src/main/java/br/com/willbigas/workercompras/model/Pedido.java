package br.com.willbigas.workercompras.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Pedido implements Serializable {

	private Long id;
	private String nome;
	private Long produto;
	private BigDecimal valor;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date dataCompra;
	private String cpfCliente;
	private String cep;
	private String email;
	private Cartao cartao;
}
