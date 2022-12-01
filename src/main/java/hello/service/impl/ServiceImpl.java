package hello.service.impl;

import hello.dto.Walmart;
import hello.service.Service;

public class ServiceImpl implements Service {

	@Override
	public Walmart getInformacion() {
		Walmart walmart = new Walmart();
		walmart.setPais("EUA");
		walmart.setOficina("Texas");
		walmart.setInformacion("POC-MEX");

		System.out.print("EUA");
		System.out.print("Texas");
		System.out.print("POC");

		return walmart;
	}

}
