package com.currencyexchange.currencyExchange.currencies.controller.grpc;


import com.currencyexchange.currencyExchange.CurrencyExchangeApplication;
import com.currencyexchange.currencyExchange.currencies.dto.CurrencyConversionRequestDto;
import com.currencyexchange.currencyExchange.currencies.dto.CurrencyConversionResponseDto;
import com.currencyexchange.currencyExchange.currencies.entity.Currency;
import com.currencyexchange.currencyExchange.currencies.service.CurrencyServices;
import io.grpc.stub.StreamObserver;
import lombok.extern.java.Log;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.ExchangeRequest;
import org.example.ExchangeResponse;
import org.example.CurrencyExchangeGrpc;
@Log
@GrpcService
public class ExchangeGrpcServer extends CurrencyExchangeGrpc.CurrencyExchangeImplBase {
    private final CurrencyServices currencyServices;

    public ExchangeGrpcServer(CurrencyServices currencyServices) {
        this.currencyServices = currencyServices;
    }

    public void getExchangeAmount (final ExchangeRequest req, final StreamObserver<ExchangeResponse> responseObserver){
        log.info("Received exchange request: " + req.toString());
//        var pair = req.getPair().split("/");
//        var result = currencyServices.convertCurrency()

        final ExchangeResponse result = currencyServices.getExchangeRate(req);
//        final ExchangeResponse resp = ExchangeResponse.newBuilder().setExchangedIncome(result.getExchangedIncome()).setExchangedExpense(result.getExchangedE()).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
