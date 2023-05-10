package com.empty_works.plain_emrs.util;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;


public class BlobConverter {

	public static Blob convert(Connection con, String str) {
		
		Blob blob = null;
		try {
			blob = con.createBlob();
			blob.setBytes(1, str.getBytes());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blob;
	}
}
