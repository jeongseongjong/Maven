package com.biz.oracle.service;

import java.util.List;
import java.util.Map;

import com.biz.oracle.config.DBConnection;
import com.biz.oracle.mapper.IolistDao;

public class IolistServiceV1 {

	IolistDao iDao = null;

	public IolistServiceV1() {

		iDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(IolistDao.class);
	}

	public void selectMapListView() {

		List<Map<String, Object>> iolist = iDao.selectAll();

		for (Map<String, Object> io : iolist) {
			System.out.print(io.get("IO_SEQ").toString() + "\t");
			System.out.print(io.get("IO_DATE").toString() + "\t");
			System.out.print(io.get("IO_INOUT").toString() + "\t");
			System.out.print(io.get("IO_QTY").toString() + "\t");
			System.out.print(io.get("IO_PRICE").toString() + "\t");
			System.out.print(io.get("IO_TOTAL").toString() + "\t");
			System.out.print(io.get("IO_PCODE").toString() + "\t");
			System.out.print(io.get("IO_DCODE").toString() + "\n");
		}

	}
}
