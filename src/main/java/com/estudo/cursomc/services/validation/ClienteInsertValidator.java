package com.estudo.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.estudo.cursomc.domain.enums.TipoCliente;
import com.estudo.cursomc.dto.ClienteNewDTO;
import com.estudo.cursomc.resources.exceptions.FieldMessage;
import com.estudo.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipo() == null)
			list.add(new FieldMessage("tipo", "O tipo não pode ser nulo"));
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISCA.getCod()) && !BR.isValidCpf(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "O CPF é inválido"));
		}
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURICA.getCod()) && !BR.isValidCnpj(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "O CNPJ é inválido"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}