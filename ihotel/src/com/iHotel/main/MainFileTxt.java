package com.iHotel.main;

import java.io.IOException;

import com.iHotel.model.MAlbergo;

public class MainFileTxt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MAlbergo albergo = MAlbergo.getInstance();
		System.out.println(albergo.get_nome());
	}
}
