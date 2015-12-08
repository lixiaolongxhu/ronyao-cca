package com.ronyao.cca.ui.vo;

/**树形菜单返回
 * 
 * @author user
 *
 */
public class TreeVo {

	private Integer id;
	private Integer parentId;
	
	private String url;

	private String text;   //extjs 4 tree 显示节点名称必须定义改属性
	private boolean leaf;  //extjs4 tree 设置为true表明本节点没有子节点
	
	
	
	
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
