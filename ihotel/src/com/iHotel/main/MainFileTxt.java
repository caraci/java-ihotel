package com.iHotel.main;

import java.io.IOException;

import com.iHotel.model.MAlbergo;
import com.iHotel.model.MPeriodo;

public class MainFileTxt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MAlbergo albergo = MAlbergo.getInstance();
		System.out.println(albergo.get_telefono());
		MPeriodo periodo = new MPeriodo();
		System.out.println(periodo.get_oraFine());
		System.out.println(periodo.get_minutoFine());
		System.out.println(periodo.get_oraInizio());
		System.out.println(periodo.get_minutoInizio());
	}
}
