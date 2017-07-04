/*
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import Entities.Rol;
import SessionBeans.RolFacadeLocal;

/**
 *
 * @author BryanV
 */
@ManagedBean
@ViewScoped
public class RolBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeNode root;
	private TreeNode selectedNode;
	private TreeNode[] selectedNodes;

	private Rol rol;

	@EJB
	private RolFacadeLocal tipoUsuarioFacadeLocal;

	private List<Rol> roles;
	private List<Rol> rolesFiltered;

	private boolean editMode;

	HashMap<String, Object> nodesMap;
	HashMap<String, Object> rolesMap;

	public RolBean() {

	}

	@PostConstruct
	public void inicio() {

		editMode = false;

		rol = new Rol();

		roles = tipoUsuarioFacadeLocal.findAll();

		createCheckboxRoles();

	}

	public void createCheckboxRoles() {

		root = new DefaultTreeNode("ROOT", null);

		nodesMap = new HashMap<>();

		rolesMap = new HashMap<>();

		for (Rol rol : roles) {

			nodesMap.put(rol.getNombreRol(),
					new DefaultTreeNode(rol.getNombreRol(), root));

			rolesMap.put(rol.getNombreRol(), rol.getIdPadre());

		}

		for (Map.Entry<String, Object> entry : nodesMap.entrySet()) {

			DefaultTreeNode node = (DefaultTreeNode) nodesMap.get(entry
					.getKey());

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

	public void addRol() {

		String message = null;

		try {

			if (isEditMode()) {

				tipoUsuarioFacadeLocal.edit(rol);
				message = "El rol '" + rol.getNombreRol()
						+ "' ha sido editado";

				editMode = false;

			} else {

				rol.setNombreRol(rol.getNombreRol().toUpperCase());
				rol.setIdPadre(root.getData().toString());

				message = "El rol '" + rol.getNombreRol() + "' ya existe";

				if (tipoUsuarioFacadeLocal.findByName(rol.getNombreRol()) == null) {
					roles.add(0, rol);
					tipoUsuarioFacadeLocal.create(rol);
					message = "El rol '" + rol.getNombreRol()
							+ "' ha sido creado";
				}
			}

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		FacesMessage mensaje = new FacesMessage(message, null);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);

		rol = new Rol();

		roles = tipoUsuarioFacadeLocal.findAll();

		RequestContext.getCurrentInstance().reset("form:rolSelected");

		createCheckboxRoles();

	}

	public static boolean findNode(final TreeNode selectedNode,
			final TreeNode parent) {
		if (selectedNode.getChildCount() > 0) {
			final Iterator<TreeNode> childs = selectedNode.getChildren()
					.iterator();
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

	public void editRow(Rol tipoUsuario) {

		RequestContext.getCurrentInstance().reset("form:rolSelected");

		rol = tipoUsuario;

		editMode = true;

	}

	public void onDragDrop(TreeDragDropEvent event) {
		TreeNode dragNode = event.getDragNode();
		TreeNode dropNode = event.getDropNode();

		try {

			Rol tipoUsuario = tipoUsuarioFacadeLocal.findByName(dragNode
					.getData().toString());
			tipoUsuario.setIdPadre(dropNode.getData().toString());
			tipoUsuarioFacadeLocal.edit(tipoUsuario);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		FacesMessage message = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"Rol " + dragNode.getData() + " movido a " + dropNode.getData(),
				"");
		FacesContext.getCurrentInstance().addMessage(null, message);

		roles = tipoUsuarioFacadeLocal.findAll();
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
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

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
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

	

	

}