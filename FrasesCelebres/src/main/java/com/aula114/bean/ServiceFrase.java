package com.aula114.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.Serializable;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.aula114.model.Autor;
import com.aula114.model.FraseCelebre;

@ManagedBean(name = "fraseService")
@ApplicationScoped

public class ServiceFrase implements Serializable {

	private Connection conn;
	private Set<String> lCategorias;
	private List<FraseCelebre> lFCategoria;
	private Set<String> lAutores;
	private List<FraseCelebre> lFAutores;

	
        private void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/frases_celebres?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root","root");
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		} catch (SQLException e) {
			System.out.println("El driver no ha podido ser importado");
		}
	}

	private void desconectar() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Set<String> mostrarCategorias() {
		lCategorias = new HashSet<String>();
		try {
			conectar();
			String sql = "select categoria from frases";
			PreparedStatement stmt1;
			stmt1 = conn.prepareStatement(sql);
			ResultSet rset = stmt1.executeQuery();
			while (rset.next()) {
				lCategorias.add(rset.getString("categoria"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			desconectar();
		}
		return lCategorias;
	}
	public List<FraseCelebre> mostrarFrasesPorCategoria(String categoriaSeleccionada) {
                FraseCelebre fc;
                Autor a;
		lFCategoria = new ArrayList<FraseCelebre>();
		try {
			conectar();
                        String sql = "select descripcion, nombre_completo, fecha_nac from autores, frases " + "where categoria = '"
                                        + categoriaSeleccionada + "' and autores.id_autor = frases.id_autor";

			PreparedStatement stmt2;
			stmt2 = conn.prepareStatement(sql);
			ResultSet rset = stmt2.executeQuery();
			while (rset.next()) {
				fc = new FraseCelebre();
				a = new Autor();
				a.setNombre(rset.getString("nombre_completo"));
				a.setFechaNac(rset.getDate("fecha_nac"));
				fc.setAutor(a);
				fc.setFrase(rset.getString("descripcion"));
				lFCategoria.add(fc);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			desconectar();
		}
		return lFCategoria;
	}

	public Set<String> mostrarAutores() {
		lAutores = new HashSet<String>();
		try {
			conectar();
			String sql = "select nombre_completo from autores";
			PreparedStatement stmt1;
			stmt1 = conn.prepareStatement(sql);
			ResultSet rset = stmt1.executeQuery();
			while (rset.next()) {
				lAutores.add(rset.getString("nombre_completo"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			desconectar();
		}
		return lAutores;
	}
	public List<FraseCelebre> mostrarFrasesPorAutor(String autorSeleccionado) {
                FraseCelebre fc;
                Autor a;
		lFAutores = new ArrayList<FraseCelebre>();
		try {
			conectar();
                        String sql = "select descripcion, nombre_completo, fecha_nac from autores, frases " + "where nombre_completo = '"
                                        + autorSeleccionado + "' and autores.id_autor = frases.id_autor";

			PreparedStatement stmt2;
			stmt2 = conn.prepareStatement(sql);
			ResultSet rset = stmt2.executeQuery();
			while (rset.next()) {
				fc = new FraseCelebre();
				a = new Autor();
				a.setNombre(rset.getString("nombre_completo"));
				a.setFechaNac(rset.getDate("fecha_nac"));
				fc.setAutor(a);
				fc.setFrase(rset.getString("descripcion"));
				lFAutores.add(fc);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			desconectar();
		}
		return lFAutores;
	}

	

}
