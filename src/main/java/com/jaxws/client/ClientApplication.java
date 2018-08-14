package com.jaxws.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;



@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args)throws DatatypeConfigurationException {
		SpringApplication.run(ClientApplication.class, args);
		SayHiService service = new SayHiServiceService().getSayHiServicePort();

		// sayhi
		service.sayHiDefault();
		service.sayHi("Ahe");

		// checktime
		// 这里主要说一下时间日期的xml传递，方法还略显复杂
		GregorianCalendar calender = new GregorianCalendar();
		calender.setTime(new Date(System.currentTimeMillis()));
		XMLGregorianCalendar xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
		System.out.println(service.checkTime(xmldate));

		service.sayHi("123");
	}
}
