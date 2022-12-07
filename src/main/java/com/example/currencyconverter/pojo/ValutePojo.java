package com.example.currencyconverter.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class ValutePojo {

	@JsonIgnore
	@JacksonXmlProperty(localName = "ID")
	private Long ID;
	@JacksonXmlProperty(localName = "NumCode")
	private int NumCode;
	@JacksonXmlProperty(localName = "CharCode")
	private String CharCode;
	@JacksonXmlProperty(localName = "Nominal")
	private int Nominal;
	@JacksonXmlProperty(localName = "Name")
	private String Name;
	@JacksonXmlProperty(localName = "Value")
	private String Value;

	@Override
	public String toString() {
		return "Valute{" +
				"NumCode=" + NumCode +
				", CharCode='" + CharCode + '\'' +
				", Nominal=" + Nominal +
				", Name='" + Name + '\'' +
				", Value=" + Value +
				'}';
	}

}

