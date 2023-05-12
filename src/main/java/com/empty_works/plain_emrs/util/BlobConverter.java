package com.empty_works.plain_emrs.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;


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
	
	public static String toStr(ResultSet rs, String parameter) {
		
		String result = "";
        try {
			InputStream input = rs.getBinaryStream(parameter);
			result = new BufferedReader(
					new InputStreamReader(input, StandardCharsets.UTF_8))
					.lines()
					.collect(Collectors.joining("\n"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return result;
	}
}