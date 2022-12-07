package com.example.currencyconverter.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ValCursPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JacksonXmlElementWrapper(useWrapping = false)
	private List<ValutePojo> Valute;

	@JacksonXmlProperty(localName = "Date")
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate date;
	private String name;

	@Override
	public String toString() {
		return "ValCurs{" +
				"Valute=" + Valute +
				", Date='" + date + '\'' +
				", name='" + name + '\'' +
				'}';
	}}

