package com.bcp.mapper;


import java.text.DecimalFormatSymbols;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.bcp.model.TipoCambio;
import com.bcp.model.TipoCambioRequest;
import com.bcp.model.TipoCambioResponse;
import com.bcp.utils.Constants;

public class TipoCambioMapper {

    private TipoCambioMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static TipoCambioResponse contruirTipoCambioResponse(Double monto, String monedaOrigen, String monedaDestino) {

        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        
        double tipCambio = 0.00;
		double montoNuevo=0.00;
		if (monedaOrigen.equals(Constants.MONEDA_PEN) && monedaDestino.equals(Constants.MONEDA_USD))
		{

			tipCambio = 0.26;

			montoNuevo = monto*tipCambio;

		}
		if(monedaOrigen.equals(Constants.MONEDA_PEN) && monedaDestino.equals(Constants.MONEDA_EUR))
		{
			tipCambio = 0.24;
			montoNuevo = monto*tipCambio;

		}

		if (monedaOrigen.equals(Constants.MONEDA_USD) && monedaDestino.equals(Constants.MONEDA_PEN))
		{

			tipCambio = 3.78;
			montoNuevo = monto*tipCambio;
		}

		if (monedaOrigen.equals(Constants.MONEDA_USD) && monedaDestino.equals(Constants.MONEDA_EUR))
		{

			tipCambio = 0.90;
			montoNuevo = monto*tipCambio;
		}

		if (monedaOrigen.equals(Constants.MONEDA_EUR) && monedaDestino.equals(Constants.MONEDA_PEN))
		{
			tipCambio = 4.19;
			montoNuevo = monto *tipCambio;

		}


		if (monedaOrigen.equals(Constants.MONEDA_EUR) && monedaDestino.equals(Constants.MONEDA_USD))
		{
			tipCambio = 1.11;
			montoNuevo = monto*tipCambio;

		}
        
        TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();
        tipoCambioResponse.setMonto(monto);
        tipoCambioResponse.setMontocontipocambio(montoNuevo);
        tipoCambioResponse.setMonedaorigen(monedaOrigen);
        tipoCambioResponse.setMonedadestino(monedaDestino);
        tipoCambioResponse.setTipocambio(tipCambio);
        
        return tipoCambioResponse;
  
    }

    public static TipoCambio mapMonedaTipoCambio(TipoCambioRequest tipoCambioRequest) {
    	TipoCambio tipoCambioModel= new TipoCambio();

        BeanUtils.copyProperties(tipoCambioRequest, tipoCambioModel);
        tipoCambioModel.setFecregis(new Date());

        return tipoCambioModel;
    }
}
