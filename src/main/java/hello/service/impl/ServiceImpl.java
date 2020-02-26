package hello.service.impl;

import hello.dto.Walmart;
import hello.service.Service;

public class ServiceImpl implements Service {

	@Override
	public Walmart getInformacion() {
		Walmart walmart = new Walmart();
		walmart.setPais("MX");
		walmart.setOficina("CDMX");
		walmart.setInformacion("POC-MEX");
		return walmart;
	}

}
