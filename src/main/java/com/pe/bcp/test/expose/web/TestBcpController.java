package com.pe.bcp.test.expose.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pe.bcp.test.managament.business.TestBcpService;
import com.pe.bcp.test.managament.model.api.TipoCambioDTO;
import com.pe.bcp.test.managament.model.api.TipoCambioRequest;
import com.pe.bcp.test.managament.model.api.TipoCambioResponse;

import io.reactivex.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/channel/bcp/test/v1")
public class TestBcpController {
	
	private TestBcpService testBcpService;
	
	@Validated
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/tipocambio", produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<TipoCambioResponse> getTipoCambio(TipoCambioRequest request) {
		log.info("TestBcpController - getTipoCambio");
		return testBcpService.getTipoCambio(request)
				.map(this::parse);
	}
	
	private TipoCambioResponse parse(TipoCambioDTO tipoCambioDTO) {
		return TipoCambioResponse.builder()
				.monedaDestino(tipoCambioDTO.getMonedaDestino())
				.monedaOrigen(tipoCambioDTO.getMonedaOrigen())
				.monto(tipoCambioDTO.getMonto())
				.montoTipoCambio(tipoCambioDTO.getMontoTipoCambio())
				.tipoCambio(tipoCambioDTO.getTipoCambio())
				.build();
	}
}