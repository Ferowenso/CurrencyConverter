package com.example.currencyconverter.utils;

import com.example.currencyconverter.models.Valute;
import com.example.currencyconverter.pojo.ValCursPojo;
import com.example.currencyconverter.pojo.ValutePojo;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.List;

public class CbrRequest {

    public static List<ValutePojo> getValutes() throws IOException {
        OkHttpClient client = new OkHttpClient();
        XmlMapper xmlMapper = XmlMapper.xmlBuilder().addModule(new JavaTimeModule()).build();
        Request request = new Request.Builder()
                .url("http://www.cbr.ru/scripts/xml_daily.asp")
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ValCursPojo response = xmlMapper.readValue(responseBody.string(), ValCursPojo.class);
        return response.getValute();
    }

}
