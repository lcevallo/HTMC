/*
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import Entities.Rol;
import Entities.Usuario;
import SessionBeans.RolFacadeLocal;
import SessionBeans.UsuarioFacadeLocal;

/**
 *
 * @author BryanV
 */
@ManagedBean
@ViewScoped
public class UsuarioRolBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeNode root;
	private TreeNode[] selectedNodes;

	private Rol rol;
	private Usuario usuario;

	@EJB
	private RolFacadeLocal tipoUsuarioFacadeLocal;

	@EJB
	private UsuarioFacadeLocal usuarioFacadeLocal;

	private List<Rol> roles;
	private List<Rol> rolesFiltered;

	private List<Rol> parentRoles;

	private List<Usuario> usuarios;
	private List<Usuario> usuariosFiltered;

	private HashMap<String, Object> nodesMap;
	private HashMap<String, Object> rolesMap;

	private HashMap<String, Rol> rolMap;

	private boolean usuarioSelected;

	public UsuarioRolBean() {

	}

	@PostConstruct
	public void inicio() {

		rol = new Rol();
		usuario = new Usuario();

		parentRoles = new ArrayList<>();

		roles = tipoUsuarioFacadeLocal.findAll();
		usuarios = usuarioFacadeLocal.findAll();

		fillHashMap();

		createCheckboxRoles();

	}

	public void fillHashMap() {

		rolMap = new HashMap<String, Rol>();
		for (Rol rol : roles)
			rolMap.put(rol.getNombreRol(), rol);

	}

	public void createCheckboxRoles() {

		root = new DefaultTreeNode("ROOT", null);

		nodesMap = new HashMap<>();

		rolesMap = new HashMap<>();

		for (Rol rol : roles) {

			nodesMap.put(rol.getNombreRol(), new DefaultTreeNode(rol.getNombreRol(), root));

			rolesMap.put(rol.getNombreRol(), rol.getIdPadre());

		}

		for (Map.Entry<String, Object> entry : nodesMap.entrySet()) {

			DefaultTreeNode node = (DefaultTreeNode) nodesMap.get(entry.getKey());

			String padre = (String) rolesMap.get(entry.getKey());

			if (!padre.equals("ROOT")) {
				DefaultTreeNode parent = (DefaultTreeNode) node.getParent();
				List<org.primefaces.model.TreeNode> children = new ArrayList<TreeNode>();

				children.addAll(parent.getChildren());

				parent.getChildren().clear();
				children.remove(node);

				parent.setChildren(children);
				((DefaultTreeNode) nodesMap.get(padre)).getChildren().add(node);

			}

		}

	}

	public static boolean findNode(final TreeNode selectedNode, final TreeNode parent) {
		if (selectedNode.getChildCount() > 0) {
			final Iterator<TreeNode> childs = selectedNode.getChildren().iterator();
			while (childs.hasNext()) {
				final TreeNode currentNode = childs.next();

				if (currentNode.equals(parent)) {
					return true;
				}

				if (currentNode.isLeaf()) {

				} else {
					findNode(currentNode, parent);
				}
			}
		}

		return false;

	}

	public void resetPanelRoles() {
		parentRoles = new ArrayList<>();

		for (Map.Entry<String, Object> entry : nodesMap.entrySet()) {

			DefaultTreeNode node = (DefaultTreeNode) nodesMap.get(entry.getKey());

			node.setSelected(false);
			node.setExpanded(false);

		}
	}

	public void buscarRoles(Usuario usuario) {

		try {

			resetPanelRoles();

			this.usuario = (Usuario) usuarioFacadeLocal.fetchRolesByUser(usuario.getUsuario());

			if (this.usuario != null) {
				roles = new ArrayList<Rol>(this.usuario.getRoles());				
				

				selectedNodes = new DefaultTreeNode[roles.size()];

				int index = 0;

				for (Rol tipoUsuario : roles) {

					DefaultTreeNode node = (DefaultTreeNode) nodesMap.get(tipoUsuario.getNombreRol());
					selectedNodes[index++] = (TreeNode) node;
					node.setSelected(true);
					node.setExpanded(true);
					if (node.getParent().getData().toString().equals("ROOT"))
						parentRoles.add(tipoUsuario);

				}
			}

			this.usuario = usuario;
			setUsuarioSelected(true);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public void guardar() {

		if (usuarioSelected) {

			HashSet<TreeNode> set = new HashSet<>();

			for (TreeNode treeNode : selectedNodes) {
				set.add(treeNode);
				set.add(treeNode.getParent());
			}

			set.remove(root);

			List<Rol> lista = new ArrayList<Rol>();

			Iterator<TreeNode> iterator = set.iterator();
			while (iterator.hasNext()) {
				TreeNode node = iterator.next();
				lista.add(rolMap.get(node.getData().toString()));

			}

			this.usuario.setRoles(new HashSet<Rol>(lista));

			try {

				usuarioFacadeLocal.edit(this.usuario);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}

		setUsuarioSelected(false);
		resetPanelRoles();

	}

	public void onNodeSelect(NodeSelectEvent event) {

		if (usuarioSelected) {
			parentRoles.add(rolMap.get(findParent(event.getTreeNode())));
		}

	}

	public void onNodeUnselect(NodeUnselectEvent event) {

		if (usuarioSelected) {
			parentRoles.remove(rolMap.get(findParent(event.getTreeNode())));
		}

	}

	public String findParent(TreeNode node) {

		if (node.getParent().getData().toString().equals("ROOT"))
			return node.getData().toString();
		else
			return findParent(node.getParent());

	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosFiltered() {
		return usuariosFiltered;
	}

	public void setUsuariosFiltered(List<Usuario> usuariosFiltered) {
		this.usuariosFiltered = usuariosFiltered;
	}

	

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Rol> getRolesFiltered() {
		return rolesFiltered;
	}

	public void setRolesFiltered(List<Rol> rolesFiltered) {
		this.rolesFiltered = rolesFiltered;
	}

	public List<Rol> getParentRoles() {
		return parentRoles;
	}

	public void setParentRoles(List<Rol> parentRoles) {
		this.parentRoles = parentRoles;
	}

	public HashMap<String, Object> getNodesMap() {
		return nodesMap;
	}

	public void setNodesMap(HashMap<String, Object> nodesMap) {
		this.nodesMap = nodesMap;
	}

	public HashMap<String, Object> getRolesMap() {
		return rolesMap;
	}

	public void setRolesMap(HashMap<String, Object> rolesMap) {
		this.rolesMap = rolesMap;
	}

	public HashMap<String, Rol> getRolMap() {
		return rolMap;
	}

	public void setRolMap(HashMap<String, Rol> rolMap) {
		this.rolMap = rolMap;
	}

	public boolean isUsuarioSelected() {
		return usuarioSelected;
	}

	public void setUsuarioSelected(boolean usuarioSelected) {
		this.usuarioSelected = usuarioSelected;
	}

}