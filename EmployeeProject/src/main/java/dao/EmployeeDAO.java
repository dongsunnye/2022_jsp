package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	
	private Connection conn;
	
	private EmployeeDAO() {	
		conn = DBManager.getInstance().getConn();		
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public EmployeeDTO login(String eno, String name) {
		String sql = "select e.*, es.salary "
				+ "from employee e, employee_salary es "
				+ "where e.eno = es.eno and e.eno like ? and e.name like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeDTO dto = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	public ArrayList<EmployeeDTO> selectAllEmployee() {
		String sql = "select e.*, es.salary "
				+ "from employee e, employee_salary es where e.eno = es.eno";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), 
						 rs.getString(3), rs.getInt(4), rs.getInt(5)));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt);
		}
		
		return list;
	}

	public ArrayList<String> selectAllPosition() {
		String sql = "select name from position_list order by pno";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();

		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 list.add(rs.getString(1));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt);
		}
		
		return list;
	}

	public void deleteEmployee(String eno) {
		String sql = "delete from employee where eno like ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pstmt);
		}
		
	}

	public void updateEmployee(EmployeeDTO dto) {
		String sql = "update employee set name=?,department=?,position=? where eno like ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getDept());
			pstmt.setInt(3, dto.getPosition());
			pstmt.setString(4, dto.getEno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pstmt);
		}
		
	}

	public void updateSalary(String eno, int salary) {
		String sql = "update employee_salary set salary=? where eno like ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, salary);
			pstmt.setString(2, eno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pstmt);
		}
	}

	public void insertEmployee(EmployeeDTO dto) {
		String sql = "insert into employee values(?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEno());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getDept());
			pstmt.setInt(4, dto.getPosition());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pstmt);
		}
		
		
	}

	public void insertSalary(String eno, int salary) {
		String sql = "insert into employee_salary values(?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			pstmt.setInt(2, salary);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null, pstmt);
		}
	}

	public ArrayList<EmployeeDTO> selectEmployee(String kind, String search) {
		String sql = "select e.*, es.salary "
				+ "from employee e, employee_salary es where e.eno = es.eno and "
				+ "e." + kind + " like '%' || ? || '%'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), 
						 rs.getString(3), rs.getInt(4), rs.getInt(5)));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt);
		}
		
		return list;
	}

	
	
}









