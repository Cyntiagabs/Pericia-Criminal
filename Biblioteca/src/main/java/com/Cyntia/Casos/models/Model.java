package com.Cyntia.Casos.models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {

	private Connection getConnection() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/dados?user=root&password=&useTimezone=true&serverTimezone=UTC");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return conn;
	}

	public void save(String nomeUsuario, String senha, String role) {

		Long id = null;

		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();

			stmt.executeUpdate("INSERT INTO `usuario` (`nome_usuario`, `senha`) VALUES ('" + nomeUsuario
					 + "', '" + senha + "')", Statement.RETURN_GENERATED_KEYS);

			rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				id = rs.getLong(1);
			}

			stmt.executeUpdate(
					"INSERT INTO `usuarios_roles` (`usuario_id`, `role_id`) VALUES ('" + id + "', '" + role + "')");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				}

				stmt = null;
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {
				}

				conn = null;
			}
		}
	}

	public void delete(Long id) {

		Connection conn = getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			
			stmt.executeUpdate("UPDATE `usuario` SET `senha` = 'demitido' WHERE `usuario`.`id` = " + id);
			stmt.executeUpdate("UPDATE `usuario` SET `demitido_em` = CURRENT_TIME() WHERE `usuario`.`id` = " + id);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				}

				stmt = null;
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {
				}

				conn = null;
			}
		}
	}
}
