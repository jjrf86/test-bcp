package com.pe.bcp.test.managament.business.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.pe.bcp.test.managament.business.TestBcpService;
import com.pe.bcp.test.managament.dao.TestBcpDao;
import com.pe.bcp.test.managament.entity.TipoCambio;
import com.pe.bcp.test.managament.model.api.TipoCambioDTO;
import com.pe.bcp.test.managament.model.api.TipoCambioRequest;

import io.reactivex.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.adapter.rxjava.RxJava2Adapter;

@Slf4j
@Service
@AllArgsConstructor
public class TestServiceImpl implements TestBcpService{
	
	private TestBcpDao testBcpDao;
	
	private final static String NUEVO_SOL_PERUANO = "PEN";
	
	private final static String DOLAR_AMERICANO = "USD";
	
	private final static String EURO = "EUR";
	
	
	@Override
	public Single<TipoCambioDTO> getTipoCambio(TipoCambioRequest request) {
		log.info("TestServiceImpl - getTipoCambio");
		return RxJava2Adapter
				.monoToSingle(testBcpDao
						.findByMonedaOrigenAndMonedaDestino(request.getMonedaOrigen(),
								request.getMonedaDestino()))
				.map(tipoCambio -> buildTipoCambio(tipoCambio,request));
	}
	
	private TipoCambioDTO buildTipoCambio(TipoCambio tipoCambio,TipoCambioRequest request) {
		return TipoCambioDTO.builder()
				.monedaDestino(tipoCambio.getMonedaDestino())
				.monedaOrigen(tipoCambio.getMonedaOrigen())
				.tipoCambio(tipoCambio.getTipoCambio())
				.monto(request.getMonto())
				.montoTipoCambio(calculateMonto(tipoCambio,request.getMonto()))
				.build();
	}

	private Double calculateMonto(TipoCambio tipoCambio, Double monto) {
		
		Double montoTipoCambio = 0.0;
		
		Double montoResult = 0.0;
		
		if(NUEVO_SOL_PERUANO.equals(tipoCambio.getMonedaOrigen()) ) {
			montoResult = monto / tipoCambio.getTipoCambio();
			
		}else if(DOLAR_AMERICANO.equals(tipoCambio.getMonedaOrigen()) || EURO.equals(tipoCambio.getMonedaOrigen())) {
			montoResult = monto * tipoCambio.getTipoCambio();
		}
		
		montoTipoCambio = new BigDecimal(montoResult).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		return montoTipoCambio;
	}
}