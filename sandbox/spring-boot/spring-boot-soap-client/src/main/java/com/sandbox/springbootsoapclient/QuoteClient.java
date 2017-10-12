package com.sandbox.springbootsoapclient;

import hello.wsdl.GetQuote;
import hello.wsdl.GetQuoteResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class QuoteClient extends WebServiceGatewaySupport {
    public GetQuoteResponse getQuote(String ticker) {

        GetQuote request = new GetQuote();
        request.setSymbol(ticker);

        log.info("Requesting quote for " + ticker);

        GetQuoteResponse response = (GetQuoteResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.com/stockquote.asmx",
                        request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetQuote"));

        return response;
    }

}