package com.example.webstory.service;

import com.example.webstory.comm.DbConn;
import com.example.webstory.vo.People;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {
	

	
	public List<People> doSelect(){
	
		Connection conn = null; // DB �� connection �� ��ü�� ���� 
	    PreparedStatement ps = null;  // connection ��ü�� ���๮�� ������ ����(â��)
	    ResultSet rs = null;     // select ������� �޾ƿ�
	    String qry="";
		DbConn dbConn = new DbConn();
		conn = dbConn.getConn();

		List<People> list = new ArrayList<>();
				
		 try{ 
			    /* Result Set , Print */	
				qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
					+" from people ";
				
				ps = conn.prepareStatement(qry);
				rs = ps.executeQuery();

				People people = new People();

				while(rs.next()) {

					people.setStrID(rs.getString("id"));
					people.setStrName(rs.getString("name"));
					people.setStrAge(rs.getString("age"));
					people.setStrDati(rs.getString("dati"));

					list.add(people);
				}

			    System.out.println(list);
				System.out.println(list.size());

			
		   }catch (Exception e) {
				System.out.println("Error =>"+e);			
			 }finally {
				 /* Close */ 
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(conn != null) conn.close();			
				}catch (Exception e2) {			
				}
			}				
		
		  return list;
	}

}