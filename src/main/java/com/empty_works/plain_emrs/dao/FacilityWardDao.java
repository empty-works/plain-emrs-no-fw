package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class FacilityWardDao {

	public static List<FacilityWardBean> getList() {
		
		List<FacilityWardBean> list = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("select ward_id, name, location from wards");
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				
				FacilityWardBean fwb = new FacilityWardBean();
				fwb.setWardId(resultSet.getString("ward_id"));
				fwb.setName(resultSet.getString("name"));
				fwb.setLocation(resultSet.getString("location"));
				list.add(fwb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
