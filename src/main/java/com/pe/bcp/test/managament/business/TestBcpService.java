package com.pe.bcp.test.managament.business;

import com.pe.bcp.test.managament.model.api.TipoCambioDTO;
import com.pe.bcp.test.managament.model.api.TipoCambioRequest;

import io.reactivex.Single;

public interface TestBcpService {

	public Single<TipoCambioDTO> getTipoCambio(TipoCambioRequest request);

}
