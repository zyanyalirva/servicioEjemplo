package hello.service.impl;

import hello.dto.Walmart;
import hello.service.Service;

public class ServiceImpl implements Service {

	@Override
	public Walmart getInformacion() {
		Walmart walmart = new Walmart();
		walmart.setPais("FR");
		walmart.setOficina("XXX");
		walmart.setInformacion("POC4");
		return walmart;
	}

}
