/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import Entities.Usuario;

/**
 *
 * @author Bryan
 */
@Local
public interface UsuarioFacadeLocal {

	void create(Usuario usuario);

	void edit(Usuario usuario);

	void remove(Usuario usuario);

	Usuario find(Object id);

	List<Usuario> findAll();

	List<Usuario> findRange(int[] range);

	int count();

	List<String> obtenerPages(Usuario usuario);

	List<Integer> obtenerRoles(Usuario usuario);

	List<UserDetail> findUserDetails(Usuario usuario);

	Usuario findUserInformation(Usuario usuario);

	Usuario findByUserCode(String usuario);

	Usuario fetchInformationByUser(String usuario);

	Usuario fetchRolesByUser(String usuario);

	Usuario findByUserAndPassword(String usuario, String pass);

}