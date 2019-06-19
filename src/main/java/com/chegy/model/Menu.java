package com.chegy.model;
// Generated 2019-6-12 8:38:37 by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Menu generated by hbm2java
 */
@Entity
@Table(name = "menu", catalog = "rbac")
public class Menu implements java.io.Serializable {

	private Integer id;
	private Menu parent;
	private String menuName;
	private String url;
	private String perms;
	private Integer orderNum;
	private Date createTime;
	private Date modifyTime;
	private String icon;

	private Set<Role> roles;

	private Set<Menu> children = new HashSet<Menu>(0);

	public Menu() {
	}

	public Menu(Date createTime) {
		this.createTime = createTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public Menu getParent() {
		return this.parent;
	}

	public void setParent(Menu menu) {
		this.parent = menu;
	}

	@Column(name = "menu_name", length = 20)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "url", length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "perms", length = 50)
	public String getPerms() {
		return this.perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	@Column(name = "order_num")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_time", length = 19)
	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(name = "icon", length = 32)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	// 菜单 - 角色关系定义;
	@ManyToMany
	@JoinTable(name = "RoleMenu", joinColumns = { @JoinColumn(name = "menuId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
	public Set<Menu> getChildren() {
		return children;
	}


	public void setChildren(Set<Menu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", children=" + children + "]";
	}

	
}