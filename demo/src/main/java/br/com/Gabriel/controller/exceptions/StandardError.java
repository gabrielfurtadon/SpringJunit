package br.com.Gabriel.controller.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

	//atributos que sairam no console com o erro quando procura o user 3
	private LocalDateTime timestamp; 
	private Integer status;
	private String error;
	private String path;
	
}

